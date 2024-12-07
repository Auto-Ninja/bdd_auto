package com.bdd.authentication;

import com.bdd.base.BaseStepDefs;
import com.bdd.pom.authentication.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogInStepdefs extends BaseStepDefs {
    @When("I enter {string} in the Username text box")
    public void EnterUsername(String username) {
        WebDriver webDriver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(webDriver);
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
