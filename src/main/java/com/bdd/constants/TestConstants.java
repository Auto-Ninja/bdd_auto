package com.bdd.constants;

import com.bdd.utility.ConfigReader;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class TestConstants {
    public static int IMPLICIT_WAIT = 30;
    public static int WEB_DRIVER_WAIT = 30;
    private static String Config_File = "config.properties";
    public static String getValueFromProperties(String key) throws IOException {
        return new ConfigReader().LoadConfig(Config_File).GetValue(key);
    }
}
