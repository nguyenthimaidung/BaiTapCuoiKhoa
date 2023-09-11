package com.vmo.nopcommerce.FactoryEnviroment;

import com.vmo.nopcommerce.factoryBrowser.BrowserNotSupportedException;
import com.vmo.nopcommerce.factoryBrowser.ChromeDriverManager;
import com.vmo.nopcommerce.factoryBrowser.ChromeHeadlessDriverManager;
import com.vmo.nopcommerce.factoryBrowser.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;

public class LocalFactory {
    WebDriver driver;
    public WebDriver createDrive(String browser){
        browser = browser.toUpperCase();
        switch (browser){
            case "CHROME":
                driver = new ChromeDriverManager().getBrowserDriver();
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
