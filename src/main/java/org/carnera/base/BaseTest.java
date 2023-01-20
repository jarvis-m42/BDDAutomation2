package org.carnera.base;

import org.openqa.selenium.WebDriver;

public class BaseTest {


    public static WebDriver driver;

    public void flush() {
        driver.quit();
    }

}
