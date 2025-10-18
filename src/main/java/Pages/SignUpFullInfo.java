
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
/**
 *
 * @author Nourhan
 */
public class SignUpFullInfo extends BasePage{
    
    public SignUpFullInfo(WebDriver browser) {
        super(browser);
    }
    private final By logo = By.xpath("//div[@class='logo pull-left']");
    private final By signupLoginButton = By.cssSelector("a[href='/login']");
    
    private final By name1 = By.xpath("/html/body/section/div/div/div[3]/div/form/input[2]") ;
    private final By email1 = By.xpath("/html/body/section/div/div/div[3]/div/form/input[3]") ;
    
    private final By enterAccountInfoHeader = By.xpath("//b[text()='Enter Account Information']");
    private final By titleMr = By.id("id_gender1");
    private final By titleMrs = By.id("id_gender2");
    private final By nameField = By.id("name");
    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By dayDropdown = By.id("days");
    private final By monthDropdown = By.id("months");
    private final By yearDropdown = By.id("years");

    private final By newsletterCheckbox = By.id("newsletter");
    private final By offersCheckbox = By.id("optin");

    private final By firstNameField = By.id("first_name");
    private final By lastNameField = By.id("last_name");
    private final By companyField = By.id("company");
    private final By address1Field = By.id("address1");
    private final By address2Field = By.id("address2");
    private final By countryDropdown = By.id("country");
    private final By stateField = By.id("state");
    private final By cityField = By.id("city");
    private final By zipcodeField = By.id("zipcode");
    private final By mobileNumberField = By.id("mobile_number");
    private final By continueBtn = By.xpath("//a[text()='Continue']") ;
    private final By logoutBtn = By.cssSelector("a[href='/logout']") ;

    private final By createAccountBtn = By.xpath("//button[text()='Create Account']");
    
    private final By newUserSignupHeader = By.xpath("//h2[text()='New User Signup!']");
    
    private final By signUpBtn = By.xpath("//button[text()='Signup']");

    public void clickSignupButton() {
         click(signUpBtn);
    }
    
    private final By emailAlreadyExistsError = By.xpath("//p[text()='Email Address already exist!']");

    public boolean isEmailAlreadyExistsErrorVisible() {
        return isDisplayed(emailAlreadyExistsError);
    }

    public void clickLogout(){
        click(logoutBtn) ;
    }
    
    public boolean isNewUserSignupVisible() {
        return isDisplayed(newUserSignupHeader);
    }
    
    public void clickContinue(){
        click(continueBtn) ;
    }
     public boolean isEnterAccountInfoVisible() {
        return isDisplayed(enterAccountInfoHeader);
    }
    
    public boolean logoDisplayed(){
       return isDisplayed(logo) ;
    }
    
    public void clickSignupLoginBtn(){
        click(signupLoginButton);
    }

    public void selectTitle(String title) {
        if (title.equalsIgnoreCase("Mr")) {
            click(titleMr);
        } else {
            click(titleMrs);
        }
    }

    public void enterName(String name) {
        type(nameField, name);
    }

    public void enterEmail(String email) {
        type(emailField, email);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

public void selectDateOfBirth(String day, String month, String year) {
    Select daySelect = new Select(find(dayDropdown));
    daySelect.selectByVisibleText(day);

    Select monthSelect = new Select(find(monthDropdown));
    monthSelect.selectByVisibleText(month);

    Select yearSelect = new Select(find(yearDropdown));
    yearSelect.selectByValue(year);
}
    public void checkNewsletter() {
        click(newsletterCheckbox);
    }

    public void checkOffers() {
        click(offersCheckbox);
    }

    public void enterAddressDetails(String firstName, String lastName, String company,
                                String address1, String address2, String country,
                                String state, String city, String zipcode, String mobile) {
        type(firstNameField, firstName);
        type(lastNameField, lastName);
        type(companyField, company);
        type(address1Field, address1);
        type(address2Field, address2);
    
        WebElement countryDropdown = browser.findElement(By.id("country"));

        Select selectCountry = new Select(countryDropdown);
            try {
                selectCountry.selectByVisibleText(country);  
        } catch (Exception e) {
        
            selectCountry.selectByIndex(1); 
        }

        type(stateField, state);
        type(cityField, city);
        type(zipcodeField, zipcode);
        type(mobileNumberField, mobile);
    }

    public void clickCreateAccount() {
        click(createAccountBtn);
    }
    
    public void entername1(String name){
        type(name1, name);
    }
     public void enteremail1(String email){
        type(email1, email);
    }
}
