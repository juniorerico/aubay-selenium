package mystore.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commons.SeleniumUtils;

public class ShoppingCart {
	private WebDriver driver;
	
	private By shoppingCart = By.cssSelector(".shopping_cart > a");
	private By productCount = By.cssSelector(".shopping_cart .ajax_cart_quantity");
	private By shippingCost = By.cssSelector(".shopping_cart .cart_block_shipping_cost");
	private By totalPrice = By.cssSelector(".shopping_cart .cart_block_total");
	
	public ShoppingCart(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Retorna a quantidade de produtos no carrinho
	 * 
	 * @return
	 */
	public int getProductCount() {
		String count = driver.findElement(productCount).getText();
		return Integer.parseInt(count);
	}
	
	/**
	 * Retorna o valor total da compra
	 * 
	 * @return
	 */
	public double getTotalPrice() {
		SeleniumUtils.hoverElement(driver, driver.findElement(shoppingCart));
		
		String total = driver.findElement(totalPrice).getText().replace("$", "");
		return Double.parseDouble(total);
	}
	
	public double getShippingPrice() {
		SeleniumUtils.hoverElement(driver, driver.findElement(shoppingCart));
		
		String cost = driver.findElement(shippingCost).getText().replace("$", "");
		
		return Double.parseDouble(cost);
	}
}