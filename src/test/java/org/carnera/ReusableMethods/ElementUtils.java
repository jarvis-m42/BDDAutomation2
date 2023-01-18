package org.carnera.ReusableMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementUtils {


    WebDriver driver;

    public ElementUtils(WebDriver driver) {

        this.driver = driver;

    }

    // Reusable method to click on WebElement
    public void clickOnElement(WebElement element, long durationInSeconds) {

        WebElement webElement = waitForElement(element, durationInSeconds);
        webElement.click();

    }

    // Reusable method to enter test on WebElement
    public void typeTextIntoElement(WebElement element, String textToBeTyped, long durationInSeconds) {

        WebElement webElement = waitForElement(element, durationInSeconds);
        webElement.click();
        webElement.clear();
        webElement.sendKeys(textToBeTyped);

    }

    // Reusable method to wait for WebElement
    public WebElement waitForElement(WebElement element, long durationInSeconds) {

        WebElement webElement = null;

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Throwable e) {
            e.printStackTrace();
        }

        return webElement;

    }

    // Reusable method to select from dropdown
    public void selectOptionInDropdown(WebElement element, String dropDownOption, long durationInSeconds) {

        WebElement webElement = waitForElement(element, durationInSeconds);
        Select select = new Select(webElement);
        select.selectByVisibleText(dropDownOption);

    }

    // Reusable method to Accept alert
    public void acceptAlert(long durationInSeconds) {

        Alert alert = waitForAlert(durationInSeconds);
        alert.accept();

    }

    // Reusable method to Dismiss Alert
    public void dismissAlert(long durationInSeconds) {

        Alert alert = waitForAlert(durationInSeconds);
        alert.dismiss();

    }

    // Reusable method to wait for an alert
    public Alert waitForAlert(long durationInSeconds) {

        Alert alert = null;

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            alert = wait.until(ExpectedConditions.alertIsPresent());
        } catch (Throwable e) {
            e.printStackTrace();
        }

        return alert;

    }

    // Reusable method to perform MouseHover and Click
    public void mouseHoverAndClick(WebElement element, long durationInSeconds) {

        WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).click().build().perform();

    }

    // Reusable method to wait for Visibility of WebElement
    public WebElement waitForVisibilityOfElement(WebElement element, long durationInSeconds) {

        WebElement webElement = null;

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            webElement = wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Throwable e) {
            e.printStackTrace();
        }

        return webElement;

    }

    // Reusable method to click on WebElement using Javascript executor
    public void javaScriptClick(WebElement element, long durationInSeconds) {

        WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("arguments[0].click();", webElement);

    }

    // Reusable method to Enter Text using Javascript executor
    public void javaScriptType(WebElement element, long durationInSeconds, String textToBeTyped) {

        WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("arguments[0].value='" + textToBeTyped + "'", webElement);

    }

    // Reusable method to get text of WebElement
    public String getTextFromElement(WebElement element, long durationInSeconds) {

        WebElement webElement = waitForElement(element, durationInSeconds);
        return webElement.getText();

    }

    // Reusable method to see the status of WebElement (wait for visibility and is displayed or not)
    public boolean displayStatusOfElement(WebElement element, long durationInSeconds) {

        try {
            WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
            return webElement.isDisplayed();
        } catch (Throwable e) {
            return false;
        }

    }

}
