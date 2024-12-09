package com.bdd.pom.authentication;

import org.openqa.selenium.By;

public class ProductPageElements {
    public static By pageheader = By.xpath("//*[@id=\"header_container\"]/div[2]/span");

    public static By getProductXPath(String productName) {
        //String xpath = String.format("//*[@class=\"inventory_list\"]/div/div[2]/div/a/div[text()='%s']", productName);
        String xpath = String.format("//*[@class=\"inventory_list\"]/div/div[2]/div/a/div[text()='%s']", productName);
        return By.xpath(xpath);
    }
}
