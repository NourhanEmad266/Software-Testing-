
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase14{

    WebDriver driver;
    HomePage home;
    ProductsPage products;
    CartPage cart;
    CheckoutPage checkout;
    PaymentPage payment;
    LoginPage login;
    AccountPage account;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationexercise.com");

        home = new HomePage(driver);
        products = new ProductsPage(driver);
        cart = new CartPage(driver);
        checkout = new CheckoutPage(driver);
        payment = new PaymentPage(driver);
        login = new LoginPage(driver);
        account = new AccountPage(driver);
    }

    @Test
    public void fullPurchaseFlow() throws InterruptedException {
        Assert.assertTrue(home.isHomePageVisible(), "Home page not visible");

        home.clickProducts();
        home.clickViewProduct(0);  
        products.setQuantity(4);
        products.clickAddToCart();
        products.clickViewCart();

        home.clickCart();
        Assert.assertTrue(cart.isCartPageVisible(), "Cart page not visible");

        cart.clickProceedToCheckout();

        home.clickSignupLoginBtn();
        login.signUp("Nourhan", "nourhan123@mail.com");
        Assert.assertTrue(account.isAccountCreatedVisible(), "Account not created");
        account.clickContinueAfterDeletion();

        Assert.assertTrue(login.isLoggedInAsVisible(), "User not logged in");

        home.clickCart();
        cart.clickProceedToCheckout();

        payment.enterComment("Please deliver fast");
        payment.payAndConfirm();

        payment.enterPaymentDetails("Nourhan Emad", "1234567890123456", "123", "12", "2025");
        payment.payAndConfirm();
        Assert.assertTrue(payment.isOrderSuccessVisible(), "Order not successful");

        account.clickDeleteAccount();
        Assert.assertTrue(account.isAccountDeletedVisible(), "Account not deleted");
        account.clickContinueAfterDeletion();
    }

    @AfterClass
    public void tearDown() {
            driver.quit();
    }
}
