package com.proyecto_selenium_mercury_tours;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

class MercuryTours_AutomatedTest {
	
	private WebDriver driver;
	private By registerLinkLocator = By.linkText("REGISTER");
	private By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']");
	private By userNameLocator = By.id("email");
	private By passwordLocator = By.name("password");
	private By confirmPasswordLocator = By.name("confirmPassword");
	private By registerBtnLocator = By.name("submit");
	
	private By userLocator = By.name("userName");
	private By passLocator = By.name("password");
	private By signInBtnLocator = By.name("submit");
	private By homePageLocator = By.tagName("h3");
	
	@BeforeEach
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/");
	}

	@Test
	public void registerUser() throws InterruptedException {
		driver.findElement(registerLinkLocator).click();
		Thread.sleep(2000);
		if (driver.findElement(registerPageLocator).isDisplayed()) {
			driver.findElement(userNameLocator).sendKeys("ppando");
			driver.findElement(passwordLocator).sendKeys("ppando");
			driver.findElement(confirmPasswordLocator).sendKeys("ppando");
			driver.findElement(registerBtnLocator).click();
		}
		List<WebElement> fonts = driver.findElements(By.tagName("font"));
		assertEquals("Note: Your user name is ppando.", fonts.get(5).getText());	
	}
	
	@Test
	public void signIn() throws InterruptedException {
		if (driver.findElement(userLocator).isDisplayed()) {
			driver.findElement(userLocator).sendKeys("ppando");
			driver.findElement(passLocator).sendKeys("ppando");
			driver.findElement(signInBtnLocator).click();
			Thread.sleep(2000);
			assertEquals("Login Successfully", driver.findElement(homePageLocator).getText());
		}	
	}
	
	@AfterEach
	public void tearDown() {
		driver.quit();
	}

}
