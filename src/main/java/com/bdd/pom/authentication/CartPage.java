package com.bdd.pom.authentication;

import com.bdd.base.PageObjectModelBase;
import com.bdd.pom.authentication.pageelements.CartpageElements;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class CartPage extends PageObjectModelBase {

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

        boolean isVisbible = this.isDisplayed(CartpageElements.noIteminCart);
        if(!isVisbible)
        {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
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
