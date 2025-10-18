import Pages.HomePage;
import Pages.ProductsPage;
import Pages.ProductDetailsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase8 {

    private WebDriver browser;
    private HomePage homepage;
    private ProductsPage productPage;
    private ProductDetailsPage productDetails;

    @BeforeMethod
    public void setUpMethod() {
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://automationexercise.com");

        homepage = new HomePage(browser);
        productPage = new ProductsPage(browser);
    }

    @AfterMethod
    public void tearDown() {
            browser.quit();
    }
    @Test
    public void verifyProductDetailsFlow() {
        Assert.assertTrue(homepage.isHomePageVisible(), "Home page not visible");

        homepage.clickProducts();

        Assert.assertTrue(productPage.isAllProductsPageVisible(), "All Products page not visible");

        Assert.assertTrue(productPage.isProductsListVisible(), "Products list not visible");

        productPage.viewFirstProduct();

        Assert.assertTrue(productDetails.isProductNameVisible(), "Product name not visible");
        Assert.assertTrue(productDetails.isCategoryVisible(), "Category not visible");
        Assert.assertTrue(productDetails.isPriceVisible(), "Price not visible");
        Assert.assertTrue(productDetails.isAvailabilityVisible(), "Availability not visible");
        Assert.assertTrue(productDetails.isConditionVisible(), "Condition not visible");
        Assert.assertTrue(productDetails.isBrandVisible(), "Brand not visible");
    }
}
