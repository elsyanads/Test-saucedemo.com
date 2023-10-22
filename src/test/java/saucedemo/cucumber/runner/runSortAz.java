package saucedemo.cucumber.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/saucedemo/cucumber/features/sortAz.feature",
        glue = "saucedemo.cucumber.stepDef",
        plugin = {"pretty", "html:target/sortAz.html"}
)

public class runSortAz {
}
