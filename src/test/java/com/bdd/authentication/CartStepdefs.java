package com.bdd.authentication;

import com.bdd.pom.authentication.ProductPage;
import com.bdd.utility.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Reporter;

public class CartStepdefs {

    ProductPage productPage = new ProductPage(TestContext.getWebDriver());
    @When("I add {string} to the cart")

    public void iAddToTheCart(String productName) {
        productPage.addtoCart(productName);
    }

    @Then("I should see {string} in the cart")
    public void iShouldSeeInTheCart(String productName) {
        productPage.navigatetoCart();
    }
}
