package com.proyecto_selenium_mercury_tours_pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends Base {
	
	@FindBy(name = "userName")
	private WebElement user;
	
	@FindBy(name = "password")
	private WebElement pass;
	
	@FindBy(name = "submit")
	private WebElement signInBtn;
	
	@FindBy(tagName = "h3")
	private WebElement homePage;
	
	public SignInPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void signIn() {
		if (this.isDisplayed(user)) {
			this.type("ppando", user);
			this.type("ppando", pass);
			this.click(signInBtn);	
		}
	}
	
	public String loginSuccessfullyMessage() {
		return this.getText(homePage);	
	}

}