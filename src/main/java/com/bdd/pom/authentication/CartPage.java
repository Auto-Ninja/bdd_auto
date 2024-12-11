package com.bdd.pom.authentication;

import com.bdd.base.PomBase;
import org.openqa.selenium.WebDriver;

public class CartPage extends PomBase {

    public CartPage(WebDriver webDriver){
        super(webDriver);
    }
    public String searchItemInCart(String productName) {
        return this.driver.findElement(CartpageElements.getProductByXPath(productName)).getText();
    }

    public void removeItemInCart(String productName){
        this.driver.findElement(CartpageElements.getRemoveButtonByXPath(productName)).click();
    }

    public String isCartEmpty(){
       return this.driver.findElement(CartpageElements.noIteminCart).getText();
    }


}
