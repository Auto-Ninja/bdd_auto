package com.bdd.utility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import com.bdd.constants.TestConstants;
import com.bdd.enums.ApplicationBrowser;

public class TestContext {
    private static WebDriver webDriver;
    public static WebDriver getWebDriver()
    {
        return webDriver;
    }
    public static void TearUp() throws IOException {
        OpenBrowser();
        MaximizeWindow();
        SetTimeOuts(TestConstants.IMPLICIT_WAIT);
        DeleteAllCookies();
        SetEnvironment();
    }
    public static void TearDown()
    {
        if(webDriver!=null)
            webDriver.close();
    }
    static void OpenBrowser()
    {
        webDriver = DriverFactory.GetBrowser(ApplicationBrowser.CHROME);
    }
    static void MaximizeWindow() {
        webDriver.manage().window().setSize(new Dimension(1440, 900));
        webDriver.manage().window().maximize();
    }

    static void SetTimeOuts(int time) {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
        webDriver.manage().timeouts().scriptTimeout(Duration.ofSeconds(time + 30));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(time + 60));
    }

   
    static void DeleteAllCookies() {
        webDriver.manage().deleteAllCookies();
    }
    static void SetEnvironment() throws IOException {
        webDriver.get(TestConstants.getValueFromProperties("Browser_URL"));
    }
}
