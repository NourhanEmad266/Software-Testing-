
/**
 *
 * @author Nourhan
 */
import Pages.ContactUsPage;

import Pages.HomePage;
import Utils.HelperClass;
import Utils.HelperClass.User;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class TestCase6 {
    
    private WebDriver browser;
    private HomePage homePage;
    private ContactUsPage contactUsPage;
    
    static User[] ContactUS ;
        
    @BeforeClass
    public void setUpClass() throws FileNotFoundException {
        
        ContactUS = HelperClass.ReadUsers("SignUp_Credentials.json");
        System.out.println("✅ Number of users loaded: " + ContactUS.length);
    }
    @BeforeMethod
    public void setUp() {
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://automationexercise.com");

        homePage = new HomePage(browser);
        contactUsPage = new ContactUsPage(browser);
    }

    @AfterMethod
    public void tearDown() {
            browser.quit();
    }
@DataProvider(name = "UsersData")
    public Object[] userDataProvider() {
        return ContactUS;
    }

    @Test(dataProvider = "UsersData")
    public void testContactUsForm(User user) {
        Assert.assertTrue(homePage.logoDisplayed(), "❌ Home page is not visible!");

        homePage.clickContactUs();

        Assert.assertTrue(contactUsPage.isGetInTouchVisible(), "❌ GET IN TOUCH is not visible!");

        contactUsPage.submitForm(user.name, user.email, user.subject, user.message, user.filePath);
 
        browser.switchTo().alert().accept();

        Assert.assertTrue(contactUsPage.isSuccessMessageVisible(), "❌ Success message not visible!");

        contactUsPage.clickHomeBtn();
        Assert.assertTrue(homePage.logoDisplayed(), "❌ Not navigated back to Home page!");
    }
}
