package com.vmo.nopcommerce.pageobject;

import com.vmo.nopcommerce.common.BasePage;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePage {

    private WebDriver driver;

    public LoginPageObject(WebDriver driver){
        this.driver = driver;
    }

}
