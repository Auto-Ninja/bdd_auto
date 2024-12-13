package com.bdd.pom.authentication;

import com.bdd.base.PomBase;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage extends PomBase {
    public OrderConfirmationPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String checkPaymentinfo() {
         return this.getText(OrderConfirmationPageElements.paymentinfo);
    }

    public String checkShippinginfo() {
        return this.getText(OrderConfirmationPageElements.shippinginfo);
    }

    public String checkTotal() {
        return this.getText(OrderConfirmationPageElements.total);
    }

    public void finish(){ click(OrderConfirmationPageElements.finishButton);    }
}
