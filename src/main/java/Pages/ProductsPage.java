package Pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends BasePage {
    
    public ProductsPage(WebDriver browser) {
        super(browser);
    }

    
    private final By allProductsHeader = By.xpath("//h2[normalize-space()='All Products']");
    private final By productsList = By.cssSelector(".features_items"); 
    private final By firstProductView = By.cssSelector("a[href*='/product_details/1']");
    private final By searchField = By.id("search_product");
    private final By searchBtn = By.id("submit_search");
    private final By addToCartBtn = By.xpath("//button[text()='Add to cart']");
    private final By firstProduct = By.xpath("(//div[@class='product-image-wrapper'])[1]");
    private final By secondProduct = By.xpath("(//div[@class='product-image-wrapper'])[2]");
    private final By firstAddToCartBtn = By.xpath("(//a[contains(text(),'Add to cart')])[1]");
    private final By secondAddToCartBtn = By.xpath("(//a[contains(text(),'Add to cart')])[3]");
    private final By continueShoppingBtn = By.xpath("//button[text()='Continue Shopping']");
    private final By viewCartBtn = By.xpath("//u[text()='View Cart']");
    private final By searchedProductsHeader = By.xpath("//h2[normalize-space()='Searched Products']");
    private final By searchedProductsList = By.cssSelector(".features_items .product-image-wrapper");
    
    private final By productName = By.cssSelector("div.product-information h2");

    private final By quantityInput = By.id("quantity");
    
    
    public boolean isProductDetailVisible() {
        return browser.findElement(productName).isDisplayed();
    }
    
    public void clickAddToCart() {
        removeAds();
        WebElement element = browser.findElement(addToCartBtn);
        Actions actions = new Actions(browser);
        actions.moveToElement(element).perform(); 
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }


    public void clickViewCartButton() {
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartBtn));
        click(viewCartBtn) ;
    }

    public void setQuantity(int qty) {
        browser.findElement(quantityInput).clear();
        type(quantityInput, qty);
    }

    public void viewFirstProduct1() {
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));

        WebElement element = browser.findElement(firstProductView);
        ((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);

        wait.until(ExpectedConditions.elementToBeClickable(firstProductView));

        element.click();
    }
    
    public String getProductName() {
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("product_details"));
        WebElement productName = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-information']//h2"))
        );
        return productName.getText();
    }

    public void viewFirstProduct() {
        removeAds();
        click(firstProductView);
    }

    
    public void removeAds() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) browser;
            js.executeScript("document.querySelectorAll('iframe[id^=\"aswift\"]').forEach(e => e.remove());");
        } catch (Exception ignored) {}
    }

    public boolean isAllProductsPageVisible() {
        return isDisplayed(allProductsHeader);
    }

    public boolean isProductsListVisible() {
        return isDisplayed(productsList);
    }
    
    
    public void addFirstProductToCart() {
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));

         
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(firstProduct));
        new Actions(browser).moveToElement(product).perform();

        
        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(firstAddToCartBtn));

        
        ((JavascriptExecutor) browser).executeScript("arguments[0].click();", addBtn);
    }

 

    public void searchProduct(String productName) {
        type(searchField, productName);
        click(searchBtn);
    }

    public boolean isSearchHeaderVisible() {
        return isDisplayed(searchedProductsHeader);
    }

    public boolean areSearchedProductsVisible() {
        return isDisplayed(searchedProductsList);
    }
    
   

    public void hoverAndAddFirstProduct() {
        WebElement product = find(firstProduct);
        Actions actions = new Actions(browser);
        actions.moveToElement(product).perform();
        click(firstAddToCartBtn);
    }

    public void hoverAndAddSecondProduct() {
        WebElement product = find(secondProduct);
        Actions actions = new Actions(browser);
        actions.moveToElement(product).perform();
        click(secondAddToCartBtn);
    }

    public void clickContinueShopping() {
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Continue Shopping']")));
        continueBtn.click();    
    }

    public void clickViewCart() {
        click(viewCartBtn);
    }
    
    public void clickViewProduct(int productIndex) {
        removeAds(); 
        By viewProduct = By.xpath("(//a[text()='View Product'])[" + (productIndex + 1) + "]");
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(viewProduct));
        click(viewProduct);
    }

}
