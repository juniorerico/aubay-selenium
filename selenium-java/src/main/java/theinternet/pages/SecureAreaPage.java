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
	}
	
	public String getTitle() {
		return driver.findElement(title).getText();
	}
	
	// Realiza a ação de logout
	public void logout() {
		driver.findElement(buttonLogout).click();
	}
}
