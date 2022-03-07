package com.proyecto_selenium_local;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalTest {
	
private static WebDriver driver;
	
	@BeforeAll
	public static void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("file:///Users/ppando/eclipse-workspace/prog3/ProyectoSeleniumLocal/src/test/resources/index.html"); 
	}
	
	@Test
	public void testLocalPage() {
		WebElement searchBox = driver.findElement(By.id("searchBox"));
		searchBox.clear();
		searchBox.sendKeys("QA Automation");
		WebElement searchButton = driver.findElement(By.name("searchButton"));
		searchButton.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertEquals("QA Automation", searchBox.getAttribute("value"));
	}
	
	@AfterAll
	public static void tearDown() {
		driver.quit();
	}

}
