

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase10 {

    private WebDriver browser;
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        browser.manage().window().maximize();
        browser.get("http://automationexercise.com");

        homePage = new HomePage(browser);
    }

    @Test
    public void verifySubscriptionFlow() {
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is NOT visible!");

        Assert.assertTrue(homePage.isSubscriptionTextVisible(), "'SUBSCRIPTION' text is NOT visible!");

        homePage.subscribeWithEmail("testuser@example.com");

        Assert.assertTrue(homePage.isSubscriptionSuccessVisible(), "Success message not visible!");
    }

    @AfterMethod
    public void tearDown() {
            browser.quit();
    }
}
