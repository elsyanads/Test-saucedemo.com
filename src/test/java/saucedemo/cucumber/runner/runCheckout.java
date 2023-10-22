package saucedemo.cucumber.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/saucedemo/cucumber/features/Checkout.feature",
        glue = "saucedemo.cucumber.stepDef",
        plugin = {"pretty", "html:target/Checkout.html"}
)
public class runCheckout {
}
