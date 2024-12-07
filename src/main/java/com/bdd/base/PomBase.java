package com.bdd.base;

import org.openqa.selenium.WebDriver;

public class PomBase {

    public WebDriver driver;
    public PomBase(WebDriver webDriver){
        this.driver = webDriver;
    }
}
