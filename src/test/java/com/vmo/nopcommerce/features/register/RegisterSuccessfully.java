package com.vmo.nopcommerce.features.register;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.helper.Log;
import com.vmo.nopcommerce.interfaces.RegisterUI;
import com.vmo.nopcommerce.pageobject.LoginPageObject;
import com.vmo.nopcommerce.pageobject.PageGenerator;
import com.vmo.nopcommerce.pageobject.RegisterPageObject;
import com.vmo.nopcommerce.utils.RegisterData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RegisterSuccessfully extends BaseTest {

    WebDriver driver;
    private RegisterPageObject register;

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser){
        driver = getDriverBrowser(browser);
        register = PageGenerator.getRegisterPageObject(driver);
        Log.info("Open driver success");
    }

    @Test
    public void TC01_User_registration(){
        register.gotoURL("https://demo.nopcommerce.com/");
        register.verifyTitle("nopCommerce demo store");
        Log.info("Open correct page");
        register.clickOpenScreenRegister();
        Log.info("Open screen register success");
        register.verifyRegisterPage();
        Log.info("Open correct screen Register");
        register.inputFirstName(RegisterData.FIRSTNAME);
        Log.info("Input firstname success");
        register.inputLastName(RegisterData.LASTNAME);
        Log.info("Input lastname success");
        register.inputEmail(RegisterData.EMAIL);
        Log.info("Input email success");
        register.inputPassWord(RegisterData.PASSWORD);
        Log.info("Input password success");
        register.inputConfirmPassWord(RegisterData.CF_PASSWORD);
        Log.info("Input confirm password success");
        register.clickBtnRegister();
        Log.info("Register success");
        register.verifyMessageAffterRegister();
        Log.info("Displayed correct message after register");

    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        cleanBrowserAndDriver();
        Log.info("Close dirver success");
    }

}
