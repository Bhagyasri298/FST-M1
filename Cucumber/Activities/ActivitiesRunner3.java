package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinations"},
    tags = "@activity3",
    plugin = { "pretty", "html:target/cucumber-reports/reports" },
    monochrome = true
)

public class ActivitiesRunner3 {
    //empty
}