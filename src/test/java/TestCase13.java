
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.ProductsPage;
import Pages.CartPage;

public class TestCase13 {

    WebDriver browser;
    HomePage homePage;
    ProductsPage productPage;
    CartPage cartPage;

    @BeforeClass
    public void setUp() {
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://automationexercise.com");

        homePage = new HomePage(browser);
        productPage = new ProductsPage(browser);
        cartPage = new CartPage(browser);
    }

    @Test
    public void addProductToCart() throws InterruptedException {
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");
        
        productPage.clickViewProduct(0);

        Assert.assertTrue(productPage.isProductDetailVisible(), "Product detail not visible");
        
        productPage.setQuantity(4);

        productPage.clickAddToCart();

        Thread.sleep(1000);
        productPage.clickViewCartButton();

        String prodName = productPage.getProductName();
        Assert.assertTrue(cartPage.isProductDisplayed(prodName), "Product not displayed in cart");
        Assert.assertEquals(cartPage.getProductQuantity(prodName), 4, "Product quantity mismatch");
    }

    @AfterClass
    public void tearDown() {
        browser.quit();
    }
}
