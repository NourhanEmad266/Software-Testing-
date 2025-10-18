

/**
 *
 * @author Nourhan
 */
import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignUpFullInfo;
import Utils.HelperClass;
import java.io.FileNotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase3 {

    private WebDriver browser;
    private HomePage homePage;
    private SignUpFullInfo signUpPage;
    private LoginPage loginPage ;

    static HelperClass.User[] SignUpUsers;

    @BeforeClass
    public void setUpClass() throws FileNotFoundException {
        
        SignUpUsers = HelperClass.ReadUsers("SignUp_Credentials.json");
        System.out.println("✅ Number of users loaded: " + SignUpUsers.length);
    }

    @BeforeMethod
    public void setUpMethod() {
        browser = new ChromeDriver();
        browser.manage().window().maximize();

        browser.get("http://automationexercise.com");

        homePage = new HomePage(browser);
        signUpPage = new SignUpFullInfo(browser);
        loginPage = new LoginPage(browser);

    }

    @AfterMethod
    public void tearDown() {
            browser.quit();
    }

    @DataProvider(name = "UsersData")
    public Object[] userDataProvider() {
        return SignUpUsers;
    }

    @Test(dataProvider = "UsersData")
    public void registerUsers(HelperClass.User user) {
        Assert.assertTrue(homePage.logoDisplayed(), "❌ Home page logo not visible!");
        
        homePage.clickSignupLoginBtn();
        
         Assert.assertTrue(loginPage.isLoginHeaderVisible(),
        "❌ 'Login to your account' header not visible!");
        
        loginPage.login(user.email, user.password);
        
        Assert.assertTrue(loginPage.isLoginErrorVisible(),
        "❌ Error message 'Your email or password is incorrect!' not visible!");
                
    }
}
