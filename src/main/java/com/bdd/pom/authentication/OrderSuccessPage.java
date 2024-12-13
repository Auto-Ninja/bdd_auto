package com.bdd.pom.authentication;

import com.bdd.base.PageObjectModelBase;
import com.bdd.pom.authentication.pageelements.OrderSuccessPageElements;
import org.openqa.selenium.WebDriver;

public class OrderSuccessPage extends PageObjectModelBase {

    public OrderSuccessPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String OrderConfirmed(){
        return this.getText(OrderSuccessPageElements.ordersuccessmsg);
    }
}
