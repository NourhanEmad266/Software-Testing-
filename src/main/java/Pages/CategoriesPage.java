package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CategoriesPage extends BasePage {

    private final By categoriesSidebar = By.cssSelector(".left-sidebar");
    private final By categoryLinks = By.xpath("//div[@class='left-sidebar']//a[contains(@href,'category')]"); 
    private final By categoryTitle = By.xpath("//h2[contains(text(),'PRODUCTS')]");

    public CategoriesPage(WebDriver browser) {
        super(browser);
    }
    public boolean isCategoriesSidebarVisible() {
        return isDisplayed(categoriesSidebar);
    }

    public void clickCategory(String categoryName) {
        try {
            WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));

            List<WebElement> categories = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(categoryLinks));

            WebElement target = categories.stream()
                    .filter(c -> c.getText().trim().equalsIgnoreCase(categoryName))
                    .findFirst()
                    .orElseThrow(() -> new NoSuchElementException("Category '" + categoryName + "' not found"));

             ((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView({block:'center'});", target);

            wait.until(ExpectedConditions.elementToBeClickable(target));

            try {
                target.click();
            } catch (ElementClickInterceptedException e) {
                ((JavascriptExecutor) browser).executeScript("arguments[0].click();", target);
            }

        } catch (TimeoutException | NoSuchElementException e) {
            throw new RuntimeException("Failed to click category '" + categoryName + "'", e);
        }
    }

    public void clickSubCategory(String mainCategoryName, int index) {
        try {
            WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));

            WebElement mainCategoryDiv = browser.findElement(By.xpath("//div[h2[contains(text(),'" + mainCategoryName + "')]]"));

            List<WebElement> subCategories = mainCategoryDiv.findElements(By.tagName("a"));

            if (index >= subCategories.size()) {
                throw new IndexOutOfBoundsException("Invalid subcategory index: " + index);
            }

            WebElement target = subCategories.get(index);

            ((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView({block:'center'});", target);

            wait.until(ExpectedConditions.elementToBeClickable(target));

            try {
                target.click();
            } catch (ElementClickInterceptedException e) {
                ((JavascriptExecutor) browser).executeScript("arguments[0].click();", target);
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to click subcategory under '" + mainCategoryName + "'", e);
        }
    }

    public boolean isCategoryPageVisible(String expectedText) {
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        try {
            WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(categoryTitle));
            return title.getText().contains(expectedText);
        } catch (Exception e) {
            return false;
        }
    }
}
