package saucedemo.cucumber.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
            features = "src/test/java/saucedemo/cucumber/features/login.feature",
            glue = "saucedemo.cucumber.stepDef",
            plugin = {"pretty", "html:target/login.html"},
            tags = "@TDD"
)

public class runLogin {

}
