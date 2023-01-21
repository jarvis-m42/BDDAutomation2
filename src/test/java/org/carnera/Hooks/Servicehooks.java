package org.carnera.Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.carnera.base.BaseTest;
import org.carnera.base.DriverManager;
import org.carnera.utils.ExtentListeners;
import org.carnera.utils.LogUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Servicehooks {

    public String url;
    protected WebDriver driver;

    BaseTest baseTest;

    @Before
    public void setup(Scenario scenario) {
        DriverManager.setDriver();
        BaseTest.driver = DriverManager.getDriver();
        BaseTest.wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));
        ExtentListeners.CreateTest("1","0",scenario.getName());
        ExtentListeners.startScenario(scenario.getName());
    }
    @After
    public void TearDown(Scenario scenario) {
        // One of "passed", "undefined", "pending", "skipped", "failed"
        try {

            if (scenario.isFailed())
                ExtentListeners.TestFailure(scenario.getName());
            else if (scenario.getStatus().equals("passed"))
                ExtentListeners.TestSuccess(scenario.getName());
            else if (scenario.getStatus().equals("skipped"))
                ExtentListeners.TestSkip(scenario.getName());
            else {
                ExtentListeners.testReport.get().info("Scenario " + scenario.getName() + " is " + scenario.getStatus());
                LogUtil.logInfo("Scenario " + scenario.getName() + " is Completed");
            }
        } catch (Exception e) {
            LogUtil.logExceptionMessage(e, "Exception occurred in after hooks after executing each test cases");
        }

    }
}
