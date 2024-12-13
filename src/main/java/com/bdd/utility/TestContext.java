package com.bdd.utility;

import com.bdd.constants.TestConstants;
import com.bdd.enums.ApplicationBrowser;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestContext {
    private static WebDriver webDriver;
    public static WebDriver getWebDriver()
    {
        return webDriver;
    }
    public static void TearUp()
    {
        OpenBrowser();
        MaximizeWindow();
        ImplicitWait(TestConstants.IMPLICIT_WAIT);
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
    static void ImplicitWait(int time) {
        webDriver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
    static void ExplicitWait(WebElement element) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(TestConstants.WEB_DRIVER_WAIT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    static void PageLoad(int time) {
        webDriver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
    }
    static void DeleteAllCookies() {
        webDriver.manage().deleteAllCookies();
    }
    static void SetEnvironment(){
        webDriver.get(TestConstants.LOGIN_URL);
    }
}
