package com.bdd.hooks;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.bdd.utility.TestContext;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AuthenticationHooks {

    @Before
    public void beforeScenario(Scenario scenario) {
//        System.out.println("Hooks > Before Scenario: Setup actions here.");
//        System.out.println("=================== Scenario Start> " + scenario.getName() +  " ===================");
        TestContext.TearUp();
    }
    @After
    public void afterScenario(Scenario scenario) {
//        System.out.println("Hooks >After Scenario: Cleanup actions here.");
//        System.out.println("=================== Scenario End> " + scenario.getName() +  " ===================");
//        System.out.println(scenario.getStatus());
        TestContext.TearDown();
    }
//    @BeforeStep
//    public void beforeStep(Scenario scenario) {
////        System.out.println("Hooks > Before Step: Step setup actions here.");
////        System.out.println(">>>"+ scenario.getName());
//    }
//    @AfterStep
   public void afterStep(Scenario scenario) throws IOException {
        System.out.println("Hooks > After Step: Step cleanup actions here.");
        final byte[] screenshot = ((TakesScreenshot) TestContext.getWebDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName()); 
		
   }

//    @Before("@smoke")
//    public void beforeSmokeScenario() {
////        System.out.println("Hooks > Smoke Tags > Before Scenario: Setup actions here.");
//    }
//
//    @After("not @smoke")
//    public void afterIgnoreSmokeStep() {
////        System.out.println("Hooks > Smoke Tags [ignore] > After Scenario: Cleanup actions here.");
//    }
}