package saucedemo.cucumber.stepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class login {
    WebDriver driver;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }
    @When("I enter {string} and {string}")
    public void i_enter_credentials(String username, String password) {
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Then("I should {string} see the products page")
    public void i_should_see_the_products_page(String result) {
        if (result.equals("should")) {
            WebElement productsHeader = driver.findElement(By.className("title"));
            assert productsHeader.getText().equals("Products");
        } else if (result.equals("should not")) {
            WebElement errorElement = driver.findElement(By.cssSelector("h3[data-test='error']"));
            assert errorElement.isDisplayed();
        }
        driver.quit();
    }
}

