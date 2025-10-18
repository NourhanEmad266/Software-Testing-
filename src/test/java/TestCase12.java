
import Pages.HomePage;
import Pages.ProductsPage;
import Pages.CartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase12{

    private WebDriver browser;
    private HomePage homePage;
    private ProductsPage productsPage;
    private CartPage cartPage;

    @BeforeMethod
    public void setUp() {
        browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        browser.manage().window().maximize();
        browser.get("http://automationexercise.com");

        homePage = new HomePage(browser);
        productsPage = new ProductsPage(browser);
        cartPage = new CartPage(browser);
    }

    @Test
    public void verifyAddProductsToCart() {
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is NOT visible!");

        homePage.clickProducts();
        Assert.assertTrue(productsPage.isAllProductsPageVisible(), "All Products page not visible!");

        productsPage.hoverAndAddFirstProduct();

        productsPage.clickContinueShopping();

        productsPage.hoverAndAddSecondProduct();

        productsPage.clickViewCart();

        Assert.assertTrue(cartPage.isFirstProductInCartVisible(), "First product not in cart!");
        Assert.assertTrue(cartPage.isSecondProductInCartVisible(), "Second product not in cart!");

        Assert.assertFalse(cartPage.getFirstProductPrice().isEmpty(), "First product price missing!");
        Assert.assertEquals(cartPage.getFirstProductQuantity(), "1", "First product quantity mismatch!");
        Assert.assertFalse(cartPage.getFirstProductTotal().isEmpty(), "First product total missing!");

        Assert.assertFalse(cartPage.getSecondProductPrice().isEmpty(), "Second product price missing!");
        Assert.assertEquals(cartPage.getSecondProductQuantity(), "1", "Second product quantity mismatch!");
        Assert.assertFalse(cartPage.getSecondProductTotal().isEmpty(), "Second product total missing!");
    }

    @AfterMethod
    public void tearDown() {
            browser.quit();
    }
}
