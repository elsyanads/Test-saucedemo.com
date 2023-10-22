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

public class sortZa {
    WebDriver driver;

    @Given("I'm in login page saucedemo")
    public void iam_on_the_saucedemo_com_login_page() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("I login with username {string} and password {string}")
    public void i_login_with_username_and_password(String username, String password) {
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @When("I select 'Z to A' sorting option")
    public void i_select_z_to_a_sorting_option() {
        WebElement sortDropdown = driver.findElement(By.className("product_sort_container"));
        Select sortSelect = new Select(sortDropdown);

        sortSelect.selectByValue("za");
    }

    @Then("first product label should be {string}")
    public void the_first_product_label_should_be(String expectedLabel) {
        WebElement firstItemLabel = driver.findElement(By.cssSelector("div.inventory_item_name"));
        String actualLabel = firstItemLabel.getText();

        Assert.assertEquals(expectedLabel, actualLabel);
    }
}
