package com.vmo.nopcommerce.interfaces;

public class HomePageUI {

    public static String TXT_SEARCH = "//input[@id='small-searchterms']";
    public static String BTN_SEARCH = "//button[@class ='button-1 search-box-button']";
    public static String ITEM_BOX = "//div[@class ='item-box']";
    public static String NO_RESULT = "//div[text()='No products were found that matched your criteria.']";
    public static String PRODUCT_NAME = "//h2[@class ='product-title']/a";
    public static String CATEGORY_COMPUTER = "//ul[@class='top-menu notmobile']//a[text()='Computers ']";
    public static String COMPUTER_SOFTWARE = " //a[text()=' Software ']";
    public static String TEXT_SOFTWARE = "//h1[text()='Software']";
    public static String DOPDOWN_SORT = "//select[@id = 'products-orderby']";
    public static String PRODUCT_TITLE ="//h2[@class= 'product-title']";
    public static String DOPDOWN_CURRENCY = "//select[@id ='customerCurrency']";
    public static String VERIFY_CERRENCY_SELECTED = "//option[text() = 'Euro']";
    public static String LIST_PRICE ="//span[@class ='price actual-price']";
    public static String ITEM_FACEBOOK = "//li[@class ='facebook']";
    public static String VERIFY_WAIT = "(//span[text() = 'Connect with NopCommerce on Facebook'])[1]";


}
