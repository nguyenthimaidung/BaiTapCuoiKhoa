package com.vmo.nopcommerce.factoryBrowser;

import com.vmo.nopcommerce.common.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeGirdDriverManager implements BrowserFactory{
    @Override
    public WebDriver getBrowserDriver() {
        ChromeOptions chromeOption = new ChromeOptions();

        try {
            return new RemoteWebDriver(new URL(GlobalConstants.REMOTE_URL),chromeOption);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
