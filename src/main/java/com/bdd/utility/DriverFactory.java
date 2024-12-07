package com.bdd.utility;

import com.bdd.enums.ApplicationBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {
    static WebDriver webDriver;
    public static WebDriver GetBrowser(ApplicationBrowser applicationBrowser){
        switch (applicationBrowser)
        {
            case CHROME:
                webDriver = GetChromeDriver();
                break;

        }
        return webDriver;
    }

    private static ChromeDriver GetChromeDriver(){
        // Create an instance of ChromeOptions
        //--headless: Runs Chrome in headless mode.
        //--disable-extensions: Disables all installed extensions.
        //window-size=1200,800: Sets the browser window size to 1200x800 pixels.
        //user-data-dir: Specifies the directory for the custom user profile.
        //disable-infobars: Disables the info bar that appears at the top of the browser.
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("headless=true");
        options.addArguments("window-size=1200,800");
        options.addArguments("disable-infobars");
        var driver = new ChromeDriver(options);
        return driver;
    }
}
