package com.bdd.pom.authentication;

import org.openqa.selenium.By;

public class CartpageElements {
    public static By getProductByXPath(String productName){

        String xpath  = String.format("//*[@class=\"inventory_item_name\"][text()='%s']",productName);
        return By.xpath(xpath);

    }
    public static By cartCount = By.cssSelector(".inventory_item_name");

    public static By noIteminCart = By.cssSelector(".removed_cart_item");



    public static By getRemoveButtonByXPath(String productName){

        String xpath  = String.format("//*[@class=\"inventory_item_name\"][text()='%s']/../../div[2]/button",productName);
        return By.xpath(xpath);
    }


}
