package com.vmo.nopcommerce.pageobject;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.interfaces.HomePageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class HomePageObject extends BasePage {
    WebDriver driver;
    String value = "Nokia";

    public  HomePageObject(WebDriver driver){
        this.driver = driver;
    }
    public void gotoURL(String value){
        gotoURL(driver,value);
    }
    public void verifyTitle(String value){
        Assert.assertEquals(getTitle(driver),value);
    }

    public void inputTextBoxSearch (){
        sendKeyToElement(driver, HomePageUI.TXT_SEARCH,value);
    }
    public void clickBtnSearch(){
        clickElement(driver,HomePageUI.BTN_SEARCH);
    }
    public void verifySerachProductResult(){
        if(elementIsVisible(driver,HomePageUI.ITEM_BOX)){
            getTextElement(driver,HomePageUI.PRODUCT_NAME).contains(value);
        }
        else {
            Assert.assertTrue(elementIsVisible(driver,HomePageUI.NO_RESULT));

        }
    }
    public void clickComputer_Software(){
        clickElement(driver,HomePageUI.CATEGORY_COMPUTER);
        clickElement(driver,HomePageUI.COMPUTER_SOFTWARE);
        Assert.assertTrue(elementIsVisible(driver,HomePageUI.TEXT_SOFTWARE));
    }
    public void optionSortBy(String value){
        selectOption(driver,HomePageUI.DOPDOWN_SORT,value);
        String [] array = {"Windows 8 Pro", "Sound Forge Pro 11 (recurring)","Adobe Photoshop CS4"};
        List<WebElement> verifyTitle = driver.findElements(By.xpath(HomePageUI.PRODUCT_TITLE));
        for (WebElement webElement : verifyTitle) {
            webElement.getText();
            String [] array2 = {webElement.getText()};
            Arrays.equals(array2,array);

        }
    }

    public void selectCurrency(String text){
        selectItemInDefaultDropdownByText(driver,HomePageUI.DOPDOWN_CURRENCY,text);
        String [] array = {"€1032.00", "€1548.00","€210.70","€21.50"};
        List<WebElement> verifyTitle = driver.findElements(By.xpath(HomePageUI.LIST_PRICE));
        for (WebElement webElement : verifyTitle) {
            webElement.getText();
            String [] array2 = {webElement.getText()};
            Arrays.equals(array2,array);

        }
    }
    public void clickFacebook(){
        clickElement(driver,HomePageUI.ITEM_FACEBOOK);
        String titleFacebook ="NopCommerce | Facebook";
        switchToWindowByTitle(driver,titleFacebook);
        Assert.assertEquals(getTitle(driver),titleFacebook);


    }



}
