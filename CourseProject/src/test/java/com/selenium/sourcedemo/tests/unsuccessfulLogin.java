package com.selenium.sourcedemo.tests;
import base.TestUtils;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class unsuccessfulLogin extends TestUtils {

    @DataProvider(name = "UsersCsv")
    public static Object[][] readUsersFromCsv() throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/UsersList.csv"))) {
            List<String[]> csvData = csvReader.readAll();
            Object[][] csvDataObject = new Object[csvData.size()][2];
            for (int i = 0; i < csvData.size(); i++) {
                csvDataObject[i] = csvData.get(i);
            }
            return csvDataObject;
        }
    }

    @Test(dataProvider = "UsersCsv")
    public void unsuccessLogin(String userName, String password) {

        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.sendKeys(userName);
        userNameInput.clear();

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(password);
        userNameInput.clear();

        WebElement lgnBtn = driver.findElement(By.id("login-button"));
        lgnBtn.click();

        WebElement wrongUserBtn = driver.findElement(By.cssSelector(".error-button"));

        Assert.assertTrue(wrongUserBtn.isDisplayed());
    }
}

