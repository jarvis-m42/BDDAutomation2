package org.carnera.TestRunner;

import io.cucumber.java.BeforeAll;
import io.cucumber.testng.*;
import org.carnera.base.BaseTest;
import org.carnera.utils.ExtentListeners;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features/CarneraHomepage.feature",
        glue = {"org.carnera.stepdef","org.carnera.Hooks"},
        tags = "@UATTesting",plugin = {"pretty",
        "html:target/site/cucumber-pretty.html",
        "json:target/cucumber.json"},
        monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void setupBeforeClass()
    {
        BaseTest.Init();
    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        ExtentListeners.FlushReport();
    }

}
