package com.bdd.pom.authentication;

import com.bdd.base.PomBase;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends PomBase {

    public CheckOutPage (WebDriver webDriver){
        super(webDriver);

    }
    public void SetFirstname(String firstname){
        clearText(CheckOutPageElements.firstname);
        setText(CheckOutPageElements.firstname, firstname);
    }

    public void SetLastname(String lastname){
        clearText(CheckOutPageElements.lastname);
        setText(CheckOutPageElements.lastname,lastname);
    }

    public void SetZipCode(String zipcode){
        clearText(CheckOutPageElements.zipcode);
        setText(CheckOutPageElements.zipcode,zipcode);
    }

    public void Continue(){
        click(CheckOutPageElements.continueButton);
    }
}
