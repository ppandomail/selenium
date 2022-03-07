package com.proyecto_selenium_mercury_tours_pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends Base {
	
	private By registerLinkLocator = By.linkText("REGISTER");
	private By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']");
	private By userNameLocator = By.id("email");
	private By passwordLocator = By.name("password");
	private By confirmPasswordLocator = By.name("confirmPassword");
	private By registerBtnLocator = By.name("submit");
	private By registeredMessage = By.tagName("font");
	
	public RegisterPage(WebDriver driver) {
		super(driver);	
	}
	
	public void registerUser() throws InterruptedException {
		this.click(registerLinkLocator);
		Thread.sleep(2000);
		if (this.isDisplayed(registerPageLocator)) {
			this.type("ppando", userNameLocator);
			this.type("ppando", passwordLocator);
			this.type("ppando", confirmPasswordLocator);
			this.click(registerBtnLocator);
		}
	}
	
	public String registeredMessage() {
		return this.getText(this.findElements(registeredMessage).get(5));	
	}

}