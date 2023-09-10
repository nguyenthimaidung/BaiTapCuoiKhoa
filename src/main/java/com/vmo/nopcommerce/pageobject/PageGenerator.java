package com.vmo.nopcommerce.pageobject;

import org.openqa.selenium.WebDriver;

public class PageGenerator {

    public static HomePageObject getHomePageObject(WebDriver driver){
        return new HomePageObject(driver);
    }
    public static LoginPageObject getLoginPageObject(WebDriver driver){
        return new LoginPageObject(driver);
    }
    public static PasswordRecoveryObject getPasswordRecoveryObject(WebDriver driver){
        return new PasswordRecoveryObject(driver);
    }
    public static RegisterPageObject getRegisterPageObject(WebDriver driver){
        return new RegisterPageObject(driver);
    }

    public static NewPageObject getNewPageObject(WebDriver driver){
        return new NewPageObject(driver);
    }
}
