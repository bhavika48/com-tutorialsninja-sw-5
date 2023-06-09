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

public class LaptopsAndNoteBooksPage extends Utility {
    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopsAndNoteBooks;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Show AllLaptops & Notebooks')]")
    WebElement showAllLaptopsAndNotebooks;

    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    WebElement productsPrices;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    WebElement productsList;
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortBy;

    public void mouseHoverOnLaptopsAndNoteBooksAndClick() {
        Reporter.log("MouseHoverAndClick on LaptopsAndNotebooks link " + laptopsAndNoteBooks.toString());
        clickOnElement(laptopsAndNoteBooks);
        CustomListeners.test.log(Status.PASS, "MouseHover on laptopsAndNotebooksLink");

    }

    public void clickOnShowAllLaptopsAndNotebooks() {
        Reporter.log("Clicking on ShowAllLaptopsAndNotebooks  Link " + showAllLaptopsAndNotebooks.toString());
        clickOnElement(showAllLaptopsAndNotebooks);
        CustomListeners.test.log(Status.PASS, "Click on laptopsAndNotebooksLink");
    }

    public ArrayList<Double> getProductsPriceList() {
        List<WebElement> products = getListOfElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        return originalProductsPrice;
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
