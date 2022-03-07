package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageReservation {
	
	@FindBy(name = "passCount")
	private WebElement cantPassengerDrop;
	
	@FindBy(name = "fromPort")
	private WebElement departingFromDrop;
	
	@FindBy(name = "toPort")
	private WebElement arrivingInDrop;
	
	public PageReservation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void selectCantPassengers(int count) {
		new Select(cantPassengerDrop).selectByVisibleText(Integer.toString(count));
	}
	
	public void selectDepartingFrom(int index) {
		new Select(departingFromDrop).selectByIndex(index);
	}
	
	public void selectArrivingTo(String value) {
		new Select(arrivingInDrop).selectByValue(value);
	}
	
}