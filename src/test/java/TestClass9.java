
import Pages.HomePage;
import Pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestClass9 {

    private WebDriver browser;
    private HomePage homePage;
    private ProductsPage productsPage;

    @BeforeMethod
    public void setUp() {
        browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        browser.manage().window().maximize();
        browser.get("http://automationexercise.com");

        homePage = new HomePage(browser);
        productsPage = new ProductsPage(browser);
    }

    @Test
    public void verifySearchProductFlow() {
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is NOT visible!");

        homePage.clickProducts();

        Assert.assertTrue(productsPage.isAllProductsPageVisible(), "'All Products' page is NOT visible!");

        productsPage.searchProduct("Tshirt");

        Assert.assertTrue(productsPage.isSearchHeaderVisible(), "'SEARCHED PRODUCTS' header is NOT visible!");

        Assert.assertTrue(productsPage.areSearchedProductsVisible(), "Search results are NOT visible!");
    }

    @AfterMethod
    public void tearDown() {
            browser.quit();
    }
}
