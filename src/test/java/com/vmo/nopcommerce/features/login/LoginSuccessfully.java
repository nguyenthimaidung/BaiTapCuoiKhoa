package com.vmo.nopcommerce.features.login;

import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.pageobject.LoginPageObject;
import com.vmo.nopcommerce.pageobject.PageGenerator;
import com.vmo.nopcommerce.utils.ExcelUtil;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;



@Epic("Nopcommerce")
@Feature("LoginPageObject")
@Story("LoginSuccessfully")

public class LoginSuccessfully extends BaseTest {
    WebDriver driver;
    private LoginPageObject login;
    ExcelUtil excelUtil = new ExcelUtil();

    @DataProvider(name = "dataLogin")
    public Object[][] dataTest() {
        return excelUtil.data();
    }

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("CHROME") String browser){
        driver = getDriverBrowser(browser);
        login = PageGenerator.getLoginObject(driver);
        excelUtil.setExcelFileSheet("data");
    }



    @Test(dataProvider ="dataLogin")
    public void Login_01_Loginsuccessfully (String userName, String passWord) {
        login.gotoURL("https://www.saucedemo.com/");
        login.verifyTitle("Swag Labs");
        login.inputUserName(userName);
        login.inputPassWord(passWord);
        login.clickBtnLogin();



    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
