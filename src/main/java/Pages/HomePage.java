/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 *
 * @author Nourhan
 */
public class HomePage extends BasePage{
    
    public HomePage (WebDriver browser)
    {
        super(browser); 
    }
    
    private final By logo = By.xpath("//div[@class='logo pull-left']");
    private final By signupLoginButton = By.cssSelector("a[href='/login']");
    private final By contactUs = By.cssSelector("a[href='/contact_us']");
    private final By products = By.cssSelector("a[href='/products']");
    private final By cart = By.cssSelector("a[href='/view_cart']");
    private final By testCase = By.cssSelector("a[href='/test_cases']");
    private final By homeBanner = By.xpath("//div[@class='item active']//h2[contains(text(),'Full-Fledged practice website')]");
    
    private final By homePageSlider = By.id("slider-carousel");

    private final By subscriptionText = By.xpath("//h2[normalize-space()='Subscription']");
    private final By subscriptionEmailField = By.id("susbscribe_email");
    private final By subscriptionButton = By.id("subscribe");

    private final By successMsg = By.xpath("//div[contains(@class,'alert-success') and contains(text(),'You have been successfully subscribed!')]");
    
    private final By viewProductButtons = By.xpath("//a[text()='View Product']");
    private final By fullFledgedText = By.xpath("//*[text()='Full-Fledged practice website for Automation Engineers']");
    private final By scrollUpArrow = By.id("scrollUp");  
    public boolean logoDisplayed(){
       return isDisplayed(logo) ;
    }
    
    public void clickSignupLoginBtn(){
        click(signupLoginButton);
    }
    
    public void clickContactUs(){
        click(contactUs);
    }
    
    public void clickProducts(){
        click(products);
    }
    
    public void clickCart(){
        click(cart);
    }
    
    public void clickTestCase(){
        click(testCase);
    }
    
    public boolean isHomePageVisible() {
        return isDisplayed(homeBanner);
    }
    
     public boolean isHomePageVisible1() {
        return isDisplayed(homePageSlider);
    }

    public boolean isSubscriptionTextVisible() {
        scrollTo(subscriptionText);   
        return isDisplayed(subscriptionText);
    }

    public void subscribeWithEmail(String email) {
        type(subscriptionEmailField, email);
        click(subscriptionButton);
    }

    public boolean isSubscriptionSuccessVisible() {
        return isDisplayed(successMsg);
    }
    
    public void clickViewProduct(int index) {
        removeAds(); 
        List<WebElement> products = browser.findElements(viewProductButtons);
        products.get(index).click();
    }
    
    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) browser;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    
    public void scrollToTop() {
        JavascriptExecutor js = (JavascriptExecutor) browser;
        js.executeScript("window.scrollTo(0, 0)");
    }
    
    public void clickScrollUpArrow() {
        browser.findElement(scrollUpArrow).click();
    }
    
      public boolean isFullFledgedTextVisible() {
        return browser.findElement(fullFledgedText).isDisplayed();
    }
    

}
