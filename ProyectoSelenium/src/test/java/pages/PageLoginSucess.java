package pages;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PageLoginSucess {
	
	@FindBy(tagName = "h3")
	private WebElement titleText;
	
	public PageLoginSucess(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void assertLoginSucess() {
		assertTrue(titleText.getText().contains("Login Successfully"));
	}
		
}