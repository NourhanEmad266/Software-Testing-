
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Nourhan
 */
public class PaymentPage extends BasePage{
    
    public PaymentPage(WebDriver browser) {
        super(browser);
    }
    private final By commentTextArea = By.name("message");
    private final By placeOrderBtn = By.cssSelector(".check_out");

    private final By nameonCard = By.name("name_on_card") ;
    private final By cardNumber =  By.name("card_number") ;
    private final By cvc = By.name("cvc") ;
    private final By expiryMonth = By.name("expiry_month") ;
    private final By expiryYear = By.name("expiry_year") ;
    private final By payBtn = By.id("submit") ;
    
    private final By successMsg = By.xpath("//p[text()='Your order has been placed successfully!']");

     
    public void enterComment(String comment) {
        type(commentTextArea, comment);
    }
     
    public void enterPaymentDetails(String name , String number , String cvv , String Month , String Year){
        type(nameonCard , name) ;
        type(cardNumber , number) ;
        type (cvc , cvv);
        type(expiryMonth, Month) ;
        type(expiryYear , Year) ;
    }
    
    public void payAndConfirm (){
        click(payBtn) ;
    }
    
     public boolean isOrderSuccessVisible() {
        return isDisplayed(successMsg);
    }
    
}
