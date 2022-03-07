package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import helpers.WebDriverConexion;
import pages.PageIndex;
import pages.PageLoginSucess;
import pages.PageReservation;

public class Tests {
	
	private static WebDriver driver;
	
	@BeforeAll
	public static void initTest() {
		driver = WebDriverConexion.getInstancia("http://demo.guru99.com/test/newtours/");
	}
	
	@Test
	public void testLoginOK() {
		PageIndex pageIndex = new PageIndex(driver);
		pageIndex.login("mercury", "mercury");
		PageLoginSucess pageLoginSucess = new PageLoginSucess(driver);
		pageLoginSucess.assertLoginSucess();
	}
	
	@Test
	public void testLoginFail() {
		PageIndex pageIndex = new PageIndex(driver);
		pageIndex.login("dede", "dede");
		pageIndex.assertLoginFail();
	}
	
	@Test
	public void testReservation() {
		PageIndex pageIndex = new PageIndex(driver);
		pageIndex.clickLinkFlights();
		PageReservation pageReservation = new PageReservation(driver);
		pageReservation.selectCantPassengers(2);
		pageReservation.selectDepartingFrom(3);
		pageReservation.selectArrivingTo("London");
	}
	
	@Test
	public void testCantidadInputs() {
		PageIndex pageIndex = new PageIndex(driver);
		pageIndex.assertCantidadInputs();
	}
	
	@AfterAll
	public static void finishTest() {
		WebDriverConexion.cerrar();
	}
	    
}