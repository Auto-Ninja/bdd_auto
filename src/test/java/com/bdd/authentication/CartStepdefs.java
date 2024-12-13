package com.bdd.authentication;

import com.bdd.pom.authentication.CartPage;
import com.bdd.pom.authentication.ProductPage;
import com.bdd.utility.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.Reporter;

public class CartStepdefs {

    ProductPage productPage = new ProductPage(TestContext.getWebDriver());
    CartPage cartPage;
    @When("I add {string} to the cart")

    public void iAddToTheCart(String productName) {
        productPage.addtoCart(productName);
    }

    @Then("I see {string} in the cart")
    public void iShouldSeeInTheCart(String productName) {
        productPage.navigatetoCart();
        cartPage = new CartPage(productPage.driver);
        String cartproduct = cartPage.searchItemInCart(productName);
        Assert.assertEquals(cartproduct,productName);
    }

    @When("I remove {string} from the cart")
    public void iRemoveFromTheCart(String product) {
        cartPage.removeItemInCart(product);
    }

    @Then("I should not see {string} in the cart")
    public void iShouldNotSeeInTheCart(String product) {
        String cartproduct = cartPage.isCartEmpty();
        Assert.assertTrue(cartproduct.isEmpty(), String.format("'%s' is removed from the cart", product));
    }
}
