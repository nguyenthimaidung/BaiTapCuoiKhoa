package com.vmo.nopcommerce.features.hompage;

import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.pageobject.HomePageObject;
import com.vmo.nopcommerce.pageobject.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangeCurrency extends BaseTest {
    WebDriver driver;
    private HomePageObject homepage;

    @BeforeMethod
    public void setup(String browser) {
        driver = getDriverBrowser(browser);
        driver.manage().window().maximize();
        homepage = PageGenerator.getHomePageObject(driver);
    }
    @Test
    public void TC06_ChangeCurrency(){
        homepage.gotoURL("https://demo.nopcommerce.com/");
        homepage.verifyTitle("nopCommerce demo store");
        homepage.selectCurrency("Euro");
        homepage.verifyCurrencyDisplayed();
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
