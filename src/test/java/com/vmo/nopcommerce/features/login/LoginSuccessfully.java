package com.vmo.nopcommerce.features.login;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.pageobject.HomePageObject;
import com.vmo.nopcommerce.pageobject.LoginPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginSuccessfully extends BaseTest {
    private WebDriver driver;
    private LoginPageObject loginpage;
    private HomePageObject homepage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginpage = new LoginPageObject(driver);
    }

    @Test
    public void Login_01_Loginsuccessfully(){

    }



    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
