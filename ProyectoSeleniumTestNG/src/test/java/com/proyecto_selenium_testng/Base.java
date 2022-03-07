package com.proyecto_selenium_testng;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class Base {

	private WebDriver driver;

	public Base(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver chromeDriverConnection() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		PageFactory.initElements(driver, this);
		return driver;
	}
	
	public void visit(String url) {
		driver.get(url);
	}

	public String getText(WebElement element) {
		return element.getText();
	}

	public void type(String inputText, WebElement element) {
		element.sendKeys(inputText);
	}
	
	public void clear(WebElement element) {
		element.clear();
	}

	public void click(WebElement element) {
		element.click();
	}

	public boolean isDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}