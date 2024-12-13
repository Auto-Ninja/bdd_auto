package com.bdd.pom.authentication;

import com.bdd.base.PomBase;
import org.openqa.selenium.WebDriver;

public class OrderSuccessPage extends PomBase {

    public OrderSuccessPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String OrderConfirmed(){
        return this.getText(OrderSuccessPageElements.ordersuccessmsg);
    }
}
