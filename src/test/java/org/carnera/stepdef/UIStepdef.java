package org.carnera.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.carnera.base.BaseTest;

import org.carnera.utils.ReadConfig;

public class UIStepdef extends BaseTest {

    @Given("I open {string} application")
    public void iOpenGivenApplication(String appName) {

        driver.get(ReadConfig.getAppURL(appName));
    }

}
