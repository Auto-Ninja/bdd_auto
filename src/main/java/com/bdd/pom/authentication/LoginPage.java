package com.bdd.pom.authentication;

import com.bdd.base.PomBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
}
