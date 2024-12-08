package com.bdd.pom.authentication;

import com.bdd.base.PomBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductPage extends PomBase {
    public ProductPage(WebDriver webDriver){
        super(webDriver);
    }


    public String GetPageHeader() {
        return getText(ProductPageElements.pageheader);
    }
}
