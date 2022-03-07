package helpers;

import java.io.FileOutputStream;
import java.nio.file.FileSystems;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtilities {

	private WebDriver driver;

	public SeleniumUtilities(WebDriver driver) {
		this.driver = driver;
	}
	
	public String esperaDePaginaPorTitulo(String tituloEsperado) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.titleContains(tituloEsperado));
		return driver.getTitle();
	}

	public void esperaDeValorDeAtributo(WebElement webElement, String atributo, String valorEsperado) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.attributeToBe(webElement, atributo, valorEsperado));
	}

	public void esperaDeElementoParaSerClickeable(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
	}
	
	public void espararDeElementoASerInvisible(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	//Usar en un catch
	public static void captureScreenshot(String fileName, WebDriver driver) {
	 	try {
	         FileOutputStream out = new FileOutputStream(getDownloadPath()+"/"+ fileName + ".png");
	         out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
	         out.close();
	     } catch (Exception e) {
	    	 e.printStackTrace();
	     }
	 }
	
	private static String getDownloadPath() {
		System.out.println("UBICACION DE DESCARGA DE ARCHIVOS------------------>"+ FileSystems.getDefault().getPath("tmp").toAbsolutePath().toString());
		return FileSystems.getDefault().getPath("tmp").toAbsolutePath().toString();
	}
	
}