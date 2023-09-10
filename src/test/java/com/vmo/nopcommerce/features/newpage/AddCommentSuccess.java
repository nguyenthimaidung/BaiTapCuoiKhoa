package com.vmo.nopcommerce.features.newpage;

import com.vmo.nopcommerce.pageobject.HomePageObject;
import com.vmo.nopcommerce.pageobject.NewPageObject;
import com.vmo.nopcommerce.pageobject.PageGenerator;
import com.vmo.nopcommerce.utils.NewPageData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddCommentSuccess {
    WebDriver driver;
    private NewPageObject newpage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        newpage = PageGenerator.getNewPageObject(driver);
    }
    @Test
    public void TC05_AddComment(){
        newpage.gotoURL("https://demo.nopcommerce.com/");
        newpage.verifyTitle("nopCommerce demo store");
        newpage.clickDetail();
        newpage.addComment(NewPageData.TITLE, NewPageData.COMMENT);
        newpage.verifyText();
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
