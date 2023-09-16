package com.vmo.nopcommerce.features.newpage;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.helper.Log;
import com.vmo.nopcommerce.pageobject.HomePageObject;
import com.vmo.nopcommerce.pageobject.NewPageObject;
import com.vmo.nopcommerce.pageobject.PageGenerator;
import com.vmo.nopcommerce.utils.NewPageData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddCommentSuccess extends BaseTest {
    WebDriver driver;
    private NewPageObject newpage;

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser){
        driver = getDriverBrowser(browser);
        newpage = PageGenerator.getNewPageObject(driver);
        Log.info("Open driver success");
    }
    @Test
    public void TC05_AddComment(){
        newpage.gotoURL("https://demo.nopcommerce.com/");
        newpage.verifyTitle("nopCommerce demo store");
        Log.info("Open correct page");
        newpage.clickDetail();
        Log.info("Displayed screen detail");
        newpage.addComment(NewPageData.TITLE, NewPageData.COMMENT);
        Log.info("Add comment success");
        newpage.verifyText();
        Log.info("Displayed correct text after add cmt");
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        cleanBrowserAndDriver();
        Log.info("Close dirver success");
    }
}
