package org.carnera.pageObjects;

import lombok.Data;
import org.carnera.utils.Constants;
import org.carnera.utils.POIConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

@Data
public class HomePage {

    //creating object of POIConfig class
    static POIConfig excelUtils = new POIConfig();

    //using the Constants class values for excel file path
    static String excelFilePath = Constants.Path_TestData+Constants.File_TestData;

    WebDriver driver;

    @FindBy(xpath = "//div/a[@href='/hire-your-team']")
    WebElement contactUs;

    @FindBy(css = "[data-title='First']")
    WebElement firstName;

    @FindBy(css = "[data-title='Last']")
    WebElement lastName;

    @FindBy(css = "[name='email']")
    WebElement email;

    @FindBy(css = "[id='textarea-yui_3_17_2_1_1607380170821_8983-field']")
    WebElement about;

    @FindBy(css = "[placeholder='E.g: Monday, 10am PT']")
    WebElement timeToContact;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void checkText(String text)
    {
        Assert.assertEquals(contactUs.getText(), text);
    }

}
