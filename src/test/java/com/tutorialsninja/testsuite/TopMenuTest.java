package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.ComponentsPage;
import com.tutorialsninja.pages.DesktopsPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopsAndNoteBooksPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class TopMenuTest extends BaseTest {
    HomePage homePage;
    DesktopsPage deskTops;
    LaptopsAndNoteBooksPage laptopsAndNoteBooks;
    ComponentsPage componentsPage;

    @BeforeMethod
    public void inIt() {
        homePage = new HomePage();
        deskTops = new DesktopsPage();
        laptopsAndNoteBooks = new LaptopsAndNoteBooksPage();
        componentsPage = new ComponentsPage();
    }

    @Test(groups = {"Sanity" , "Smoke", "Regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        deskTops.mouseHoverOnDesktopsAndClick();
        homePage.selectMenuBar("Show AllDesktops");
        // homePage.clickOnShowAllDeskTops();
        laptopsAndNoteBooks.mouseHoverOnLaptopsAndNoteBooksAndClick();
        laptopsAndNoteBooks.clickOnShowAllLaptopsAndNotebooks();
        componentsPage.mouseHoverOnComponentsAndClick();
      componentsPage.clickOnShowAllComponents();


    }



}
