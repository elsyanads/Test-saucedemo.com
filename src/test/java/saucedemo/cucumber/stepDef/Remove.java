package saucedemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Remove {
    WebDriver driver;

    @Given("I'm in the login-screen")
    public void i_m_in_the_login_screen() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("Login with credential username {string} and password {string}")
    public void loginRemove(String username, String password) {
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    @And("I add an item to the shopping cart")
    public void add_an_item_to_the_shopping_cart() {
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();
    }

    @And("I click the Remove button")
    public void i_click_the_remove_button() {
        WebElement removeButton = driver.findElement(By.id("remove-sauce-labs-backpack"));
        removeButton.click();
    }

    @Then("the cart icon should show a decreased count")
    public void verify_cart_icon_decreased_count() {
        WebElement cartBadge = driver.findElement(By.id("shopping_cart_container"));
        String badgeText = cartBadge.getText();

        Assert.assertTrue(badgeText.isEmpty());
    }
}
