package saucedemo.cucumber.stepDef;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCart {
    WebDriver driver;

    @Given("I'm in the SauceDemo login screen")
    public void login_Addtocart() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("Login with username {string} and password {string}")
    public void login_credential_addtocart(String username, String password) {

        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @When("I click the Add to Cart button")
    public void addtocart() {

        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();
    }

    @Then("the cart icon should show an increased count")
    public void cart_icon_shows_increased_count() {

        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        String updatedItemCountText = cartBadge.getText();

        int updatedItemCount = Integer.parseInt(updatedItemCountText);

        Assert.assertTrue(updatedItemCount > 0);
    }
}
