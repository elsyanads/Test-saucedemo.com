package saucedemo.cucumber.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;

public class sortHighlow {
    WebDriver driver;

    @Given("I'm in login screen")
    public void login_sortHighlow() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("I'm login credential username {string} and password {string}")
    public void login_credential_sortHighlow(String username, String password) {
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @When("I select Price high to low sorting option")
    public void select_option_high_low() {
        WebElement sortDropdown = driver.findElement(By.className("product_sort_container"));
        Select sortSelect = new Select(sortDropdown);

        sortSelect.selectByValue("hilo");
    }

    @Then("first product label should {string}")
    public void first_product_highlow(String expectedLabel) {
        WebElement firstItemLabel = driver.findElement(By.cssSelector("div.inventory_item_name"));
        String actualLabel = firstItemLabel.getText();

        Assert.assertEquals(expectedLabel, actualLabel);
    }
}
