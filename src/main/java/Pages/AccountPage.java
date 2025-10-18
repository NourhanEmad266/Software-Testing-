package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver browser) {
        super(browser);
    }

    private final By loggedInAs = By.xpath("//a[contains(text(),'Logged in as')]");
    private final By deleteAccountBtn = By.xpath("//a[text()=' Delete Account']");
    private final By accountDeletedText = By.xpath("//b[text()='Account Deleted!']");
    private final By continueBtn = By.xpath("//a[text()='Continue']");
    
    private final By accountCreatedMsg = By.xpath("//b[text()='Account Created!']");


    public boolean isLoggedInVisible() {
        return isDisplayed(loggedInAs);
    }

    public void clickDeleteAccount() {
        click(deleteAccountBtn);
    }

    public boolean isAccountDeletedVisible() {
        return isDisplayed(accountDeletedText);
    }

    public void clickContinueAfterDeletion() {
        click(continueBtn);
    }
    
    public boolean isAccountCreatedVisible() {
        return isDisplayed(accountCreatedMsg);
    }
}
