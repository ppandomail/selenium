package com.proyecto_selenium_dropdown_list;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class DropdownTest {
	
	private WebDriver driver;
	private DropdownPage dropdownPage;
	
	@BeforeEach
	public void setUp() {
		dropdownPage = new DropdownPage(driver);
		driver = dropdownPage.chromeDriverConnection();
		dropdownPage.visit("http://demo.guru99.com/test/newtours/reservation.php");
	}
	
	@Test
	public void test() {
		assertEquals("4 ", dropdownPage.selectDropdownPassengers());
		assertEquals("Paris", dropdownPage.selectDropdownDepartingFrom());
	}
	
	@AfterEach
	public void tearDown() {
		driver.quit();
	}

}