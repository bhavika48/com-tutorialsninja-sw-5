package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class MyAccountPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement accountLogoutText;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement accountCreatedText;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueBtn;

    public String getAccountLogoutText() {
        Reporter.log("Get Account Logout text  " + accountLogoutText.toString());
       String message= getTextFromElement(accountLogoutText);
        CustomListeners.test.log(Status.PASS,"Logout Text");
        return message;
    }

    public String getYourAccountHasBeenCreatedText() {
        Reporter.log("Get Account Has Been Created  text  " + accountCreatedText.toString());
        String message= getTextFromElement(accountCreatedText);
        CustomListeners.test.log(Status.PASS,"account created Text");
        return message;
    }
    public void clickOnContinueButton() {
        Reporter.log("Clicking on Continue Button " + continueBtn.toString());
        clickOnElement(continueBtn);
        CustomListeners.test.log(Status.PASS,"Click on Continue Button");
    }
}
