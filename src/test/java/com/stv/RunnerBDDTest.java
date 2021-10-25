package com.stv;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources",
        glue = "com.stv.stepDefinitions"
)
public class RunnerBDDTest extends AbstractTestNGCucumberTests {}