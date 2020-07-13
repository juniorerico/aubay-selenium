package mystore.pages;

import org.openqa.selenium.WebDriver;

/**
 * Classe principal a ser extendida por todos os page objects.
 * 
 * @author Erico
 *
 */
public class BasePage {
	private WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Retorna o título da página atual
	 * 
	 * @return
	 */
	public String getTitle() {
		return driver.getTitle();
	}
	
	/**
	 * Retorna o WebDriver
	 * 
	 * @return
	 */
	public WebDriver getDriver() {
		return driver;
	}
}
