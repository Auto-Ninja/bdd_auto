package com.bdd.authentication;

import com.bdd.constants.TestConstants;
import com.bdd.pom.authentication.*;
import com.bdd.utility.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class CheckoutStepdefs {

    ProductPage productPage;
    CartPage cartPage;
    CheckOutPage checkOutPage ;
    OrderConfirmationPage orderConfirmationPage;
    OrderSuccessPage orderSuccessPage;

    @And("I proceed to checkout")
    public void ProceedToCheckout() {
        productPage = new ProductPage(TestContext.getWebDriver());
        productPage.navigatetoCart();
        cartPage = new CartPage(productPage.driver);
        cartPage.CheckOut();
    }

    @And("I enter shipping details")
    public void EnterShippingDetails(DataTable dataTable) {
        List<List<String>> rows = dataTable.asLists(String.class);
        String firstname = rows.get(1).get(0).toString();
        String lastname =rows.get(1).get(1).toString();
        String zip =rows.get(1).get(2).toString();
        checkOutPage = new CheckOutPage(cartPage.driver);
        checkOutPage.SetFirstname(firstname);
        checkOutPage.SetLastname(lastname);
        checkOutPage.SetZipCode(zip);
        checkOutPage.Continue();
        orderConfirmationPage = new OrderConfirmationPage(checkOutPage.driver);
    }

    @And("I continue to payment")
    public void ContinueToPayment() {
        Assert.assertEquals(orderConfirmationPage.checkPaymentinfo(), TestConstants.DEFAULT_PAYMENT_INFO);
        Assert.assertEquals(orderConfirmationPage.checkShippinginfo(),TestConstants.DEFAULT_SHIPPING_INFO);
        String pricetext = orderConfirmationPage.checkTotal();
        String replacedString = pricetext.replace("Total: $", "");
        float total = Float.parseFloat(replacedString);
        Assert.assertTrue(total > 0, "The total price is not greater than 0: " + total);
    }

    @And("I place the order")
    public void PlaceTheOrder() {
        orderConfirmationPage.finish();
    }

    @Then("I should see a confirmation message {string}")
    public void ShouldSeeAConfirmationMessage(String OrderConfirmation) {
        OrderSuccessPage orderSuccessPage = new OrderSuccessPage(orderConfirmationPage.driver);
        Assert.assertEquals(orderSuccessPage.OrderConfirmed(), OrderConfirmation);
    }


}
