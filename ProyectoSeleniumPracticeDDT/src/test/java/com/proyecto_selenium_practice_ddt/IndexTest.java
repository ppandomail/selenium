package com.proyecto_selenium_practice_ddt;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

class IndexTest {

	private WebDriver driver;
	private IndexPage indexPage; 
	
	@BeforeEach
	public void setUp() {
		indexPage = new IndexPage(driver);
		driver = indexPage.chromeDriverConnection();
		indexPage.visit("http://automationpractice.com/index.php");
	}

	@Test
	public void test() throws Exception {
		String filepath = "src/test/resources/Test.xlsx";
		String sheetName = "Hoja1";
		for(int i = 0; i < 3; i++) {
			String searchText = new ReadExcelFile().getCellValue(filepath, sheetName, i, 0);
			String resultText = indexPage.search(searchText);
			new WriteExcelFile().writeCellValue(filepath, sheetName, i, 1, resultText);
		}
	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}

}