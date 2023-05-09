package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.DesktopsPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.ProductPage;
import com.tutorialsninja.pages.ShoppingCartPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;

public class DeskTopsPageTest extends BaseTest {
    DesktopsPage deskTopsPage;
    HomePage homePage;
    ProductPage productPage;
    ShoppingCartPage cartPage;


    @BeforeMethod
    public void inIt() {
        deskTopsPage = new DesktopsPage();
        homePage = new HomePage();
        productPage = new ProductPage();
        cartPage = new ShoppingCartPage();

    }
}
