package com.proyecto_selenium_mercury_tours_pf;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

class RegisterTest {

	private WebDriver driver;
	private RegisterPage registerPage; 
	
	@BeforeEach
	public void setUp() {
		registerPage = new RegisterPage(driver);
		driver = registerPage.chromeDriverConnection();
		registerPage.visit("http://demo.guru99.com/test/newtours/");
	}

	@Test
	public void registerUser() throws InterruptedException {
		registerPage.registerUser();
		assertEquals("Note: Your user name is ppando.", registerPage.registeredMessage());
	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}

}