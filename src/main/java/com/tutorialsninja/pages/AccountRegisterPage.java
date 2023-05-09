package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

/**
 * Created by Jay Vaghani
 */
public class AccountRegisterPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement registerAccountText;
    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstNameField;
    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastNameField;
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailField;
    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement telephoneField;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement passwordConfirmField;

    @CacheLookup
    @FindBy(xpath = "//fieldset[3]//input")
    WebElement subscribeRadios;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@name='agree']")
    WebElement privacyPolicyCheckBox;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement continueBtn;
    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginBtn;

    public String getRegisterAccountText() {
        Reporter.log("Get Register Account Text  " + registerAccountText.toString());
        String message= getTextFromElement(registerAccountText);
        CustomListeners.test.log(Status.PASS,"Get RegisterText");
        return message;
    }

    public void enterFirstName(String fName) {
        Reporter.log("Enter FirstName " + "  first name field" + emailField.toString());
        sendTextToElement(firstNameField, fName);
        CustomListeners.test.log(Status.PASS,"Enter First Name " + fName);
    }

    public void enterLastName(String lName) {
        Reporter.log("Enter LastName " + " to last name field" +lastNameField.toString());
        sendTextToElement(lastNameField, lName);
        CustomListeners.test.log(Status.PASS,"Enter Last Name " );
    }

    public void enterEmail(String email) {
        Reporter.log("Enter email " + email + " to email field " + emailField.toString());
        sendTextToElement(emailField, email);
        CustomListeners.test.log(Status.PASS,"Enter EmailId " + email);

    }

    public void enterTelephone(String telephone) {
        Reporter.log("Enter Telephone " +  " to telephone field " + telephoneField.toString());
        sendTextToElement(telephoneField, telephone);
        CustomListeners.test.log(Status.PASS,"Enter Telephone " + telephone);
    }

    public void enterPassword(String password) {
        Reporter.log("Enter password " + password + " to password field " +passwordField.toString());
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS,"Enter Password " + password);
    }

    public void enterConfirmPassword(String cPassword) {
        Reporter.log("Enter Confirm password " +  " to  Confirm password field " + passwordConfirmField.toString());
        sendTextToElement(passwordConfirmField,cPassword);
        CustomListeners.test.log(Status.PASS,"Enter telephone " );
    }

    public void selectSubscription(String option) {
        List<WebElement> radioButtons = getListOfElements(By.xpath("//fieldset[3]//input"));
        for (WebElement e : radioButtons) {
            if (e.getText().equals(option)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnPrivacyPolicyCheckBox() {
        Reporter.log("Clicking on Privacy CheckBox " + privacyPolicyCheckBox.toString());
        clickOnElement(privacyPolicyCheckBox);
        CustomListeners.test.log(Status.PASS,"Click on privacy checkBox");
    }

    public void clickOnContinueButton() {
        Reporter.log("Clicking on Continue button " + continueBtn.toString());
        clickOnElement(continueBtn);
        CustomListeners.test.log(Status.PASS,"Click on loginButton");
    }

}
