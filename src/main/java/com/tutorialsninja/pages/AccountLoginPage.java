package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AccountLoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/div/div[2]//h2")
    WebElement returningCustomerText;
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/div/div[1]//h2")
    WebElement newCustomerText;

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailAddressField;

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginBtn;

    public String getReturningCustomerText() {
        Reporter.log("Get text from " + returningCustomerText.toString());
        String message= getTextFromElement(returningCustomerText);
        CustomListeners.test.log(Status.PASS,"Returning CustomerText");
        return message;

    }


    public String getNewCustomerText() {
        Reporter.log("Get text from " + newCustomerText.toString());
        String message= getTextFromElement(newCustomerText);
        CustomListeners.test.log(Status.PASS,"GetCustomer Text");
        return message;

    }

    public void enterEmailAddress(String email) {
        Reporter.log("Enter email " + email + " to email field " + emailAddressField.toString());
        sendTextToElement(emailAddressField, email);
        CustomListeners.test.log(Status.PASS,"Enter EmailId " + email);
    }

    public void enterPassword(String password) {
        Reporter.log("Enter password " + password + " to password field " + passwordField.toString());
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS,"Enter Password " + password);
    }

    public void clickOnLoginButton() {
        Reporter.log("Clicking on Login Link " + loginBtn.toString());
        clickOnElement(loginBtn);
        CustomListeners.test.log(Status.PASS,"Click on loginButton");
    }

}
