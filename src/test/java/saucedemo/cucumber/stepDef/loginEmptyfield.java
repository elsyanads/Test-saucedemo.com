package saucedemo.cucumber.stepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class loginEmptyfield {
    WebDriver driver;

    @Given("I'm in login page")
    public void i_am_on_the_login_page() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("I enter an empty username and {string}")
    public void i_enter_empty_username(String password) {
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(password);
    }

    @When("I enter {string} and an empty password")
    public void i_enter_empty_password(String username) {
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.sendKeys(username);
    }

    @When("I click login button")
    public void i_click_the_login_button() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        WebElement errorElement = driver.findElement(By.cssSelector("h3[data-test='error']"));
        assert errorElement.isDisplayed();
        driver.quit();
    }
}
