package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.Constants.Constants;
import com.BaseClass.BaseClass;

public class LoginPage extends BaseClass {


    Constants cs = new Constants(BaseClass.driver);

    public LoginPage(WebDriver driver) {

        BaseClass.driver = driver;
        PageFactory.initElements(driver, this);
        cs = new Constants(driver);
    }


    @FindBy(xpath="//input[@id='user-name']")
    WebElement username;

    @FindBy(xpath="//input[@id='password']")
    WebElement password;

    @FindBy(xpath="//input[@id='login-button']")
    WebElement loginbutton;

    @FindBy(xpath="//h3//button[@class='error-button']")
    WebElement errormessage;



    @FindBy(xpath="//div[@class='app_logo']")
    WebElement title;


    @FindBy(xpath="//span[text() = 'Products']")
    WebElement Products;


    @FindBy(xpath="//button[text() = 'Open Menu']")
    WebElement Openmenu;


    @FindBy(xpath="//a[@id='logout_sidebar_link']")
    WebElement logoutbutton;

    public void clickonlogout(){
        cs.click(Openmenu);
        cs.click(logoutbutton);
    }



    public void email(String Text)

    {

        cs.sendKeys(username, Text);
    }

    public void password(String Text)

    {

        cs.sendKeys(password, Text);
    }

    public void clickonloginbutton()
    {
        cs.click(loginbutton);
    }

    public boolean errormessagedisplay()
    {
        return cs.isDisplayed(errormessage);
    }

    public boolean productpageisdiapyed()
    {
        return cs.isDisplayed(Products);
    }


}
