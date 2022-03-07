package com.proyecto_selenium_testng;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IndexTest {
	
	private WebDriver driver;
	private IndexPage indexPage;
	
	@BeforeClass
	public void beforeClass() {
		indexPage = new IndexPage(driver);
		driver = indexPage.chromeDriverConnection();
		indexPage.visit("http://automationpractice.com/index.php");
	}
	
	@Test
	public void searchBlouses() {
		Assert.assertEquals(indexPage.search("blouse"), "1");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}