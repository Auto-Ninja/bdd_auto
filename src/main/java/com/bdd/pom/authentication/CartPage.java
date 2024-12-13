package com.bdd.pom.authentication;

import com.bdd.base.PomBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends PomBase {

    public CartPage(WebDriver webDriver){
        super(webDriver);
    }
    public String searchItemInCart(String productName) {
        //return this.driver.findElement(CartpageElements.getProductByXPath(productName)).getText();
        return this.getText(CartpageElements.getProductByXPath(productName));
    }

    public void removeItemInCart(String productName){
        //this.driver.findElement(CartpageElements.getRemoveButtonByXPath(productName)).click();
        this.click(CartpageElements.getRemoveButtonByXPath(productName));
    }

    public String isCartEmpty(){
       //return this.driver.findElement(CartpageElements.noIteminCart).getText();
        return this.getText(CartpageElements.noIteminCart);
    }

    public void CheckOut(){

        click(CartpageElements.checkoutButton);
        // waiting up to 10 seconds until the "foo-button" HTML element is loaded into the DOM
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.presenceOfElementLocated(CartpageElements.checkoutButton));
//
//        // retrieving "foo-button" HTML element
//        WebElement fooButton = driver.findElement(CartpageElements.checkoutButton);
//        click(CartpageElements.checkoutButton);
    }
}
