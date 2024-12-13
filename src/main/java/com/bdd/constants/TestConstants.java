package com.bdd.constants;

import com.bdd.utility.ConfigReader;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class TestConstants {
    public static int IMPLICIT_WAIT = 30;
    public static int WEB_DRIVER_WAIT = 30;


    public static String DEFAULT_PAYMENT_INFO = "SauceCard #31337";

    public static String DEFAULT_SHIPPING_INFO = "Free Pony Express Delivery!";
    private static String Config_File = "config.properties";
    public static String getValueFromProperties(String key)  {
        try {
            return new ConfigReader().LoadConfig(Config_File).GetValue(key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getDefaultUserName()
    {
        return getValueFromProperties("Username");
    }

    public static String getDefaultPassword()
    {
        return getValueFromProperties("Password");
    }
}
