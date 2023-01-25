package org.carnera.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.carnera.base.BaseTest;

import org.carnera.utils.Constants;
import org.carnera.utils.ReadConfig;

public class UIStepdef extends BaseTest {

    @Given("I open {string} application")
    public void iOpenGivenApplication(String appName) {

        // We can take constant values from YML file using a reusable function created in utils.ReadConfig class
        //driver.get(ReadConfig.getAppURL(appName));

        // We can take constant values from Class Static variables
        driver.get(Constants.URL);
    }

}
