package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ShoppingCartPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement shoppingCartText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productName;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement deliveryDate;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
    WebElement model;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement total;
    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    WebElement qtyField;
    @CacheLookup
    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")
    WebElement qtyUpdateBtn;
    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement successModifiedMessage;


    public String getShoppingCartText() {
        return getTextFromElement(shoppingCartText);
    }

    public String getProductName() {
        Reporter.log("Get Priduct Name  " + productName.toString());
        String message = getTextFromElement(productName);
        CustomListeners.test.log(Status.PASS, "product name");
        return message;
    }

    public String getDeliveryDate() {
        Reporter.log("Get Delivery Date  " + deliveryDate.toString());
        String message = getTextFromElement(deliveryDate);
        CustomListeners.test.log(Status.PASS, "delivery date");
        return message;
    }

    public String getModel() {
        Reporter.log("Get model  " + model.toString());
        String message = getTextFromElement(model);
        CustomListeners.test.log(Status.PASS, "get model");
        return message;
    }

    public String getTotal() {
        Reporter.log("Get Total  " + total.toString());
        String message = getTextFromElement(total);
        CustomListeners.test.log(Status.PASS, " total");
        return message;
    }

    public void changeQuantity(String qty) {
        Reporter.log("change Quantity " + qtyField.toString());
        sendTextToElement(qtyField, qty);
        CustomListeners.test.log(Status.PASS, "quantity field");
    }

    public void clickOnQtyUpdateButton() {
        Reporter.log("Clicking on update Button " + qtyUpdateBtn.toString());
        clickOnElement(qtyUpdateBtn);
        CustomListeners.test.log(Status.PASS, "Click on update Button");
    }

    public String getSuccessModifiedMessage() {
        Reporter.log("Get Success Modified Message  " + successModifiedMessage.toString());
        String message = getTextFromElement(successModifiedMessage);
        CustomListeners.test.log(Status.PASS, "Get Success ModifiedMessage");
        return message;
    }
}


