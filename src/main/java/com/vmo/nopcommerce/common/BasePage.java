package com.vmo.nopcommerce.common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private  static  int LONG_TIMEOUT = 30;

    protected void gotoURL(WebDriver driver, String URL){
        driver.get(URL);
    }
      protected WebElement getlocator(WebDriver driver, String locator){
         return driver.findElement(By.xpath(locator));
     }
    protected WebDriverWait getWait(WebDriver driver, int timeout){
        return new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }
    protected boolean elementIsVisible( WebDriver driver, String locator){
         return this.getlocator(driver,locator).isDisplayed();
    }
    protected boolean waitForElementIsEnabled( WebDriver driver, String locator){
        return this.getlocator(driver,locator).isEnabled();
    }
    protected void clearData( WebDriver driver, String locator){
         this.getlocator(driver,locator).clear();
    }
     protected void  clickElement( WebDriver driver, String locator){
          this.getlocator(driver,locator).click();
     }
     protected void scrollToElement(JavascriptExecutor js, String locator){
        js.executeScript("arguments[0].scrollIntoView(true);", locator);
     }
     protected void inputText(WebDriver driver, String locator, String text){
          this.clearData(driver,locator);
          this.getlocator(driver,locator).sendKeys(text);
     }
    protected void getText( WebDriver driver, String locator){
        this.getlocator(driver,locator).getText();
    }


}
