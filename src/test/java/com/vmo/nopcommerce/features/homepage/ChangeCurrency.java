package com.vmo.nopcommerce.features.homepage;

import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.pageobject.HomePageObject;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
//@Listeners(TestNGListener.class)

@Epic("Nopcommerce")
@Feature("HomePage")
@Story("Change Currency")
public class ChangeCurrency extends BaseTest {
    public WebDriver driver;
    private HomePageObject homepage;
//    private String browser = "CHROME";
//    @BeforeMethod
//    public void setup(){
//        driver = getDriverBrowser(browser);

//    }
    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser){
        driver = getDriverBrowser(browser,"grid");
        homepage = new HomePageObject(driver);
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
