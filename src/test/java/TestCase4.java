
import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignUpFullInfo;
import Utils.HelperClass;
import java.io.FileNotFoundException;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author Nourhan
 */
public class TestCase4 {

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

        signUpPage.entername1(user.name);
        signUpPage.enteremail1(user.email);

        browser.findElement(org.openqa.selenium.By.xpath("//button[text()='Signup']")).click();

        Assert.assertTrue(signUpPage.isEnterAccountInfoVisible(),
                "❌ ENTER ACCOUNT INFORMATION not visible!");

        signUpPage.selectTitle(user.title);
        signUpPage.enterName(user.name);
        signUpPage.enterPassword(user.password);

        JavascriptExecutor js = (JavascriptExecutor) browser;
            js.executeScript("window.scrollBy(0, 500)");

        signUpPage.selectDateOfBirth(user.dob.day, user.dob.month, user.dob.year);

        signUpPage.checkNewsletter();
        signUpPage.checkOffers();

        signUpPage.enterAddressDetails(
                user.firstName,
                user.lastName,
                user.company,
                user.address,
                user.address2,
                user.country,
                user.state,
                user.city,
                user.zipcode,
                user.mobileNumber
        );

        signUpPage.clickCreateAccount();
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));

        Assert.assertTrue(browser.getPageSource().contains("Account Created!"),
                "❌ Account not created!");

        signUpPage.clickContinue();
        signUpPage.clickLogout(); 
        signUpPage.clickSignupLoginBtn();
        loginPage.login(user.email, user.password);
        Assert.assertTrue(loginPage.isLoggedInAsVisible(), "❌ 'Logged in as username' not visible!");
        signUpPage.clickLogout();
        Assert.assertTrue(loginPage.isLoginHeaderVisible(), "❌ User was not navigated back to Login Page!");
    }
}
