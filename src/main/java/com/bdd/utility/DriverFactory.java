package com.bdd.utility;

import com.bdd.enums.ApplicationBrowser;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;

import java.time.Duration;
import java.util.logging.Level;

import static com.bdd.enums.ApplicationBrowser.CHROME;

public class DriverFactory {
    static WebDriver webDriver;
    public static WebDriver GetBrowser(ApplicationBrowser applicationBrowser,Boolean headLessMode){
        switch (applicationBrowser.name().toUpperCase())
        {
            case "CHROME":
                webDriver = GetChromeDriver(headLessMode);
                break;
        }
        return webDriver;
    }

    private static ChromeDriver GetChromeDriver(Boolean isHeadLess){
        //--headless: Runs Chrome in headless mode.
        //--disable-extensions: Disables all installed extensions.
        //window-size=1200,800: Sets the browser window size to 1200x800 pixels.
        //user-data-dir: Specifies the directory for the custom user profile.
        //disable-infobars: Disables the info bar that appears at the top of the browser.

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //https://googlechromelabs.github.io/chrome-for-testing/
        //https://chromedriver.storage.googleapis.com/
        //Check Local cache for downloaded version
        //%UserProfile%\.cache\selenium\chromedriver
        //options.setCapability("browserVersion", "114.0.5735.90");
        //options.addArguments("headless=true");
        options.addArguments("window-size=1200,800");
        options.addArguments("disable-infobars");
        if(isHeadLess)
            options.addArguments("--headless=chrome");
        LoggingPreferences loggingPreferences = new LoggingPreferences();
        loggingPreferences.enable(LogType.BROWSER, Level.ALL);

        //options.setCapability(CapabilityType.BROWSER_NAME, loggingPreferences);
        return new ChromeDriver(options);
    }
}
