package com.proyecto_selenium_mercury_tours_pf;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

class SignInTest {

	private WebDriver driver;
	private SignInPage signInPage;

	@BeforeEach
	public void setUp() {
		signInPage = new SignInPage(driver);
		driver = signInPage.chromeDriverConnection();
		signInPage.visit("http://demo.guru99.com/test/newtours/");
	}

	@Test
	public void signIn() throws InterruptedException {
		signInPage.signIn();
		Thread.sleep(2000);
		assertEquals("Login Successfully", signInPage.loginSuccessfullyMessage());
	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}

}