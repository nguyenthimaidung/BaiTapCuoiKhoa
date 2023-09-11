package com.vmo.nopcommerce.pageobject;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.interfaces.HomePageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
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
        List<String> array1 = Arrays.asList(array);
        List<WebElement> verifyTitle = driver.findElements(By.xpath(HomePageUI.PRODUCT_TITLE));
        List<String> array2 = new ArrayList<>();
        for (WebElement webElement : verifyTitle) {
            array2.add(webElement.getText());
        }
        boolean result = Arrays.equals(array1.toArray(),array2.toArray());




    }

    public void selectCurrency(String text){
        selectItemInDefaultDropdownByText(driver,HomePageUI.DOPDOWN_CURRENCY,text);
        isElementSelected(driver,HomePageUI.VERIFY_CERRENCY_SELECTED);
    }
    public void verifyCurrencyDisplayed(){
        List<WebElement> verifyTitle = driver.findElements(By.xpath(HomePageUI.LIST_PRICE));
        for (WebElement webElement : verifyTitle) {
            webElement.getText();
            webElement.getText().contains("€");
        }
    }
    public void clickFacebook(){
        clickElement(driver,HomePageUI.ITEM_FACEBOOK);
    }
    public void verifyTitleFacebook(){
        String titleFacebook ="NopCommerce | Facebook";
        switchToWindowByTitle(driver,titleFacebook);
        waitForElementVisible(driver,HomePageUI.VERIFY_WAIT);
        Assert.assertEquals(getTitle(driver),titleFacebook);
    }



}
