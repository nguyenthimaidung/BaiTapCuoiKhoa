package com.vmo.nopcommerce.features.hompage;

import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.helper.Log;
import com.vmo.nopcommerce.pageobject.HomePageObject;
import com.vmo.nopcommerce.pageobject.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ProductionSearchSuccessfully extends BaseTest {

    WebDriver driver;
    private HomePageObject productsearch;

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser){
        driver = getDriverBrowser(browser);
        productsearch = PageGenerator.getHomePageObject(driver);
        Log.info("Open driver success");
    }
    @Test
    public void TC02_ProductSearch(){
        productsearch.gotoURL("https://demo.nopcommerce.com/");
        productsearch.verifyTitle("nopCommerce demo store");
        Log.info("Open correct page");
        productsearch.inputTextBoxSearch();
        Log.info("Input data search success");
        productsearch.clickBtnSearch();
        productsearch.verifySerachProductResult();
        Log.info("Product displayed the same data input");
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        cleanBrowserAndDriver();
        Log.info("Close dirver success");
    }
}
