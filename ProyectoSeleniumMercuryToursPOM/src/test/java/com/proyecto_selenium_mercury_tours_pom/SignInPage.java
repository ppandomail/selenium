package com.proyecto_selenium_mercury_tours_pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends Base {
	
	private By userLocator = By.name("userName");
	private By passLocator = By.name("password");
	private By signInBtnLocator = By.name("submit");
	private By homePageLocator = By.tagName("h3");
	
	public SignInPage(WebDriver driver) {
		super(driver);
	}
	
	public void signIn() {
		if (this.isDisplayed(userLocator)) {
			this.type("ppando", userLocator);
			this.type("ppando", passLocator);
			this.click(signInBtnLocator);	
		}
	}
	
	public String loginSuccessfullyMessage() {
		return this.getText(homePageLocator);	
	}

}