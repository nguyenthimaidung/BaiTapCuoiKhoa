package com.vmo.nopcommerce.features.passwordrrecovery;

import com.vmo.nopcommerce.pageobject.HomePageObject;
import com.vmo.nopcommerce.pageobject.PasswordRecoveryObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ForgotPasswordSuccessfully {

    WebDriver driver;
    private PasswordRecoveryObject forgot;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        forgot = new PasswordRecoveryObject(driver);
    }
    @Test
    public void TC04_ForgotPassword(){
        forgot.gotoURL("https://demo.nopcommerce.com/");
        forgot.verifyTitle("nopCommerce demo store");
        forgot.clickLogin();
        forgot.verifyTitle("nopCommerce demo store. Login");
        forgot.clickForgotPassword();
        forgot.verifyTitle("nopCommerce demo store. Password Recovery");
        forgot.inputEmail("dungntm@vmogroup.com");
        forgot.clickBtnRecover();
        forgot.verifyMessage();
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
