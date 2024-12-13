package com.bdd.hooks;

import java.io.IOException;

import io.cucumber.java.AfterStep;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.bdd.utility.TestContext;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.testng.annotations.AfterSuite;

public class AuthenticationHooks {
    @Before
    public void beforeScenario(Scenario scenario) {
        TestContext.TearUp();
    }
    @After
    public void afterScenario(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) TestContext.getWebDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
        TestContext.TearDown();
    }
    @AfterStep
    public void afterStep(Scenario scenario) throws IOException {
            System.out.println("Hooks > After Step: Step cleanup actions here.");
    }


}