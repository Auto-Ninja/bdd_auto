package com.bdd.authentication;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogInStepdefs {
    @When("I enter {string} in the Username text box")
    public void EnterUsername(String username) {
    }

    @And("I enter {string} in the Password text box")
    public void EnterPassword(String password) {
    }

    @Given("The application has been launched")
    public void LaunchApplication() {
    }

    @And("I click on the login button")
    public void LoginClick() {

    }

    @Then("the system should display the {string} page")
    public void RedirectToProducts(String pagetitle) {
    }
}
