package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ComponentsPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//body/div[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]")
    WebElement components;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Show AllComponents')]")
    WebElement showAllComponents;

    public void mouseHoverOnComponentsAndClick() {
        Reporter.log("MouseHover on components link " + components.toString());
        clickOnElement(components);
        CustomListeners.test.log(Status.PASS,"MouseHover on components");
    }

    public void clickOnShowAllComponents() {
        Reporter.log("Clicking on Show All Components Link " + showAllComponents.toString());
        clickOnElement(showAllComponents);
        CustomListeners.test.log(Status.PASS,"Click on showAllComponente");

    }
}
