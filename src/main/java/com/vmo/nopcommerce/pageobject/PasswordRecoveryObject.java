package com.vmo.nopcommerce.pageobject;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.helper.Log;
import com.vmo.nopcommerce.interfaces.PasswordRecoveryUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PasswordRecoveryObject extends BasePage {
    WebDriver driver;

    public  PasswordRecoveryObject(WebDriver driver){
        this.driver = driver;
    }
    public void gotoURL(String value){
        gotoURL(driver,value);
    }
    public void verifyTitle(String value){
        Assert.assertEquals(driver.getTitle(),value);
        Log.allure("Open correct page");
    }
    public void clickLogin(){
        clickElement(driver, PasswordRecoveryUI.LOGIN);
        Log.allure("Open screen login");
    }
    public void clickForgotPassword(){
        clickElement(driver,PasswordRecoveryUI.FORGOT_PASSWORD);
        Log.allure("Open screen forgot password");
    }
    public void inputEmail(String value){
        sendKeyToElement(driver,PasswordRecoveryUI.INPUT_EMAIL,value);
        Log.allure("Input email successfully");
    }
    public void clickBtnRecover(){
        clickElement(driver,PasswordRecoveryUI.BTN_RECOVER);
        Log.allure("Forgot password success");
    }
    public void verifyMessage(){
        elementIsVisible(driver,PasswordRecoveryUI.MESSAGE);
        Log.allure("Displayed correct message after forgot password ");
    }

}
