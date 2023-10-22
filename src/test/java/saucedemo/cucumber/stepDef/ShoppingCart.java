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

public class ShoppingCart {
    WebDriver driver;

    @Given("I'm on login-screen")
    public void login_shoppingcart() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("Login with valid username {string} and password {string}")
    public void login_valid(String username, String password) {
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }

    @And("I add {string} to the cart")
    public void add_cart(String product) {
        String productLocator = "//*[text()='" + product + "']";
        driver.findElement(By.xpath(productLocator + "/../../..//button[text()='Add to cart']")).click();
    }

    @And("I click the shopping cart link")
    public void click_shopping_cart_link() {
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    @Then("I should see the product {string} in the cart")
    public void verify_product_in_cart(String product) {
        String productLocator = "//*[text()='" + product + "']";
        Assert.assertTrue(driver.findElement(By.xpath(productLocator)).isDisplayed());
    }
}
