package com.Constants;

import java.io.File;
import java.time.Duration;

import com.BaseClass.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Constants extends BaseClass {


    public Constants(WebDriver driver)
    {
        this.driver=driver;

    }


    public WebElement waitForElementVisible(WebElement element, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(WebElement element) {
        waitForElementVisible(element,10).click();
    }

    public void javascriptClick(WebElement element) {
        WebElement visibleElement = waitForElementVisible(element, 10);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", visibleElement);
    }


    public void sendKeys(WebElement element, String text) {
        waitForElementVisible(element, 10).clear();
        waitForElementVisible(element, 10).sendKeys(text);
    }


    public boolean isDisplayed(WebElement element) {
        try {
            waitForElementVisible(element, 10);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void selectDropdownByVisibleText(WebElement element, String visibleText) {
        waitForElementVisible(element, 10);
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(visibleText);
    }

    public void screenshot(String path) {

        TakesScreenshot TS = (TakesScreenshot)driver;
        File source = TS.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(source, new File(path));
        }
        catch(Exception e) {

            System.out.println("Screenshot not fount");
        }
    }

    public void moveToElementAndClick(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }


}
