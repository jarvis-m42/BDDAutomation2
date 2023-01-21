package org.carnera.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.carnera.base.BaseTest;
import org.carnera.pageObjects.HomePage;
import org.carnera.utils.ExtentListeners;

public class CarneraHomepageStepDef extends BaseTest {

    HomePage hm = new HomePage(driver);

    @Then("I see text {string} is visible")
    public void iSeeTextIsVisible(String text) {
        ExtentListeners.CreateGherkinNode("Then", "I see text "+text+" is visible");
        hm.checkText(text);
    }

    @And("I click on contact us button")
    public void iClickOnContactUsButton() {

        ExtentListeners.CreateGherkinNode("And", "I click on contact us button");

        clickElement(hm.getContactUs());
    }

    @Then("I fill form with {string},{string},{string},{string},{string}")
    public void iFillFormWith(String name, String lname, String email, String about, String time) {
        ExtentListeners.CreateGherkinNode("And", "I fill Registration form");
        sendText(hm.getFirstName(), name).sendText(hm.getLastName(), lname).sendText(hm.getEmail(), email).sendText(hm.getAbout(), about).sendText(hm.getTimeToContact(), time);
    }

}
