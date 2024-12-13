package com.bdd.authentication;

import com.bdd.base.BaseStepDefs;
import com.bdd.constants.TestConstants;
import com.bdd.enums.ApplicationBrowser;
import com.bdd.pom.authentication.LoginPage;
import com.bdd.pom.authentication.ProductPage;
import com.bdd.utility.DriverFactory;
import com.bdd.utility.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LogInStepdefs extends BaseStepDefs {
    LoginPage loginPage;
    ProductPage productPage;
    @When("I enter {string} in the Username text box")
    public  void EnterUsername(String username) {
        loginPage.SetUsername(username);
    }

    @And("I enter {string} in the Password text box")
    public void EnterPassword(String password) {
        loginPage.SetPassword(TestConstants.getDefaultPassword());
    }

    @Given("The application has been launched")
    public void LaunchApplication() {
        loginPage = new LoginPage(TestContext.getWebDriver());
        Assert.assertEquals(loginPage.getPageTitle(), "Swag Labs");
        Assert.assertTrue(loginPage.logoIsDisplayed());
    }

    @And("I click on the login button")
    public void LoginClick() {
        loginPage.Submit();
    }

    @Then("the system should display the {string} page")
    public void RedirectToProducts(String pagetitle) {
        productPage = new ProductPage(loginPage.driver);
        Assert.assertEquals(productPage.GetPageHeader().toUpperCase(), pagetitle.toUpperCase());
        loginPage = null;
        productPage =null;
    }

    @Then("Locked out error message {string} is displayed")
    public void lockedOutErrorMessageIsDisplayed(String errorMsg) {
        String actual = loginPage.getLockedUserErrorMsg();
        Assert.assertEquals(actual, errorMsg);
    }
}
