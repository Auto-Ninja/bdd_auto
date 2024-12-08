package com.bdd.hooks;

import com.bdd.utility.TestContext;
import io.cucumber.java.*;

import java.sql.SQLOutput;

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
//    public void afterStep(Scenario scenario) {
////        System.out.println("Hooks > After Step: Step cleanup actions here.");
//    }

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