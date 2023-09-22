package com.vmo.nopcommerce.pageobject;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.helper.Log;
import com.vmo.nopcommerce.interfaces.RegisterUI;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class RegisterPageObject extends BasePage {

    private WebDriver driver;

    public RegisterPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void gotoURL(String value){
        gotoURL(driver,value);
    }
    public void clickOpenScreenRegister(){
        clickElement(driver, RegisterUI.OPEN_REGISTER);
        Log.allure("Open screen register success");
    };
    public void inputFirstName(String value){
        sendKeyToElement(driver, RegisterUI.TXT_FIRSTNAME,value);
        Log.allure("Input firstname success");
    };
    public void inputLastName(String value){
        sendKeyToElement(driver, RegisterUI.TXT_LASTNAME,value);
        Log.allure("Input lastname success");
    };
    public void inputEmail(String value){
        sendKeyToElement(driver, RegisterUI.TXT_EMAIL,value);
        Log.allure("Input email success");
    };
    public void inputPassWord(String value){
        sendKeyToElement(driver, RegisterUI.TXT_PASSWORD,value);
        Log.allure("Input password success");
    };
    public void inputConfirmPassWord(String value){
        sendKeyToElement(driver, RegisterUI.TXT_CF_PASSWORD,value);
        Log.allure("Input confirm password success");
    };
    public void clickBtnRegister(){
        clickElement(driver, RegisterUI.BTN_REGISTER);
        Log.allure("Register success");
    };
    public void verifyRegisterPage(){
        Assert.assertTrue(elementIsVisible(driver,RegisterUI.TEXT_REGISTER));
        Log.allure("Open correct screen Register");
    }
    public void verifyTitle(String value){
        Assert.assertEquals(driver.getTitle(),value);
        Log.allure("Open correct page");
    }
    public void verifyMessageAfterRegister(){
        Assert.assertTrue(elementIsVisible(driver,RegisterUI.verifyMessage));
        Log.allure("Displayed correct message after register");
    }

}
