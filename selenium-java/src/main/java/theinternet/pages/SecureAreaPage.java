package theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Page Object da p�gina Secure Area do site The internet
 * 
 * @author Erico
 *
 */
public class SecureAreaPage {
	private WebDriver driver;
	
	// Locator dos elementos presentes na p�gina
	private By title = By.cssSelector(".example h2");
	private By buttonLogout = By.cssSelector(".radius");
	
	public SecureAreaPage(WebDriver driver) {
		this.driver = driver;
		
		// Verifica se o browser est� na p�gina correta
		// OBS: Identifiquei que essa verifica��o pode causar problemas em alguns casos
		// irei explicar na pr�xima aula.
		Assert.assertEquals(driver.findElement(title).getText(), "Secure Area");
	}
	
	// Realiza a a��o de logout
	public void logout() {
		driver.findElement(buttonLogout).click();
	}
}
