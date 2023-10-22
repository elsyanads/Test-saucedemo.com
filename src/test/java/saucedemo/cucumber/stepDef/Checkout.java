package saucedemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class Checkout {
    WebDriver driver;

    @Given("I access the login page saucecode.com")
    public void login_checkout() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("Login with valid credential username {string} and password {string}")
    public void login_checkout_credentials(String username, String password) {
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }

    @And("I choose {string} to the cart")
    public void add_product_to_cart(String product) {
        String productLocator = "//*[text()='" + product + "']";
        driver.findElement(By.xpath(productLocator + "/../../..//button[text()='Add to cart']")).click();
    }

    @And("I click the shopping cart link button")
    public void click_shopping_cart_link() {
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    @And("I click the Checkout button")
    public void click_checkout_button() {
        driver.findElement(By.id("checkout")).click();
    }

    @Then("I should be on the checkout-step-one.html page")
    public void verify_checkout_step_one_page() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.endsWith("checkout-step-one.html"));
    }

    @And("I fill in the Checkout Information with:")
    public void fill_checkout_information(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        WebElement firstNameInput = driver.findElement(By.id("first-name"));
        WebElement lastNameInput = driver.findElement(By.id("last-name"));
        WebElement postalCodeInput = driver.findElement(By.id("postal-code"));
        firstNameInput.sendKeys(data.get(0).get("First Name"));
        lastNameInput.sendKeys(data.get(0).get("Last Name"));
        postalCodeInput.sendKeys(data.get(0).get("Postal Code"));
    }

    @And("I click the Continue button")
    public void click_continue_button() {
        driver.findElement(By.id("continue")).click();
    }

    @Then("I should be on the checkout-step-two.html page")
    public void verify_checkout_step_two_page() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.endsWith("checkout-step-two.html"));
    }

    @And("I click the Finish button")
    public void click_finish_button() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("I should be on the checkout-complete.html page")
    public void completepage() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.endsWith("checkout-complete.html"));
    }
}
