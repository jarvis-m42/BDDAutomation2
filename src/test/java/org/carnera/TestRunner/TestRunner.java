package org.carnera.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        features = "src/test/resources/features/CarneraHomepage.feature",
        glue = {"org.carnera.stepdef", "org.carnera.Hooks"},
        tags = "@UATTesting", plugin = {"pretty",
        "html:target/site/cucumber-pretty.html",
        "json:target/cucumber.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {



}
