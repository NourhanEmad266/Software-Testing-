
import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase25{

    WebDriver browser;
    HomePage home;

    @BeforeClass
    public void setUp() {
        
        browser = new ChromeDriver();
        browser.manage().window().maximize();

        
        browser.get("http://automationexercise.com");

        
        home = new HomePage(browser);
    }

    @Test
    public void testScrollUpUsingArrow() {
        Assert.assertTrue(home.isHomePageVisible(), "Home page is not visible!");

        home.scrollToBottom();
        Assert.assertTrue(home.isSubscriptionTextVisible(), "'SUBSCRIPTION' section not visible!");

        home.clickScrollUpArrow();

        Assert.assertTrue(home.isFullFledgedTextVisible(),
            "'Full-Fledged practice website for Automation Engineers' text is not visible after scrolling up!");
    }

    @AfterClass
    public void tearDown() {
            browser.quit();
    }
}
