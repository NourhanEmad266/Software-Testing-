/**
 *
 * @author Nourhan
 */
package Pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver browser ;
    protected WebDriverWait wait;

    
    public BasePage(WebDriver browser){
        this.browser = browser ;
         this.wait = new WebDriverWait(browser, Duration.ofSeconds(10));

    }
    
    protected WebElement find(By locater){
        return browser.findElement(locater);
    }
    
    protected void click(By locator){
        find(locator).click();
    }
    public void click(WebElement element) {
        removeAds();
    ((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
    WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(element));
    element.click();
}

    
    public void type(By locator, String text) {
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.clear();
        element.sendKeys(text);
    }
    
    public void type(By locator, int qty) {
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.clear();
        element.sendKeys(String.valueOf(qty));
    }

    
    protected String getText(By locator){
        return find(locator).getText();
    }
    
    protected boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }
    
    protected void scrollIntoView(By locator) {
    WebElement element = find(locator);
    ((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void clickWithJS(By locator) {
        WebElement element = find(locator);
        ((JavascriptExecutor) browser).executeScript("arguments[0].click();", element);
    }
    
    protected void waitForInvisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    } 
    
    protected void scrollTo(By locator) {
        WebElement element = browser.findElement(locator);
        ((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void removeAds() {
        ((JavascriptExecutor) browser).executeScript(
        "var ads = document.querySelectorAll('iframe, #aswift_3_host'); " +
        "ads.forEach(ad => ad.style.display='none');"
    );
        
}

    protected boolean isElementVisible(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
