package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage {
    
    public CartPage(WebDriver browser) {
        super(browser);
    }


    private final By subscriptionText = By.xpath("//h2[text()='Subscription']");
    private final By emailInput = By.id("susbscribe_email");
    private final By arrowButton = By.id("subscribe");
    private final By subscriptionSuccessMessage = By.xpath("//div[contains(@class,'alert-success') and contains(text(),'You have been successfully subscribed!')]");
    
    private final By firstProductInCart = By.xpath("//tr[1]//td[@class='cart_description']");
    private final By secondProductInCart = By.xpath("//tr[2]//td[@class='cart_description']");

    private final By firstProductPrice = By.xpath("//tr[1]//td[@class='cart_price']");
    private final By firstProductQuantity = By.xpath("//tr[1]//td[@class='cart_quantity']");
    private final By firstProductTotal = By.xpath("//tr[1]//td[@class='cart_total']");

    private final By secondProductPrice = By.xpath("//tr[2]//td[@class='cart_price']");
    private final By secondProductQuantity = By.xpath("//tr[2]//td[@class='cart_quantity']");
    private final By secondProductTotal = By.xpath("//tr[2]//td[@class='cart_total']");
    
    private final By cartProductName = By.xpath("//td[@class='cart_description']/h4/a");
    private final By cartProductQuantity = By.xpath("//td[@class='cart_quantity']/button");
    
    private final By firstProductDeleteButton = By.xpath("//a[@class='cart_quantity_delete']");
    private final By emptyCartMsg = By.xpath("//*[contains(text(),'Cart is empty')]");
    
    
    
    private final By cartPageTitle = By.xpath("/html/body/section/div/div[1]/ol/li[1]/a");

    private final By proceedToCheckoutBtn = By.xpath("//a[contains(text(),'Proceed To Checkout')]");

    public boolean isCartPageVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
            WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(cartPageTitle));
            return title.isDisplayed();
        } catch (Exception e) {
            return false;
    }
}


    public void clickProceedToCheckout() {
        click(proceedToCheckoutBtn);
    }
    
     public void removeFirstProduct() {
         click(firstProductDeleteButton); 
     }

    public void scrollToFooter() {
        JavascriptExecutor js = (JavascriptExecutor) browser;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public boolean isSubscriptionTextVisible() {
        scrollToFooter();
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        try {
            WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionText));
            return text.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void subscribeWithEmail(String email) {
        type(emailInput, email);
        click(arrowButton);
    }

    public boolean isSubscriptionSuccessVisible() {
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        try {
            WebElement success = wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionSuccessMessage));
            return success.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
    
     public boolean isFirstProductInCartVisible() {
        return isDisplayed(firstProductInCart);
    }

    public boolean isSecondProductInCartVisible() {
        return isDisplayed(secondProductInCart);
    }

    public String getFirstProductPrice() {
        return getText(firstProductPrice).trim();
    }

    public String getFirstProductQuantity() {
        return getText(firstProductQuantity).trim();
    }

    public String getFirstProductTotal() {
        return getText(firstProductTotal).trim();
    }

    public String getSecondProductPrice() {
        return getText(secondProductPrice).trim();
    }

    public String getSecondProductQuantity() {
        return getText(secondProductQuantity).trim();
    }

    public String getSecondProductTotal() {
        return getText(secondProductTotal).trim();
    }
    
     public boolean isProductDisplayed(String productName) {
    for (WebElement product : browser.findElements(cartProductName)) {
        if (product.getText().trim().equals(productName)) {
            return true;
        }
    }
    return false;
}


    public int getProductQuantity(String productName) {
        String qty = browser.findElement(cartProductQuantity).getText();
        return Integer.parseInt(qty);
    }
    
     public boolean isCartEmpty() {
        return isElementVisible(find(emptyCartMsg));
    }
   
}
