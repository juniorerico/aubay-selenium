package mystore.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commons.SeleniumUtils;

public class AddToCartModal {
	private WebDriver driver;
	
	private By buttonContinueShopping = By.cssSelector("#layer_cart .continue");
	
	public AddToCartModal(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Clica no bot�o "Continue Shopping" no modal que � exibido
	 * ap�s adicionar um produto no carrinho
	 * 
	 */
	public void continueShopping() {
		SeleniumUtils.waitForElementToBeClickable(driver, buttonContinueShopping).click();
	}
}
