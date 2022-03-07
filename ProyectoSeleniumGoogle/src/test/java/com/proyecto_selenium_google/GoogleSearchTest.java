package com.proyecto_selenium_google;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest {
	
	private static WebDriver driver;
	
	@BeforeAll
	public static void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//Envia la url al navegador que se quiere abrir.
		driver.get("https://www.google.com/"); 
	}
		
	@Test
	public void testGooglePage() {
		//Encuentra un elemento en la página.
		WebElement cuadroIngreso = driver.findElement(By.name("q"));
		//Limpia texto que esté en la caja de búsqueda.
		cuadroIngreso.clear();
		//Envia el texto 
		cuadroIngreso.sendKeys("QA Automation");
		//Es como dar enter.
		cuadroIngreso.submit();
		//Tiempo que se quiere esperar.
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Compara esperado vs actual
		assertEquals("QA Automation - Buscar con Google", driver.getTitle());
	}
	
	@Test
	public void testGooglePage2() {
		//Encuentra un elemento en la página.
		WebElement cuadroIngreso = driver.findElement(By.name("q"));
		//Limpia texto que esté en la caja de búsqueda.
		cuadroIngreso.clear();
		//Envia el texto 
		cuadroIngreso.sendKeys("Se va el tercero");
		//Es como dar enter.
		cuadroIngreso.submit();
		//Tiempo que se quiere esperar.
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Compara esperado vs actual
		assertEquals("Se va el tercero - Buscar con Google", driver.getTitle());
	}
	
	@AfterAll
	public static void tearDown() {
		//Cierra el navegador una vez que se completan las pruebas.
		driver.quit();
	}
	
}


