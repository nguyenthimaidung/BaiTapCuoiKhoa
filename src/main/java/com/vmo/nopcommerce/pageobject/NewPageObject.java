package com.vmo.nopcommerce.pageobject;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.interfaces.NewPageUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NewPageObject extends BasePage {
    WebDriver driver;

    public  NewPageObject(WebDriver driver){
        this.driver = driver;
    }
    public void gotoURL(String value){
        gotoURL(driver,value);
    }
    public void verifyTitle(String value){
        Assert.assertEquals(getTitle(driver),value);
    }
    public void clickDetail(){
        String title_New = getTextElement(driver,NewPageUI.NEW_TITLE);
        clickElement(driver, NewPageUI.BTN_DETAIL);
        String verifyArticleChosen = getTextElement(driver,NewPageUI.TITLE_DETAIL);
        Assert.assertEquals(title_New,verifyArticleChosen);
    }

    public void addComment(String title, String comment){
        sendKeyToElement(driver,NewPageUI.TXT_TITLE,title);
        sendKeyToElement(driver,NewPageUI.TXT_COMMENT,comment);
        clickElement(driver,NewPageUI.BTN_ADD_COMMENT);
    }

    public void verifyText(){
        elementIsVisible(driver,NewPageUI.TEXT_CONFIRM);
    }



}
