package com.selenium.sourcedemo.tests;
import Pages.LoginPage;
import Pages.ProductsPage;
import base.TestUtils;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProductTestAddItemsToCart extends TestUtils {

    @Test
    public void addItemToTheCart() {
        LoginPage loginPage = new LoginPage(driver);

        ProductsPage productPage = loginPage.login("standard_user", "secret_sauce");

        productPage.addToCartByProductName("bolt-t-shirt");
        productPage.addToCartByProductName("fleece-jacket");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(productPage.getNumbersInTheCart(), 2,
                "Atleast two items must be added.");

        softAssert.assertAll();

    }
}
