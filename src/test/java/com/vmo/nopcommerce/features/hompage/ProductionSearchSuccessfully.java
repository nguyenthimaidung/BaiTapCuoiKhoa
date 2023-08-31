package com.vmo.nopcommerce.features.hompage;

import com.vmo.nopcommerce.pageobject.HomePageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductionSearchSuccessfully {

    WebDriver driver;
    private HomePageObject productsearch;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        productsearch = new HomePageObject(driver);
    }
    @Test
    public void TC02_ProductSearch(){
        productsearch.gotoURL("https://demo.nopcommerce.com/");
        productsearch.verifyTitle("nopCommerce demo store");
        productsearch.inputTextBoxSearch();
        productsearch.clickBtnSearch();
        productsearch.verifySerachProductResult();
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
