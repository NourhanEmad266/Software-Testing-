package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Nourhan
 */
public class CheckoutPage extends BasePage{
    
    public CheckoutPage(WebDriver browser) {
        super(browser);
    }
    
    private final By placeOrderBtn = By.cssSelector(".check_out") ;
    
    public void placeOrder(){
        click(placeOrderBtn) ;
    }
    
}
