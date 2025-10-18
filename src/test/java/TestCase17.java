
import Pages.HomePage;
import Pages.ProductsPage;
import Pages.CartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase17 {

    WebDriver browser;
    HomePage home;
    ProductsPage products;
    CartPage cart;

    @BeforeClass
    public void setUp() {
        browser = new ChromeDriver();
        browser.manage().window().maximize();

        browser.get("http://automationexercise.com");

        home = new HomePage(browser);
        products = new ProductsPage(browser);
        cart = new CartPage(browser);
    }

    @Test
    public void testRemoveProductFromCart() {
        Assert.assertTrue(home.isHomePageVisible(), "Home page is not visible!");

        home.clickProducts();
        products.addFirstProductToCart();
        products.clickContinueShopping();

        home.clickCart();

        Assert.assertTrue(cart.isCartPageVisible(), "Cart page is not visible!");

        cart.removeFirstProduct();

        Assert.assertTrue(cart.isCartEmpty(), "Product is not removed from cart!");
    }

    @AfterClass
    public void tearDown() {
            browser.quit();
    }
}
