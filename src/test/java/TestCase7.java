
import Pages.HomePage;
import Pages.TestCasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestCase7 {
    WebDriver browser;
    HomePage homePage;
    TestCasePage testCasesPage;

    @BeforeClass
    public void setup() {
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://automationexercise.com");
        homePage = new HomePage(browser);
        testCasesPage = new TestCasePage(browser);
    }

    @Test
    public void verifyTestCasesNavigation() {
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is NOT visible!");

        homePage.clickTestCase();

        Assert.assertTrue(testCasesPage.isTestCasesPageVisible(), "Test Cases page is NOT visible!");
    }

    @AfterClass
    public void tearDown() {
        browser.quit();
    }
}
