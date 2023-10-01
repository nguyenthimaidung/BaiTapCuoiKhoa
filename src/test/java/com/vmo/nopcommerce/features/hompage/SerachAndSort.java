package com.vmo.nopcommerce.features.hompage;

import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.helper.Log;
import com.vmo.nopcommerce.pageobject.HomePageObject;
import com.vmo.nopcommerce.pageobject.PageGenerator;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Epic("Nopcommerce")
@Feature("HomePage")
@Story("SearchAndSort")

public class SerachAndSort extends BaseTest {
    WebDriver driver;
    private HomePageObject productsearch;

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser){
        driver = getDriverBrowser(browser,"local");
        productsearch = PageGenerator.getHomePageObject(driver);
    }
    @Test
    public void TC03_ProductSearchAndSort(){
        productsearch.gotoURL("https://demo.nopcommerce.com/");
        productsearch.verifyTitle("nopCommerce demo store");
        productsearch.clickComputer_Software();
        productsearch.optionSortBy("6");
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        cleanBrowserAndDriver();
    }
}
