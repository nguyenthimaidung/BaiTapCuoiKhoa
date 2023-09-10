package com.vmo.nopcommerce.pageobject;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.interfaces.RegisterUI;
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
    };
    public void inputFirstName(String value){
        sendKeyToElement(driver, RegisterUI.TXT_FIRSTNAME,value);
    };
    public void inputLastName(String value){
        sendKeyToElement(driver, RegisterUI.TXT_LASTNAME,value);
    };
    public void inputEmail(String value){
        sendKeyToElement(driver, RegisterUI.TXT_EMAIL,value);
    };
    public void inputPassWord(String value){
        sendKeyToElement(driver, RegisterUI.TXT_PASSWORD,value);
    };
    public void inputConfirmPassWord(String value){
        sendKeyToElement(driver, RegisterUI.TXT_CF_PASSWORD,value);
    };
    public void clickBtnRegister(){
        clickElement(driver, RegisterUI.BTN_REGISTER);
    };
    public void verifyRegisterPage(){
        Assert.assertTrue(elementIsVisible(driver,RegisterUI.TEXT_REGISTER));
    }
    public void verifyTitle(String value){
        Assert.assertEquals(driver.getTitle(),value);
    }
    public void verifyMessageAffterRegister(){
        Assert.assertTrue(elementIsVisible(driver,RegisterUI.verifyMessage));
    }

}
