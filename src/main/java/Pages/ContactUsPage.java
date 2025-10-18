package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends BasePage {
    
    public ContactUsPage(WebDriver browser) {
        super(browser);
    }

    private final By nameField = By.name("name");
    private final By emailField = By.name("email");
    private final By subjectField = By.name("subject");
    private final By messageField = By.name("message");
    private final By uploadFile = By.name("upload_file");
    private final By submitBtn = By.name("submit");
    private final By getInTouchHeader = By.xpath("//h2[text()='Get In Touch']");
    private final By successMsg = By.xpath("//div[@class='status alert alert-success']");
    private final By homeBtn = By.xpath("//a[@class='btn btn-success']");

    public boolean isGetInTouchVisible() {
        return isDisplayed(getInTouchHeader);
    }

    public void submitForm(String name, String email, String subject, String message, String filePath) {
        type(nameField, name);
        type(emailField, email);
        type(subjectField, subject);
        type(messageField, message);
        browser.findElement(uploadFile).sendKeys(filePath);
        click(submitBtn);
    }

    public boolean isSuccessMessageVisible() {
        return isDisplayed(successMsg);
    }

    public void clickHomeBtn() {
        click(homeBtn);
    }
}
