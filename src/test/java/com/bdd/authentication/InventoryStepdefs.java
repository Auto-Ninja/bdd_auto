package com.bdd.authentication;

import com.bdd.pom.authentication.LoginPage;
import com.bdd.pom.authentication.ProductPage;
import com.bdd.utility.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.time.Duration;

public class InventoryStepdefs {

    LoginPage loginPage;
    ProductPage productPage;
    String actualproduct;
    String expectedproduct;
    @Given("User has logged in the page")
    public void userHasLoggedInThePage() {
        loginPage = new LoginPage(TestContext.getWebDriver());
        loginPage.SetUsername("standard_user");
        loginPage.SetPassword("secret_sauce");
        loginPage.Submit();
        productPage = new ProductPage(loginPage.driver);

        try {
            Thread.sleep(Duration.ofSeconds(5).toMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
            // handle the exception...
            // For example consider calling Thread.currentThread().interrupt(); here.
        }
        //Assert.assertEquals(productPage.GetPageHeader().toUpperCase(), pagetitle.toUpperCase());
    }

    @When("I am on Product page")
    public void IamOnProductPage() {
        Assert.assertEquals(productPage.GetPageHeader().toUpperCase(), "PRODUCTS".toUpperCase());
    }

    @And("Search for an item with title {string}")
    public void searchForAnItemWithTitle(String productname) {
        this.actualproduct = this.productPage.searchItem(productname);
        this.expectedproduct = productname;
    }


    @Then("User should able to find the product")
    public void userShouldAbleToFindTheProduct() {
        Assert.assertEquals(actualproduct,expectedproduct);
    }
}
