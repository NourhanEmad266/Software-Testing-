
import Pages.HomePage;
import Pages.CartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase11 {

    private WebDriver browser;
    private HomePage homePage;
    private CartPage cartPage;

    @BeforeMethod
    public void setUp() {
        browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        browser.manage().window().maximize();
        browser.get("http://automationexercise.com");

        homePage = new HomePage(browser);
        cartPage = new CartPage(browser);
    }

    @Test
    public void verifySubscriptionInCart() {
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is NOT visible!");

        homePage.clickCart();

        Assert.assertTrue(cartPage.isSubscriptionTextVisible(), "'SUBSCRIPTION' text is NOT visible in Cart page!");

        cartPage.subscribeWithEmail("testuser@example.com");

        Assert.assertTrue(cartPage.isSubscriptionSuccessVisible(), "Success message not visible!");
    }

    @AfterMethod
    public void tearDown() {
            browser.quit();
    }
}
