package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.Constants.Constants;
import com.BaseClass.BaseClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddtoCartPage extends BaseClass {

    Constants cs = new Constants(driver);

    public AddtoCartPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
        cs = new Constants(driver);
    }


    @FindBy(xpath="//div[text()='Sauce Labs Backpack']")
    WebElement productnameBackpack;


    @FindBy(xpath="//div[text()='Sauce Labs Bike Light']")
    WebElement productnameBikeLight;



    @FindBy(xpath="//button[text() = 'Add to cart']")
    WebElement addtocartbutton;



    @FindBy(xpath="//a[@class='shopping_cart_link']")
    WebElement cart;



    @FindBy(xpath="//a//span[@class='shopping_cart_badge']")
    WebElement itemsincart;


    @FindBy(xpath="//button[text()='Remove']")
    WebElement removeitems;

    @FindBy(xpath="//button[@id='back-to-products']")
    WebElement backtoproductpage;

    public void clickonbacktoproductpage(){

        cs.click(backtoproductpage);
    }


    public void clickonproductnameBackpack()
    {
        productnameBackpack.click();
    }

    public void productnameBikeLightname()
    {
        productnameBikeLight.click();
    }

    public boolean productnameBackpackisdisplayed(){
        return cs.isDisplayed(productnameBackpack);

    }

    public boolean productnameBikeLightnameisdisplayed(){
        return cs.isDisplayed(productnameBikeLight);

    }

    public WebElement getProductElementByName(String productName) {
     return driver.findElement(By.xpath("//div[@class='inventory_details_desc_container']//div[text()='" + productName + "']"));
    }



    public void clickOnProductByName(String productName) throws InterruptedException {
        Thread.sleep(20000);
       getProductElementByName(productName).click();
    }

    public boolean isProductDisplayed(String productName) {
        try {
            WebElement product = getProductElementByName(productName);
            return cs.isDisplayed(product);
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public void addproducttocart()
    {
        cs.click(addtocartbutton);
    }

    public void clickoncart()
    {
        cart.click();
    }

    public void removeproduct(String productName)
    {
       cs.click(removeitems);
    }

    public int itemsInCart() {
        try {
            String countText = itemsincart.getText();
            return Integer.parseInt(countText);
        } catch (NoSuchElementException e) {

            return 0;
        } catch (NumberFormatException e) {

            return 0;
        }




    }
















}
