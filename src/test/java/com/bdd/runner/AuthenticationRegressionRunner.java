package com.bdd.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features/authentication", // Path to your feature files
         glue = {"com.bdd.authentication","com.bdd.hooks"}, // Path to your step definitions
         plugin = {"pretty",
                 "html:target/cucumber/cucumber-reports",
                 "json:build/cucumber/cucumber-reports/cucumber.json",
                 "rerun:build/cucumber/cucumber-reports/rerun.txt",
         }, // Reports and output settings
         tags = "@regression",
         monochrome = true // Cleaner console output
         )
        public class AuthenticationRegressionRunner extends AbstractTestNGCucumberTests{



}
