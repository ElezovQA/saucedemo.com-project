package com.selenium.sourcedemo.tests;
import Pages.*;
import base.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutTest extends TestUtils {

    @Test
    public void checkOutTest() {
        LoginPage loginPage = new LoginPage(driver);

        ProductsPage productPage = loginPage.login("standard_user", "secret_sauce");

        productPage.addToCartByProductName("backpack");
        productPage.addToCartByProductName("bike-light");

        Assert.assertEquals(productPage.getNumbersInTheCart(), 2,
                "Atleast two items must be added.");

        YourCartPage yourCartPage = productPage.clickOnCart();

        WebElement qtyDescriptionLabel = driver.findElement(By.className("cart_desc_label"));
        Assert.assertTrue(qtyDescriptionLabel.isDisplayed());

       CheckOutPage checkOutPage = yourCartPage.clickOnCheckout();

        WebElement cancelBtn = driver.findElement(By.id("cancel"));
        Assert.assertTrue(cancelBtn.isDisplayed());

       CheckOutOverViewPage checkOutOverViewPage = checkOutPage.checkoutInfo();

        WebElement summaryInfo = driver.findElement(By.className("summary_info"));
        Assert.assertTrue(summaryInfo.isDisplayed());

       CheckOutCompletePage checkOutCompletePage = checkOutOverViewPage.clickOnFinish();

        WebElement backHomeBtn = driver.findElement(By.id("back-to-products"));
        Assert.assertTrue(backHomeBtn.isDisplayed());

    }
}
