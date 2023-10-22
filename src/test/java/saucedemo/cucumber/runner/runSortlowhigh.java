package saucedemo.cucumber.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/saucedemo/cucumber/features/sortLowhigh.feature",
        glue = "saucedemo.cucumber.stepDef",
        plugin = {"pretty", "html:target/sortLowhigh.html"}
)

public class runSortlowhigh {
}
