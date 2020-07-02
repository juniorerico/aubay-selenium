package theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object da página de login do site The Internet
 * 
 * @author Erico
 *
 */
public class LoginPage {
	private WebDriver driver;
	
	// Locators dos elementos da página
	private By inputUsername = By.id("username");
	private By inputPassword = By.id("password");
	private By buttonLogin = By.cssSelector(".radius");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Realiza a ação de login
	// Este método retorna a próxima página (Secure Area Page)
	public SecureAreaPage login(String username, String password) {
		driver.findElement(inputUsername).sendKeys(username);
		driver.findElement(inputPassword).sendKeys(password);
		driver.findElement(buttonLogin).click();
		
		return new SecureAreaPage(driver);
	}
}
