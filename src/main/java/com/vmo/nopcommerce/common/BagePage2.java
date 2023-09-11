package com.vmo.nopcommerce.common;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BagePage2 {
        private long shortTimeOut = GlobalConstants.SHORT_TIMEOUT;
        private long longTimeOut = GlobalConstants.LONG_TIMEOUT;
        private Alert alert;
        private WebDriverWait explicit;
        private Select select;
        private JavascriptExecutor jsExecutor;
        private Actions action;

        public static BasePage getBasePage() {
            return new BasePage();
        }

        public void openUrl(WebDriver driver, String url) {
            driver.get(url);
        }

        public Set<Cookie> getAllCookies(WebDriver driver) {
            return driver.manage().getCookies();
        }

        public void setAllCookies(WebDriver driver, Set<Cookie> cookies) {
            for (Cookie cookie : cookies) {
                driver.manage().addCookie(cookie);
            }
        }

        public String getTitle(WebDriver driver) {
            return driver.getTitle();
        }

        public String getCurrentUrl(WebDriver driver) {
            return driver.getCurrentUrl();
        }

        public String getPageSource(WebDriver driver) {
            return driver.getPageSource();
        }

        public void backToPage(WebDriver driver) {
            driver.navigate().back();
        }

        public void refreshCurrentPage(WebDriver driver) {
            driver.navigate().refresh();
        }

        public void forwardToPage(WebDriver driver) {
            driver.navigate().forward();
        }

        public void overrideImplicitTimeOut(WebDriver driver, long timeout) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
        }

        public Alert waitAlertPresence(WebDriver driver) {
            explicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
            return alert = explicit.until(ExpectedConditions.alertIsPresent());
        }

        public boolean isElementUndisplayed(WebDriver driver, String locator) {
            overrideImplicitTimeOut(driver, shortTimeOut);
            List<WebElement> listElement = getListWebElements(driver, locator);
            overrideImplicitTimeOut(driver, longTimeOut);
            if (listElement.size() == 0) {
                System.out.println("Element not in DOM");
                return true;
            } else if (!listElement.isEmpty() && !listElement.get(0).isDisplayed()) {
                System.out.println("Element in DOM but undisplay");
                return true;
            } else {
                System.out.println("Element in DOM and display");
                return false;
            }
        }

        public boolean isElementUndisplayed(WebDriver driver, String locator, String... params) {
            locator = getDynamiLocator(locator, params);
            overrideImplicitTimeOut(driver, shortTimeOut);
            List<WebElement> listElement = getListWebElements(driver, locator);
            overrideImplicitTimeOut(driver, longTimeOut);
            if (listElement.size() == 0) {
                System.out.println("Element not in DOM");
                return true;
            } else if (listElement.size() > 0 && !listElement.get(0).isDisplayed()) {
                System.out.println("Element in DOM but undisplay");
                return true;
            } else {
                System.out.println("Element in DOM and display");
                return false;
            }
        }

        public void acceptAlert(WebDriver driver) {
            alert = waitAlertPresence(driver);
            alert.accept();
        }

        public void dismissAlert(WebDriver driver) {
            alert = waitAlertPresence(driver);
            alert.dismiss();
        }

        public String getTextAlert(WebDriver driver) {
            alert = waitAlertPresence(driver);
            return alert.getText();
        }

        public void sendKeysToAlert(WebDriver driver, String value) {
            alert = waitAlertPresence(driver);
            alert.sendKeys(value);
        }

        public void switchWindowByID(WebDriver driver, String parentID) {
            Set<String> allWindows = driver.getWindowHandles();
            for (String id : allWindows) {
                if (!id.equals(parentID)) {
                    driver.switchTo().window(id);
                    break;
                }
            }
        }

        public void switchToWindowByTitle(WebDriver driver, String title) {
            Set<String> allWindows = driver.getWindowHandles();
            for (String id : allWindows) {
                driver.switchTo().window(id);
                if (driver.getTitle().equals(title)) {
                    break;
                }
            }
        }

        public void closeTabWithoutParent(WebDriver driver, String parentID) {
            Set<String> allWindows = driver.getWindowHandles();
            for (String id : allWindows) {
                if (!id.equals(parentID)) {
                    driver.switchTo().window(id);
                    driver.close();
                }
            }
            driver.switchTo().window(parentID);

        }

        public void sleepInSecond(long timeout) {
            try {
                Thread.sleep(timeout * 1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public By getXPathLocator(String locator) {
            return By.xpath(locator);
        }

        public WebElement getWebElement(WebDriver driver, String locator) {
            return driver.findElement(getXPathLocator(locator));
        }

        public WebElement getWebElement(WebDriver driver, String locator, String... params) {
            locator = getDynamiLocator(locator, params);
            return driver.findElement(getXPathLocator(locator));
        }

        public List<WebElement> getListWebElements(WebDriver driver, String locator) {
            return driver.findElements(getXPathLocator(locator));
        }

        public List<WebElement> getListWebElements(WebDriver driver, String locator, String... params) {
            return driver.findElements(getXPathLocator(getDynamiLocator(locator, params)));
        }

        public int getElementSize(WebDriver driver, String locator) {
            return getListWebElements(driver, locator).size();
        }

        public int getElementSize(WebDriver driver, String locator, String... params) {
            return getListWebElements(driver, locator, params).size();
        }

        public void clickToElement(WebDriver driver, String locator) {
            getWebElement(driver, locator).click();
        }

        public void sendKeyToElement(WebDriver driver, String locator, String value) {
            getWebElement(driver, locator).clear();
            getWebElement(driver, locator).sendKeys(value);
        }

        public void sendKeyToElement(WebDriver driver, String locator, String value, String... params) {
            locator = getDynamiLocator(locator, params);
            getWebElement(driver, locator).clear();
            getWebElement(driver, locator).sendKeys(value);
        }

        public void selectItemInDefaultDropdownByText(WebDriver driver, String locator, String itemText) {
            select = new Select(getWebElement(driver, locator));
            select.selectByVisibleText(itemText);
        }

        public void selectItemInDefaultDropdownByText(WebDriver driver, String locator, String itemText, String... params) {
            locator = getDynamiLocator(locator, params);
            select = new Select(getWebElement(driver, locator));
            select.selectByVisibleText(itemText);
        }

        public String getSelectedItemInDefaultDropdown(WebDriver driver, String locator) {
            select = new Select(getWebElement(driver, locator));
            return select.getFirstSelectedOption().getText();
        }

        public String getSelectedItemInDefaultDropdown(WebDriver driver, String locator, String... params) {
            locator = getDynamiLocator(locator, params);
            select = new Select(getWebElement(driver, locator));
            return select.getFirstSelectedOption().getText();
        }

        public boolean isDropdownMultiple(WebDriver driver, String locator) {
            select = new Select(getWebElement(driver, locator));
            return select.isMultiple();
        }

        public void selectItemInCustomDropdown(WebDriver driver, String xPathParent, String xPathChild, String expectedItem) {
            explicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
            jsExecutor = (JavascriptExecutor) driver;
            clickToElement(driver, xPathParent);
            sleepInSecond(1);
            List<WebElement> listItems = explicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getXPathLocator(xPathChild)));
            for (WebElement item : listItems) {
                if (item.getText().trim().equals(expectedItem)) {
                    jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                    sleepInSecond(1);

                    item.click();
                    sleepInSecond(1);
                    break;
                }

            }
        }

        public String getAttributeElement(WebDriver driver, String locator, String attributeName) {
            return getWebElement(driver, locator).getAttribute(attributeName);
        }

        public String getAttributeElement(WebDriver driver, String locator, String attributeName, String... params) {
            locator = getDynamiLocator(locator, params);
            return getWebElement(driver, locator).getAttribute(attributeName);
        }

        public String getTextElement(WebDriver driver, String locator) {
            return getWebElement(driver, locator).getText();
        }

        public String getTextElement(WebDriver driver, String locator, String... params) {
            locator = getDynamiLocator(locator, params);
            return getWebElement(driver, locator).getText();
        }

        public String convertRgbaToHex(String rgba) {
            String color = Color.fromString(rgba).asHex();
            return color;
        }

        public String getCssValueElement(WebDriver driver, String locator, String cssAttribute) {
            return getWebElement(driver, locator).getCssValue(cssAttribute);
        }

        public void checkToDefaultCheckboxOrDefaultRadio(WebDriver driver, String locator) {

            if (!isElementSelected(driver, locator)) {
                clickToElement(driver, locator);
            }
        }

        public void checkToDefaultCheckboxOrDefaultRadio(WebDriver driver, String locator, String... params) {
            if (!isElementSelected(driver, locator, params)) {
                clickToElement(driver, locator, params);
            }

        }

        public void uncheckToDefaultCheckbox(WebDriver driver, String locator) {

            if (isElementSelected(driver, locator)) {
                clickToElement(driver, locator);
            }
        }

        public boolean isElementDisplay(WebDriver driver, String locator) {
            try {
                return getWebElement(driver, locator).isDisplayed();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
        }

        public boolean isElementDisplay(WebDriver driver, String locator, String... params) {
            locator = getDynamiLocator(locator, params);
            return getWebElement(driver, locator).isDisplayed();
        }

        public boolean isElementSelected(WebDriver driver, String locator) {
            return getWebElement(driver, locator).isSelected();
        }

        public boolean isElementSelected(WebDriver driver, String locator, String... params) {
            locator = getDynamiLocator(locator, params);
            return getWebElement(driver, locator).isSelected();
        }

        public boolean isElementEnabled(WebDriver driver, String locator) {
            return getWebElement(driver, locator).isEnabled();
        }

        public void switchToFrameOrIFrameByElement(WebDriver driver, String locator) {
            driver.switchTo().frame(getWebElement(driver, locator));
        }

        public void switchToDefaultContent(WebDriver driver, String locator) {
            driver.switchTo().defaultContent();
        }

        public void doubleClickToElement(WebDriver driver, String locator) {
            action = new Actions(driver);
            action.doubleClick(getWebElement(driver, locator)).perform();
        }

        public void hoverMouseToElement(WebDriver driver, String locator) {
            action = new Actions(driver);
            action.moveToElement(getWebElement(driver, locator)).perform();
        }

        public void hoverMouseToElement(WebDriver driver, String locator, String... params) {
            locator = getDynamiLocator(locator, params);
            action = new Actions(driver);
            action.moveToElement(getWebElement(driver, locator)).perform();
        }

        public void rightCLickToElement(WebDriver driver, String locator) {
            action = new Actions(driver);
            action.contextClick(getWebElement(driver, locator)).perform();
        }

        public void dragAndDrop(WebDriver driver, String locatorSource, String locatorTarget) {
            action = new Actions(driver);
            WebElement source = getWebElement(driver, locatorSource);
            WebElement target = getWebElement(driver, locatorTarget);
            action.dragAndDrop(source, target).perform();
        }

        public void pressKeyboardToElemntByActions(WebDriver driver, String locator, Keys key) {
            action = new Actions(driver);
            action.sendKeys(getWebElement(driver, locator), key).perform();
        }

        public void pressKeyboardToElemnt(WebDriver driver, String locator, Keys key) {
            getWebElement(driver, locator).sendKeys(key);
        }

        public void pressKeyboardToElemnt(WebDriver driver, String locator, Keys key, String... params) {
            locator = getDynamiLocator(locator, params);
            getWebElement(driver, locator).sendKeys(key);
        }

        public Object executeForBrowser(WebDriver driver, String javaScript) {
            jsExecutor = (JavascriptExecutor) driver;
            return jsExecutor.executeScript(javaScript);
        }

        public String getInnerText(WebDriver driver) {
            jsExecutor = (JavascriptExecutor) driver;
            return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
        }

        public boolean isExpectedTextInInnerText(WebDriver driver, String textExpected) {
            jsExecutor = (JavascriptExecutor) driver;
            String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
            return textActual.equals(textExpected);
        }

        public void scrollToBottomPage(WebDriver driver) {
            jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        }

        public void navigateToUrlByJS(WebDriver driver, String url) {
            jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("window.location = '" + url + "'");
        }

        public void highlightElement(WebDriver driver, String locator) {
            jsExecutor = (JavascriptExecutor) driver;
            WebElement element = getWebElement(driver, locator);
            String originalStyle = element.getAttribute("style");

            jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
            sleepInSecond(1);
            jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
        }

        public void clickToElementByJS(WebDriver driver, String locator) {
            jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locator));
        }

        public void clickToElementByJS(WebDriver driver, String locator, String... params) {
            locator = getDynamiLocator(locator, params);
            jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locator));
        }

        public void scrollToElement(WebDriver driver, String locator) {
            jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
        }

        public void scrollToElement(WebDriver driver, String locator, String... params) {
            jsExecutor = (JavascriptExecutor) driver;
            locator = getDynamiLocator(locator, params);
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
        }


        public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
            jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, locator));
        }

        public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
            jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locator));
        }

        public String getTextElementByJS(WebDriver driver, String locator, String... params) {
            locator = getDynamiLocator(locator, params);
            jsExecutor = (JavascriptExecutor) driver;
            //String script=" return $(document.evaluate(\"//input[@id='Address_FirstName']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue).val()";
            //String s="$(document.evaluate("//input[@id='Address_FirstName']", document, nul"l, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue).val()
            //String script="$(document.evaluate(""+locator+ ", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue).val()";
            //System.out.println(s);
            // String s="//input[@id='Address_FirstName']";
            String script = "return $(document.evaluate(" + "\"" + locator + "\"" + ", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue).val()";
//
            return (String) jsExecutor.executeScript(script);
        }

        public String getElementValidationMessage(WebDriver driver, String locator) {
            jsExecutor = (JavascriptExecutor) driver;

            return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locator));
        }

        public boolean isImageLoaded(WebDriver driver, String locator) {
            jsExecutor = (JavascriptExecutor) driver;
            return (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locator));

        }

        public boolean isJQueryLoadSuccess(WebDriver driver) {
            explicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
            jsExecutor = (JavascriptExecutor) driver;
            ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {

                @Override
                public Boolean apply(WebDriver driver) {
                    // TODO Auto-generated method stub
                    return (Boolean) jsExecutor.executeScript("return (window.jQuery!=null) && (jQuery.active===0);");

                }

            };
            return explicit.until(jQueryLoad);
        }

        public boolean isjQueryAndPageLoadSuccess(WebDriver driver) {
            explicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
            jsExecutor = (JavascriptExecutor) driver;
            ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {

                @Override
                public Boolean apply(WebDriver driver) {
                    // TODO Auto-generated method stub
                    try {
                        return ((Long) jsExecutor.executeScript("return jQuery.active;") == 0);
                    } catch (Exception e) {
                        return true;
                    }

                }

            };
            ExpectedCondition<Boolean> PageLoadSuccess = new ExpectedCondition<Boolean>() {

                @Override
                public Boolean apply(WebDriver driver) {
                    // TODO Auto-generated method stub
                    return (Boolean) jsExecutor.executeScript("return document.readyState").toString().equals("complete");
                }

            };
            return explicit.until(jQueryLoad) && explicit.until(PageLoadSuccess);
        }

        public void waitForElementVisible(WebDriver driver, String locator) {
            explicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
            explicit.until(ExpectedConditions.visibilityOfElementLocated(getXPathLocator(locator)));
        }

        public void waitForElementVisible(WebDriver driver, String locator, String... params) {
            explicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
            explicit.until(ExpectedConditions.visibilityOfElementLocated(getXPathLocator(getDynamiLocator(locator, params))));
        }

        public void waitForAllElementsVisible(WebDriver driver, String locator) {
            explicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
            explicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getXPathLocator(locator)));
        }

        public void waitForAllElementsVisible(WebDriver driver, String locator, String... params) {
            explicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
            locator = getDynamiLocator(locator, params);
            explicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getXPathLocator(locator)));
        }

        public void waitForElementInvisible(WebDriver driver, String locator) {
            explicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
            explicit.until(ExpectedConditions.invisibilityOfElementLocated(getXPathLocator(locator)));

        }

        /*
         *
         * Wait for element undisplayed in DOM or not DOM and overide time out
         */
        public void waitForElementUnDisplay(WebDriver driver, String locator, String... params) {
            locator = getDynamiLocator(locator, params);
            explicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
            overrideImplicitTimeOut(driver, shortTimeOut);
            explicit.until(ExpectedConditions.invisibilityOfElementLocated(getXPathLocator(locator)));

        }

        public void waitForElementInvisible(WebDriver driver, String locator, String... params) {
            locator = getDynamiLocator(locator, params);

            explicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
            explicit.until(ExpectedConditions.invisibilityOfElementLocated(getXPathLocator(locator)));

        }

        public void waitForElementClickable(WebDriver driver, String locator) {
            explicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
            explicit.until(ExpectedConditions.elementToBeClickable(getXPathLocator(locator)));

        }

        public void waitForElementClickable(WebDriver driver, WebElement element) {
            explicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
            explicit.until(ExpectedConditions.elementToBeClickable(element));

        }

        public void waitForAllElementsInvisible(WebDriver driver, String locator) {
            explicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
            explicit.until(ExpectedConditions.invisibilityOfAllElements(getListWebElements(driver, locator)));
        }

        public String getDynamiLocator(String locator, String... params) {
            return String.format(locator, (Object[]) params);
        }

        public void waitForElementClickable(WebDriver driver, String locator, String... params) {
            explicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
            explicit.until(ExpectedConditions.elementToBeClickable(getXPathLocator(getDynamiLocator(locator, params))));

        }

        public void clickToElement(WebDriver driver, String locator, String... params) {
            getWebElement(driver, getDynamiLocator(locator, params)).click();
        }

    }

