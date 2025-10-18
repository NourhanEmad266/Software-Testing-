
import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase26 {
    WebDriver driver;
    HomePage homePage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationexercise.com");
        homePage = new HomePage(driver);
    }

    @Test
    public void scrollUpDownValidation() {
        Assert.assertTrue(homePage.isHomePageVisible1(), "Home page not visible!");
        
        homePage.scrollToBottom();
        Assert.assertTrue(homePage.isSubscriptionTextVisible(), "'SUBSCRIPTION' section is not visible!");

        homePage.scrollToTop();
        Assert.assertTrue(homePage.isHomePageVisible(), "Banner text is not visible after scrolling up!");
    }

    @AfterClass
    public void tearDown() {
            driver.quit();
    }
}
