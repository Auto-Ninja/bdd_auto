package com.bdd.base;

import com.bdd.constants.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PomBase {

    public WebDriver driver;
    public PomBase(WebDriver webDriver){
        this.driver = webDriver;
    }


    public void highLightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: #89cff0; border: 2px solid red;');", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
    public void waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestConstants.WEB_DRIVER_WAIT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void clearText(By by) {
        var element = driver.findElement(by);
        waitForVisibility(element);
        highLightElement(element);
        element.clear();
    }
    public void click(By by) {
        var element = driver.findElement(by);
        waitForVisibility(element);
        highLightElement(element);
        element.click();
    }
    public void setText(By by, String text) {
        var element = driver.findElement(by);
        waitForVisibility(element);
        highLightElement(element);
        element.sendKeys(text);
    }
    public String getText(By by) {
        var element = driver.findElement(by);
        waitForVisibility(element);
        highLightElement(element);
        return element.getText();
    }

    public boolean isDisplayed(By by) {
        var element = driver.findElement(by);
        waitForVisibility(element);
        highLightElement(element);
        return element.isDisplayed();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
