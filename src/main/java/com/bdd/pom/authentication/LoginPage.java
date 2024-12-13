package com.bdd.pom.authentication;

import com.bdd.base.PomBase;
import com.bdd.constants.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends PomBase {

    public LoginPage(WebDriver webDriver){
        super(webDriver);
    }

    public void SetUsername(String username){
        clearText(LoginPageElements.usernameTextBox);
        setText(LoginPageElements.usernameTextBox, username);

    }

    public void SetPassword(String password){
        clearText(LoginPageElements.passwordTextBox);
        setText(LoginPageElements.passwordTextBox, password);
    }

    public void Submit(){
        click(LoginPageElements.loginButton);
    }

    public void NavigateToProduct(){
        ProductPage productPage = new ProductPage(this.driver);
    }

    public boolean logoIsDisplayed() {
        return isDisplayed(LoginPageElements.logo);
    }

    public String getLockedUserErrorMsg() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(TestConstants.WEB_DRIVER_WAIT));
        WebElement element = driver.findElement(LoginPageElements.lockedUserErrorMsg);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
}
