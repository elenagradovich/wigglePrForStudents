package com.stv;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/MainFeature.feature",
        glue = {"com.stv.stepDefinitions.MainPageStep",
                "com.stv.stepDefinitions.LoginPageStep"
        }
)
public class RunnerBDDTest extends AbstractTestNGCucumberTests {}