package onliner.test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/java/onliner/features/OnlinerFeature.feature",
        glue = "onliner.stepsDefinition",
        plugin = {"pretty", "json:target/cucumber-reports/CucumberTestReport.json"})

public class TestRunner extends AbstractTestNGCucumberTests {
}