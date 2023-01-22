package org.carnera.Hooks;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.carnera.base.BaseTest;
import org.carnera.base.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Servicehooks {

    public String url;
    protected WebDriver driver;

    BaseTest baseTest;

    @Before
    public void setup(Scenario scenario) {
        List<String> s = (List<String>) scenario.getSourceTagNames();
        DriverManager.setDriver();
        BaseTest.driver = DriverManager.getDriver();
        BaseTest.wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));
        BaseTest.scenario = scenario;
    }
    public String getBase64Screenshot()
    {
        return ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.BASE64);
    }
//    @AfterStep
//    public void as(Scenario scenario) throws IOException, InterruptedException
//    {
//        ExtentCucumberAdapter.getCurrentStep().log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Screenshot()).build());
//    }
    @After
    public void TearDown(Scenario scenario) {
        if(scenario.isFailed())
        {
            ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Screenshot()).build());
            BaseTest.driver.quit();
        }
        if(BaseTest.driver!=null)
        {
            BaseTest.driver.quit();
        }

    }
}
