package mystore.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.SeleniumUtils;
import mystore.components.ProductCard;

public class HomePage extends BasePage {
	
	private By productCard = By.cssSelector(".product-container");
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Adiciona um produto ao carrinho de compras
	 * 
	 * @param name
	 */
	public double addProductToCart(String name) {
		List<WebElement> products = getDriver().findElements(productCard);
		
		for(WebElement product : products) {
			ProductCard productCard = new ProductCard(product);
			
			if(productCard.getName().equals(name)) {
				SeleniumUtils.hoverElement(getDriver(), product);
				productCard.buy();
				return productCard.getPrice();
			}
		}
		
		return 0;
	}
	
	public ProductPage clickProduct(String name) {
		List<WebElement> products = getDriver().findElements(productCard);
		
		for(WebElement product : products) {
			ProductCard productCard = new ProductCard(product);
			
			if(productCard.getName().equals(name)) {
				product.click();
				return new ProductPage(getDriver());
			}
		}
		
		return null;
	}
}
