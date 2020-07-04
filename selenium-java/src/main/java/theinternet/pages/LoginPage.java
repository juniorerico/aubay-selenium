package theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object da p�gina de login do site The Internet
 * 
 * @author Erico
 *
 */
public class LoginPage {
	private WebDriver driver;
	
	// Locators dos elementos da p�gina
	private By inputUsername = By.id("username");
	private By inputPassword = By.id("password");
	private By buttonLogin = By.cssSelector(".radius");
	private By alertMessage = By.id("flash");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Realiza a a��o de login
	// Este m�todo retorna a pr�xima p�gina (Secure Area Page)
	public SecureAreaPage login(String username, String password) {
		driver.findElement(inputUsername).sendKeys(username);
		driver.findElement(inputPassword).sendKeys(password);
		driver.findElement(buttonLogin).click();
		
		return new SecureAreaPage(driver);
	}
	
	public String getAlertMessage() {
		return driver.findElement(alertMessage).getText();
	}
}
