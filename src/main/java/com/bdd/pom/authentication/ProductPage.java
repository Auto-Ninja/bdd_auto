package com.bdd.pom.authentication;

import com.bdd.base.PageObjectModelBase;
import com.bdd.pom.authentication.pageelements.ProductPageElements;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class ProductPage extends PageObjectModelBase {
    public ProductPage(WebDriver webDriver){
        super(webDriver);
    }


    public String GetPageHeader() {
        return getText(ProductPageElements.pageheader);
    }

    public String searchItem(String product){
        Reporter.log("Searching for a product "+product);
        String actual = this.driver.findElement(ProductPageElements.getProductByXPath(product)).getText();
        return actual;
    }

    public void addtoCart(String productName) {
        Reporter.log("Adding "+productName+" to the cart");
        this.driver.findElement(ProductPageElements.getAddtoCartProductButtonByXPath(productName)).click();
    }

    public void navigatetoCart(){
        Reporter.log("Navigate to the cart details");
        this.driver.findElement(ProductPageElements.cartButton).click();
    }
}
