package com.vmo.nopcommerce.pageobject;

import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.helper.Log;
import com.vmo.nopcommerce.interfaces.LoginPageUI;
import com.vmo.nopcommerce.interfaces.RegisterUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPageObject extends BaseTest {
    WebDriver driver;
    public LoginPageObject(WebDriver driver){
        this.driver = driver;
    }
    public void gotoURL(String value){
        gotoURL(driver,value);
    }
    public void verifyTitle(String value){
        Assert.assertEquals(driver.getTitle(),value);
        Log.allure("Open correct page");
    }
    public void inputUserName(String value){
        sendKeyToElement(driver, LoginPageUI.TXT_USERNAME,value);
        Log.allure("Input email success");
    };
    public void inputPassWord(String value){
        sendKeyToElement(driver, LoginPageUI.TXT_PASSWORD,value);
        Log.allure("Input password success");
    };

    public void clickBtnLogin(){
        clickElement(driver, LoginPageUI.BTN_LOGIN);
        Log.allure("Login success");
    };
}
