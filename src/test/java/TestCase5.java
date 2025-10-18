
import Pages.HomePage;
import Pages.SignUpFullInfo;
import Utils.HelperClass;
import Utils.HelperClass.User;
import java.io.FileNotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestCase5 {

    private WebDriver browser;
    private HomePage homePage;
    private SignUpFullInfo signUpPage;

    static User[] SignUpUsers;

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
    public void registerUsers(User user) {
        Assert.assertTrue(homePage.logoDisplayed(), "❌ Home page logo not visible!");

        homePage.clickSignupLoginBtn();

//        signUpPage.entername1(user.name);
//        signUpPage.enteremail1(user.email);
//
//        signUpPage.clickSignupButton();
//        
//        Assert.assertTrue(signUpPage.isEnterAccountInfoVisible(),
//                "❌ ENTER ACCOUNT INFORMATION not visible!");
//
//        signUpPage.selectTitle(user.title);
//        signUpPage.enterName(user.name);
//        signUpPage.enterPassword(user.password);
//
//        JavascriptExecutor js = (JavascriptExecutor) browser;
//            js.executeScript("window.scrollBy(0, 500)");
//
//        signUpPage.selectDateOfBirth(user.dob.day, user.dob.month, user.dob.year);
//
//        signUpPage.checkNewsletter();
//        signUpPage.checkOffers();
//
//        signUpPage.enterAddressDetails(
//                user.firstName,
//                user.lastName,
//                user.company,
//                user.address,
//                user.address2,
//                user.country,
//                user.state,
//                user.city,
//                user.zipcode,
//                user.mobileNumber
//        );
//
//        signUpPage.clickCreateAccount();
//        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
//        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Logout']")));
//
//
//        Assert.assertTrue(browser.getPageSource().contains("Account Created!"),
//                "❌ Account not created!");
//
//        signUpPage.clickContinue();
//
//        //Assert.assertTrue(browser.getPageSource().contains("Logged in as " + user.name),
//          //      "❌ User not logged in!");
//          
//         signUpPage.clickLogout();
         
        signUpPage.entername1(user.name);
        signUpPage.enteremail1(user.email);
        signUpPage.clickSignupButton();
        
        Assert.assertTrue(signUpPage.isEmailAlreadyExistsErrorVisible(),
        "❌ Error 'Email Address already exist!' is not visible!");

        
         
         

        
    }
}
