package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasePage extends BasePage {
      
    
    public TestCasePage(WebDriver browser) {
        super(browser);
    }
      
    private final By testCasesHeader = By.xpath("//h2[normalize-space()='Test Cases']");

    

    public boolean isTestCasesPageVisible() {
        return isDisplayed(testCasesHeader);
    }
}
