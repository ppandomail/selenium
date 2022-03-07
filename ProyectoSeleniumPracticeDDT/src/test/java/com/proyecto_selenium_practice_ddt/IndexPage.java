package com.proyecto_selenium_practice_ddt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends Base {
	
	@FindBy(id = "search_query_top")
	private WebElement searchBox;
	
	@FindBy(name = "submit_search")
	private WebElement searchBtn;
	
	@FindBy(css = "span[class = 'heading-counter']")
	private WebElement resultText;
	
	public IndexPage(WebDriver driver) {
		super(driver);
	}
	
	public String search(String searchText) {
		this.clear(searchBox);
		this.type(searchText, searchBox);
		this.click(searchBtn);
		return this.getText(resultText).split(" ")[0];
	}

}