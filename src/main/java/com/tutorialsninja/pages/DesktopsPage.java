package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;

public class DesktopsPage extends Utility {


    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement lookUpDesktops;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Show AllDesktops')]")
    WebElement showAllDesktops;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-sort']")
    WebElement sortByPosition;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    WebElement productsList;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortBy;


    public void mouseHoverOnDesktopsAndClick() {
        Reporter.log("MouseHover on Dektops link " + lookUpDesktops.toString());
        clickOnElement(lookUpDesktops);
        CustomListeners.test.log(Status.PASS,"MouseHover on Dektops");

    }

    public void clickOnShowAllDeskTops() {
        Reporter.log("Clicking on Show All Components Link " + showAllDesktops.toString());
        clickOnElement(showAllDesktops);
        CustomListeners.test.log(Status.PASS,"Click on showAllComponente");
    }

    public void sortingDesktopsFromZtoA(String name) {
        Reporter.log(" Sorting DropDown to Z  to A " + sortByPosition.toString());
        selectByVisibleTextFromDropDown(sortByPosition, name);
        CustomListeners.test.log(Status.PASS,"Sorting DrpDown");

    }

    public ArrayList<String> getProductsNameList() {
        List<WebElement> products = getListOfElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        return originalProductsName;
    }

    public void selectSortByOption(String option) {
        selectByVisibleTextFromDropDown(sortBy, option);
    }

    public void selectProductByName(String product) {
        List<WebElement> products = getListOfElements(By.xpath("//h4/a"));
        for (WebElement e : products) {
            if (e.getText().equals(product)) {
                e.click();
                break;
            }
        }
    }
}
