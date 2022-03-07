package com.proyecto_selenium_dropdown_list;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends Base {

	@FindBy(name = "passCount")
	private WebElement dropdownPassengers;
	
	@FindBy(name = "fromPort")
	private WebElement dropdownDepartingFrom;
	
	public DropdownPage(WebDriver driver) {
		super(driver);
	}
	
	public String selectDropdownPassengers() {
		List<WebElement> options = dropdownPassengers.findElements(By.tagName("option"));
		for (WebElement option : options) {
			if (option.getText().equals("4 "))
				this.click(option);
		}
		String selectedOption = "";
		for(WebElement option: options)
			if (this.isSelected(option))
				selectedOption = this.getText(option);
		return selectedOption;
	}
	
	public String selectDropdownDepartingFrom() {
		Select select = new Select(dropdownDepartingFrom);
		select.selectByVisibleText("Paris");
		return this.getText(select.getFirstSelectedOption());
	}
	
}