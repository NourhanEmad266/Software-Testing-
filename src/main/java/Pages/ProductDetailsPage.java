package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {

    public ProductDetailsPage(WebDriver browser) {
        super(browser);
    }

    
    private final By productName = By.cssSelector(".product-information h2");
    private final By category = By.xpath("//p[contains(text(),'Category')]");
    private final By price = By.cssSelector(".product-information span span");
    private final By availability = By.xpath("//b[normalize-space()='Availability:']");
    private final By condition = By.xpath("//b[normalize-space()='Condition:']");
    private final By brand = By.xpath("//b[normalize-space()='Brand:']");
    
    
    public boolean isProductNameVisible() {
        return isDisplayed(productName);
    }

    public boolean isCategoryVisible() {
        return isDisplayed(category);
    }

    public boolean isPriceVisible() {
        return isDisplayed(price);
    }

    public boolean isAvailabilityVisible() {
        return isDisplayed(availability);
    }

    public boolean isConditionVisible() {
        return isDisplayed(condition);
    }

    public boolean isBrandVisible() {
        return isDisplayed(brand);
    }
}
