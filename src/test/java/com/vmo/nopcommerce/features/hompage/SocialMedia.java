package com.vmo.nopcommerce.features.hompage;

import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.pageobject.HomePageObject;
import com.vmo.nopcommerce.pageobject.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SocialMedia extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser){
        driver = getDriverBrowser(browser);
        homePage = PageGenerator.getHomePageObject(driver);
        //productsearch = new HomePageObject(driver),
    }
    @Test
    public void TC07_CheckselecctSocialMedia(){
        homePage.gotoURL("https://demo.nopcommerce.com/");
        homePage.verifyTitle("nopCommerce demo store");
        homePage.clickFacebook();
        homePage.verifyTitleFacebook();
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        cleanBrowserAndDriver();
    }
}
