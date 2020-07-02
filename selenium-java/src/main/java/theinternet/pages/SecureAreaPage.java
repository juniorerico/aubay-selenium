package theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Page Object da página Secure Area do site The internet
 * 
 * @author Erico
 *
 */
public class SecureAreaPage {
	private WebDriver driver;
	
	// Locator dos elementos presentes na página
	private By title = By.cssSelector(".example h2");
	private By buttonLogout = By.cssSelector(".radius");
	
	public SecureAreaPage(WebDriver driver) {
		this.driver = driver;
		
		// Verifica se o browser está na página correta
		// OBS: Identifiquei que essa verificação pode causar problemas em alguns casos
		// irei explicar na próxima aula.
		Assert.assertEquals(driver.findElement(title).getText(), "Secure Area");
	}
	
	// Realiza a ação de logout
	public void logout() {
		driver.findElement(buttonLogout).click();
	}
}
