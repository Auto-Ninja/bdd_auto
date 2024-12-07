package com.bdd.runner;

import org.testng.annotations.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features/authentication", // Path to your feature files
         glue = {"com.bdd.authentication","com.bdd.hooks"}, // Path to your step definitions
         plugin = {"pretty", "html:target/cucumber-reports"}, // Reports and output settings
         monochrome = true // Cleaner console output
         )

        public class AuthenticationRunner extends AbstractTestNGCucumberTests{

}
