package com.vmo.nopcommerce.features.homepage;

import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.pageobject.HomePageObject;
import com.vmo.nopcommerce.pageobject.PageGenerator;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Epic("Nopcommerce")
@Feature("HomePage")
@Story("Production Search Successfully")
public class ProductionSearchSuccessfully extends BaseTest {

    WebDriver driver;
    private HomePageObject productsearch;

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser){
        driver = getDriverBrowser(browser,"grid");
        productsearch = PageGenerator.getHomePageObject(driver);
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
        cleanBrowserAndDriver();
    }
}
