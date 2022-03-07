package com.proyecto_selenium_mercury_tours_pf;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Base {
	
	@FindBy(linkText = "REGISTER")
	private WebElement registerLink;
	
	@FindBy(xpath = "//img[@src='images/mast_register.gif']")
	private WebElement registerPage;
	
	@FindBy(id = "email")
	private WebElement userName;
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(name = "confirmPassword")
	private WebElement confirmPassword;
	
	@FindBy(name = "submit")
	private WebElement registerBtn;
	
	@FindBy(tagName = "font")
	private List<WebElement> registeredMessage;
	
	public RegisterPage(WebDriver driver) {
		super(driver);	
	}
	
	public void registerUser() throws InterruptedException {
		this.click(registerLink);
		Thread.sleep(2000);
		if (this.isDisplayed(registerPage)) {
			this.type("ppando", userName);
			this.type("ppando", password);
			this.type("ppando", confirmPassword);
			this.click(registerBtn);
		}
	}
	
	public String registeredMessage() {
		return this.getText(registeredMessage.get(5));	
	}

}