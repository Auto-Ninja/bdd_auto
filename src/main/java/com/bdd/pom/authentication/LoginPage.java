package com.bdd.pom.authentication;

import com.bdd.base.PomBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage extends PomBase {
    public LoginPage(WebDriver webDriver){
        super(webDriver);
    }

    public void SetUsername(String username){

    }

    public void SetPassword(String password){

    }

    public void Submit(){

    }

    public void NavigateToProduct(){
        ProductPage productPage = new ProductPage(this.driver);
    }
}
