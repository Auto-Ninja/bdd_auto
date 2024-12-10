package com.bdd.pom.authentication;

import com.bdd.base.PomBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.Reporter;

public class ProductPage extends PomBase {
    public ProductPage(WebDriver webDriver){
        super(webDriver);
    }


    public String GetPageHeader() {
        return getText(ProductPageElements.pageheader);
    }

    public String searchItem(String product){
        Reporter.log("Searching for a product "+product);
        String actual = this.driver.findElement(ProductPageElements.getProductXPath(product)).getText();
        return actual;
    }

    public void addtoCart(String productName) {
        Reporter.log("Adding "+productName+" to the cart");
        this.driver.findElement(ProductPageElements.getProductButtonXPath(productName)).click();
    }

    public void navigatetoCart(){
        Reporter.log("Navigate to the cart details");
        this.driver.findElement(ProductPageElements.cart).click();
    }
}
