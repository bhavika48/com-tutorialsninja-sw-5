package com.tutorialsninja.pages;


import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import java.util.List;

@Listeners(CustomListeners.class)
public class HomePage extends Utility{
    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
    WebElement topMenuBar;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currencyTab;

    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktopLink;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountTab;

    @CacheLookup
    @FindBy(xpath = "//div[@id='top-links']//li[contains(@class,'open')]/ul/li")
    WebElement myAccountOptions;
    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopsAndNotebooksLink;


    public void selectMenuBar(String menu) {
        List<WebElement> topMenuList = driver.findElements((By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")));
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements((By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")));
        }
    }

    public void selectCurrency(String currency) {
        clickOnElement(currencyTab);
        List<WebElement> listOfElements = getListOfElements(By.xpath("//ul[@class = 'dropdown-menu']/li"));
        for (WebElement e : listOfElements) {
            if (e.getText().equalsIgnoreCase(currency)) {
                e.click();
                break;
            }
        }
    }

    public void mouseHoverOnDesktopsLinkAndClick() {
        Reporter.log("MouseHoverAndClick on desktop link " + laptopsAndNotebooksLink.toString());
        mouseHoverToElementAndClick(desktopLink);
        CustomListeners.test.log(Status.PASS,"MouseHover on desktops  link");
        CustomListeners.test.log(Status.PASS,"mouseHover on desktop ");
    }


    public void clickOnMyQAccountTab() {
        Reporter.log("Clicking on Show All Components Link " + myAccountTab.toString());
        clickOnElement(myAccountTab);
    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = getListOfElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = getListOfElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        }
    }

    public void mouseHoverOnLaptopsAndNotebooksLinkAndClick() {
        Reporter.log("MouseHoverAndClick on LaptopsAndNotebooks link " + laptopsAndNotebooksLink.toString());
        mouseHoverToElementAndClick(laptopsAndNotebooksLink);
        CustomListeners.test.log(Status.PASS,"MouseHover on laptopsAndNotebooksLink");

    }
}






