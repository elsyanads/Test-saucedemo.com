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

public class sortLowhigh {
    WebDriver driver;

    @Given("I am on loginpage")
    public void iam_on_the_login_page() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("I login with credential username {string} and password {string}")
    public void i_login_with_credential_username_and_password(String username, String password) {
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @When("I select Price low to high sorting option")
    public void i_select_low_to_high_sorting_option() {
        WebElement sortDropdown = driver.findElement(By.className("product_sort_container"));
        Select sortSelect = new Select(sortDropdown);

        sortSelect.selectByValue("lohi");
    }

    @Then("The first product label should {string}")
    public void first_product_label_should(String expectedLabel) {
        WebElement firstItemLabel = driver.findElement(By.cssSelector("div.inventory_item_name"));
        String actualLabel = firstItemLabel.getText();

        Assert.assertEquals(expectedLabel, actualLabel);
    }
}
