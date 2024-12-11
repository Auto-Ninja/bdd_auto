package com.bdd.pom.authentication;

import org.openqa.selenium.By;

public class ProductPageElements {
    public static By pageheader = By.xpath("//*[@id=\"header_container\"]/div[2]/span");

    public static By getProductByXPath(String productName) {
        //String xpath = String.format("//*[@class=\"inventory_list\"]/div/div[2]/div/a/div[text()='%s']", productName);
        String xpath = String.format("//*[@class=\"inventory_list\"]/div/div[2]/div/a/div[text()='%s']", productName);
        return By.xpath(xpath);
    }

    public static By getAddtoCartProductButtonByXPath(String productName) {
        String xpath = String.format("//*[@class=\"inventory_list\"]/div/div[2]/div/a/div[text()='%s']/../../../div[2]/button", productName);
        return By.xpath(xpath);
    }

    public static By cartButton = By.xpath("//*[@id=\"shopping_cart_container\"]/a");

}
