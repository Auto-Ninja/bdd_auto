package com.bdd.authentication;

import com.bdd.pom.authentication.LoginPage;
import com.bdd.pom.authentication.ProductPage;
import com.bdd.utility.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

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

//        try {
//            Thread.sleep(Duration.ofSeconds(5).toMillis());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//            // handle the exception...
//            // For example consider calling Thread.currentThread().interrupt(); here.
//        }
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

    Map<String, String > hashMap = new HashMap<>();
    @And("I search for the following products")
    public void SearchForTheFollowingProducts(DataTable dataTable) {
        var products = dataTable.asList();
        for (int i = 0; i < products.size(); i++) {
            if(i==0)
                continue;
            String expected = products.get(i);
            String actual = this.productPage.searchItem(expected);
            hashMap.put(actual, expected);
        }

    }

    @Then("User should able to find the list of product")
    public void userShouldAbleToFindTheListOfProduct() {
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            Assert.assertEquals(entry.getKey(),entry.getValue());
        }
    }
}
