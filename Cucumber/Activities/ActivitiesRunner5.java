package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinations"},
    tags = "@activity5",
    dryRun=false,
    plugin = {"html:target/cucumber-reports/reports" },
    monochrome = true
)

public class ActivitiesRunner5 {

}
