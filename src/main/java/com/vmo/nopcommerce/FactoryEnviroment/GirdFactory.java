package com.vmo.nopcommerce.FactoryEnviroment;

import com.vmo.nopcommerce.factoryBrowser.*;
import org.openqa.selenium.WebDriver;

public class GirdFactory {
    WebDriver driver;
    public WebDriver createDrive(String browser){
        browser = browser.toUpperCase();
        switch (browser){
            case "CHROME":
                driver = new ChromeGirdDriverManager().getBrowserDriver();
                break;
            case "FIREFOX":
                driver = new FirefoxDriverManager().getBrowserDriver();
                break;
            case "H-CHROME":
                driver = new ChromeHeadlessDriverManager().getBrowserDriver();
                break;
            default:
                throw new BrowserNotSupportedException(browser);
        }

        return driver;
    }
}
