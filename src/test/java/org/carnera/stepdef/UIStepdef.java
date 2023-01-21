package org.carnera.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.carnera.base.BaseTest;
import org.carnera.utils.ExtentListeners;
import org.carnera.utils.ReadConfig;

public class UIStepdef extends BaseTest {

    @Given("I open {string} application")
    public void iOpenGivenApplication(String appName) {
        ExtentListeners.CreateGherkinNode("And", "I open "+appName+" application");
        driver.get(ReadConfig.getAppURL(appName));
    }


    @Then("I close all tabs")
    public void iCloseAllTabs() {
        ExtentListeners.CreateGherkinNode("And", "I close all tabs");

        hardWait(5000);
        closeAllTabs();
    }
}
