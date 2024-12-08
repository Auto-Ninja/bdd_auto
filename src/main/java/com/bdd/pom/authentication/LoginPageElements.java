package com.bdd.pom.authentication;

import org.openqa.selenium.By;

public class LoginPageElements {
    public static By usernameTextBox = By.xpath("//*[@id='user-name']");
    public static By passwordTextBox = By.xpath("//*[@id='password']");
    public static By errorMsg = By.xpath("//div[@class='error-message-container error']/h3");
    public static By loginButton = By.xpath("//*[@id='login-button']");
    public static By logo = By.xpath("//div[@class='login_logo']");

    public static By lockedUserErrorMsg = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");

}
