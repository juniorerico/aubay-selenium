package mystore.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Componente que representa um produto na aplicação
 * 
 * @author Erico
 *
 */
public class ProductCard {
	private WebElement product;
	
	private By name = By.cssSelector(".product-name");
	private By price = By.cssSelector(".product-price");
	private By buttonAddToCart = By.cssSelector(".ajax_add_to_cart_button");
	
	public ProductCard(WebElement product) {
		this.product = product;
	}
	
	/**
	 * Retorna o nome do produto
	 * 
	 * @return
	 */
	public String getName() {
		return product.findElement(name).getText();
	}
	
	/**
	 * Adiciona o produto no carrinho
	 * 
	 */
	public void buy() {
		product.findElement(buttonAddToCart).click();
	}
	
	public double getPrice() {
		String productPrice = product.findElement(price).getText().replace("$", "");
		
		return Double.parseDouble(productPrice);
	}
}
