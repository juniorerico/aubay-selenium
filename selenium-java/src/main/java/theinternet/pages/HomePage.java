package theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object da Home Page do site The Internet 
 * 
 * @author Erico
 *
 */
public class HomePage {
	private WebDriver driver;
	
	// Locator do Link "Form Authentication"
	private By linkFormAuthentication = By.linkText("Form Authentication");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Método que realiza a ação de clicar no link Form Authentication
	// Este método retorna a próxima página (Login Page)
	public LoginPage clickFormAuthentication() {
		driver.findElement(linkFormAuthentication).click();
		return new LoginPage(driver);
	}
}
