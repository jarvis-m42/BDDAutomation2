package org.carnera.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {


    public static WebDriver driver;
    public static WebDriverWait wait;

    public void clickElement(WebElement ele) {
        wait.until(ExpectedConditions.visibilityOf(ele));
        ele.click();
    }

    public BaseTest sendText(WebElement ele, String text) {
        wait.until(ExpectedConditions.visibilityOf(ele));
        ele.clear();
        ele.sendKeys(text);
        return this;
    }

    public void closeTab() {
        driver.close();
    }

    public void closeAllTabs() {
        driver.quit();
    }

    public WebElement waitForElement(WebElement element, long durationInSeconds) {

        WebElement webElement = null;

        try {

            webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Throwable e) {
            e.printStackTrace();
        }

        return webElement;

    }

    public void selectOptionInDropdown(WebElement element, String dropDownOption, long durationInSeconds) {

        WebElement webElement = waitForElement(element, durationInSeconds);
        Select select = new Select(webElement);
        select.selectByVisibleText(dropDownOption);

    }
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


    public void hardWait(int miliSeconds) {
        try {
            Thread.sleep(miliSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
