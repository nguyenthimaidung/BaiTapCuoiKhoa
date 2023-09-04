package com.vmo.nopcommerce.pageobject;

import com.vmo.nopcommerce.common.BasePage;
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
    }
    public void clickLogin(){
        clickElement(driver, PasswordRecoveryUI.LOGIN);
    }
    public void clickForgotPassword(){
        clickElement(driver,PasswordRecoveryUI.FORGOT_PASSWORD);
    }
    public void inputEmail(String value){
        inputText(driver,PasswordRecoveryUI.INPUT_EMAIL,value);
    }
    public void clickBtnRecover(){
        clickElement(driver,PasswordRecoveryUI.BTN_RECOVER);
    }
    public void verifyMessage(){
        elementIsVisible(driver,PasswordRecoveryUI.MESSAGE);
    }

}
