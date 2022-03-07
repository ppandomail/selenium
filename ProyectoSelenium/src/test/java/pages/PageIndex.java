package pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PageIndex {
	
	@FindBy(name = "userName")
	private WebElement userField;
	
	@FindBy(name = "password")
	private WebElement passField;
	
	@FindBy(name = "submit")
	private WebElement loginButton;
	
	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[3]/td[2]/span")
	private WebElement titleText;
	
	@FindBy(linkText = "Flights")
	private WebElement flightsLink;
	
	@FindBy(tagName = "input")
	private List<WebElement> inputs;
	
	public PageIndex(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void login(String username, String password) {
		userField.sendKeys(username);
		passField.sendKeys(password);
		loginButton.click();
	}
	
	public void assertLoginFail() {
		titleText.getText().contains("Enter your userName and password correct");
	}
	
	public void clickLinkFlights() {
		flightsLink.click();
	}
	
	public void assertCantidadInputs() {
		assertEquals(4, inputs.size());
	}
	
}