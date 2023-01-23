package org.carnera.base;


import org.carnera.utils.ReadConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;

public class DriverManager {

    static WebDriver driver;

    public static void setDriver()
    {
        switch (ReadConfig.getBrowser())
        {
            case "chrome":
               // WebDriverManager.chromedriver().setup();
                driver =  new ChromeDriver();

                break;
            case "firefox":
               // WebDriverManager.firefoxdriver().setup();
                driver =  new FirefoxDriver();
                break;
            case "IE":
              //  WebDriverManager.iedriver().setup();
                driver =  new InternetExplorerDriver();
                break;
            case "EDGE":
              //  WebDriverManager.edgedriver().setup();
                driver =  new EdgeDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    public static WebDriver getDriver()
    {
        return driver;
    }

}
