package com.selenium.training.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.selenium.training.pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginValidate_POM {

	public static String browser = "chrome";
	public static WebDriver driver;
	LoginPage loginPage;

	@Given("browser is opened")
	public void browser_is_opened() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver); // Here we are calling login page cons and assigning driver
		System.out.println("browser is opened - done");
	}

	@And("user is on login page")
	public void user_is_on_login_page() {
		System.out.println("user is on login page - done");
		driver.navigate().to("https://example.testproject.io/web/");
	}
	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
	}

	@And("user clicks on login button")
	public void user_clicks_on_login_button() {
		loginPage.clickLogin();
	}
	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		boolean result = loginPage.checkLogoutDisplayed();
		Assert.assertEquals(true, result);
		driver.close();
		driver.quit();
	}

}
