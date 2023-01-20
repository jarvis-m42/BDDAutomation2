package org.carnera.stepdef;

import io.cucumber.java.en.Then;
import org.carnera.ReusableMethods.ElementUtils;
import org.carnera.Utility.PropertyFileReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.carnera.base.BaseTest;
import org.carnera.pageObjects.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.Properties;

public class CarneraHomepageStepDef extends BaseTest {

    HomePage hm = new HomePage(driver);

    @Then("I see text {string} is visible")
    public void iSeeTextIsVisible(String text) {
        System.out.println("Carnera step "+driver);
        hm.checkText();
    }

    @And("I click on contact us button")
    public void iClickOnContactUsButton() {
    }

    @Then("I fill form with {string},{string},{string},{string},{string}")
    public void iFillFormWith(String arg0, String arg1, String arg2, String arg3, String arg4) {
    }

}
