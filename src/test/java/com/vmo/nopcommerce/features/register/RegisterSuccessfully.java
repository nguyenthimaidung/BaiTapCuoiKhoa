package com.vmo.nopcommerce.features.register;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.common.BaseTest;
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
    }

    @Test
    public void TC01_User_registration(){
        register.gotoURL("https://demo.nopcommerce.com/");
        register.verifyTitle("nopCommerce demo store");
        register.clickOpenScreenRegister();
        register.verifyRegisterPage();
        register.inputFirstName(RegisterData.FIRSTNAME);
        register.inputLastName(RegisterData.LASTNAME);
        register.inputEmail(RegisterData.EMAIL);
        register.inputPassWord(RegisterData.PASSWORD);
        register.inputConfirmPassWord(RegisterData.CF_PASSWORD);
        register.clickBtnRegister();
        register.verifyMessageAffterRegister();




    }



    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        cleanBrowserAndDriver();
    }

}
