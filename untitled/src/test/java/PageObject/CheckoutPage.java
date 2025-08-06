package PageObject;

import com.BaseClass.BaseClass;
import com.Constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BaseClass {

    Constants cs = new Constants(driver);

    public CheckoutPage(WebDriver driver) {

        BaseClass.driver = driver;
        PageFactory.initElements(driver, this);
        cs = new Constants(driver);
    }


    @FindBy(xpath="//button[@id='checkout']")
    WebElement checkputbutton;

    @FindBy(xpath="//input[@id='first-name']")
    WebElement firstname;

    public void enterfirstname(String firstname1){
        cs.sendKeys(firstname, firstname1);
    }

    public void enterlastname(String lastname1){
        cs.sendKeys(lastname, lastname1);
    }

    public void enterpostalcode(String postalcode1){
        cs.sendKeys(postalcode, postalcode1);
    }


    @FindBy(css = "h3[data-test='error']")
    WebElement errorMessage;

    public String getErrorMessage() {
        return errorMessage.getText();
    }


    @FindBy(xpath="//input[@id='last-name']")
    WebElement lastname;

    @FindBy(xpath="//input[@id='postal-code']")
    WebElement postalcode;

    @FindBy(xpath="//input[@id='continue']")
    WebElement continuebutton;

    public void clickoncontinue(){
        cs.click(continuebutton);
    }

    @FindBy(xpath="//div[@class='cart_quantity']")
    WebElement quantity;

    @FindBy(xpath="//div[@class='inventory_item_name']")
    WebElement Description;

    @FindBy(xpath="//div[@data-test='payment-info-value']")
    WebElement Paymentinfo;

    @FindBy(xpath="//div[@data-test='shipping-info-value']")
    WebElement Shippinginfo;

    @FindBy(xpath="//div[@data-test='total-label']")
    WebElement Pricetotal;

    @FindBy(xpath="//button[@id='finish']")
    WebElement Finish;

    @FindBy(xpath="//h2[@data-test='complete-header']")
    WebElement checkoutcomplete;

    public String getQuantityText() {
        return quantity.getText();
    }

    public String getDescriptionText() {
        return Description.getText();
    }

    public String getPaymentInfoText() {
        return Paymentinfo.getText();
    }

    public String getShippingInfoText() {
        return Shippinginfo.getText();
    }

    public String getPriceTotalText() {
        return Pricetotal.getText();
    }

    public String getcheckoutsucess() {
        return checkoutcomplete.getText();
    }




    public void clickoncheckout(){
        cs.click(checkputbutton);
    }

    public void clickonfinish(){
        cs.click(Finish);
    }



}
