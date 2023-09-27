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

import java.io.IOException;

import static com.vmo.nopcommerce.utils.ExcelUtil.excelWSheet;


@Epic("Nopcommerce")
@Feature("LoginPageObject")
@Story("LoginSuccessfully")

public class LoginSuccessfully extends BaseTest {
    WebDriver driver;
    private LoginPageObject login;
    ExcelUtil excelUtil = new ExcelUtil();


    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("CHROME") String browser) throws IOException {
        driver = getDriverBrowser(browser);
        login = PageGenerator.getLoginObject(driver);
        excelUtil.setExcelFileSheet("data");
    }
    @Test()
    public void Login_01_Loginsuccessfully () throws Exception {

        int rowCount = excelWSheet.getLastRowNum();
        System.out.println(rowCount);

        login.gotoURL("https://www.saucedemo.com/");
        login.verifyTitle("Swag Labs");
        for (int i=1; i<=rowCount; i++){
                login.inputUserName(excelUtil.getCellData("Username",i));
                login.inputPassWord(excelUtil.getCellData("Password",i));
                Thread.sleep(1000);
                login.clickBtnLogin();

            }
        }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
