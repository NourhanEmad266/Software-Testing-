
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Nourhan
 */
public class LoginPage extends BasePage {
    
    public LoginPage(WebDriver browser) {
        super(browser);
    }
    
    private final By emailField = By.cssSelector("input[data-qa='login-email']") ;
    private final By passwordField = By.cssSelector("input[data-qa='login-password']");
    private final By LoginBtn = By.cssSelector("button[data-qa='login-button']") ;
    private final By newUserName = By.cssSelector("input[data-qa='signup-name']") ;
    private final By newUserEmail = By.cssSelector("input[data-qa='signup-email']") ;
    private final By signUpBtn = By.cssSelector("button[data-qa='signup-button']") ;
    
    private final By loginHeader = By.xpath("//h2[text()='Login to your account']");
    
    private final By loginError = By.xpath("//p[text()='Your email or password is incorrect!']");
    
    private final By loggedInAs = By.xpath("//a[contains(text(),'Logged in as')]");

    public void login(String email , String password){
        type(emailField , email) ;
        type(passwordField , password) ;
        click(LoginBtn) ;
    }
    
  
    public void signUp(String name , String email){
        type(newUserName , name) ;
        type(newUserEmail , email) ;
        click(signUpBtn) ;
    } 
    public boolean isLoginHeaderVisible() {
        return isDisplayed(loginHeader);
    }
    
    
    public boolean isLoginErrorVisible() {
        return isDisplayed(loginError);
    }
    
    public boolean isLoggedInAsVisible() {
        return isDisplayed(loggedInAs);
    }
    
}
