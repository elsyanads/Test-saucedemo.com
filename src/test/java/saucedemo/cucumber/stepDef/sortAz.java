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

public class sortAz {
    WebDriver driver;

    @Given("I am on the saucedemo.com login page")
    public void i_am_on_the_saucedemo_com_login_page() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("I log in with username {string} and password {string}")
    public void i_log_in_with_username_and_password(String username, String password) {
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @When("I select 'A to Z' sorting option")
    public void i_select_a_to_z_sorting_option() {
        WebElement sortDropdown = driver.findElement(By.className("product_sort_container"));
        Select sortSelect = new Select(sortDropdown);

        sortSelect.selectByValue("az");
    }

    @Then("the first product label should be {string}")
    public void the_first_product_label_should_be(String expectedLabel) {
        WebElement firstItemLabel = driver.findElement(By.cssSelector("div.inventory_item_name"));
        String actualLabel = firstItemLabel.getText();

        Assert.assertEquals(expectedLabel, actualLabel);
    }
}
