package mystore.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import mystore.pages.ContactUsPage;

public class PageHeader {
	private WebDriver driver;
	private ShoppingCart shoppingCart;
	
	private By contactUs = By.cssSelector("#contact-link a");
	
	public PageHeader(WebDriver driver) {
		this.driver = driver;
		shoppingCart = new ShoppingCart(driver);
	}
	
	/**
	 * Retorna o Page Component do carrinho de compras
	 * 
	 * @return
	 */
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	
	public ContactUsPage clickContactUs() {
		driver.findElement(contactUs).click();
		return new ContactUsPage(driver);
	}
}
