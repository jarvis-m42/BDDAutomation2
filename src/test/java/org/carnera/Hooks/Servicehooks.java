package org.carnera.Hooks;

import io.cucumber.java.Before;
import org.carnera.base.BaseTest;
import org.carnera.base.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Servicehooks {

    public String url;
    protected WebDriver driver;

    BaseTest baseTest;

    @Before
    public void setup() {
        DriverManager.setDriver();
        BaseTest.driver = DriverManager.getDriver();
        BaseTest.wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));
    }
}
