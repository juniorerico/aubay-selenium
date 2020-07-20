package mystore.pages;

import org.openqa.selenium.WebDriver;

import mystore.components.AddToCartModal;
import mystore.components.PageHeader;

/**
 * Classe principal a ser extendida por todos os page objects.
 * 
 * @author Erico
 *
 */
public class BasePage {
	private WebDriver driver;
	private PageHeader pageHeader;
	private AddToCartModal addToCartModal;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		pageHeader = new PageHeader(driver);
		addToCartModal = new AddToCartModal(driver);
	}
	
	public PageHeader getHeader() {
		return pageHeader;
	}
	
	public AddToCartModal getAddToCartModal() {
		return addToCartModal;
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
