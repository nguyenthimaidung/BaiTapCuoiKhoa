package com.vmo.nopcommerce.common;

import com.vmo.nopcommerce.FactoryEnviroment.LocalFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest extends BasePage {
    private  WebDriver driver;
    protected  WebDriver getDriverBrowser(String browser){
        driver = new LocalFactory().createDrive(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        return driver;
    }


}
