package seleniumchallenges.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Page Component Object que representa um Produto na página 'Selenium Challenges'
 * 
 * @author Erico
 *
 */
public class ProductCard {
	private WebElement card;

	// private By image = ...
	// private By price = ...
	private By name = By.cssSelector(".card-text");
	private By buttonBuy = By.xpath(".//button[text()='Comprar']");

	public ProductCard(WebElement card) {
		this.card = card;
	}
	
	// Retorna o nome do produto
	public String getName() {
		return card.findElement(name).getText();
	}
	
	// Clica no botão 'Comprar' do produto 
	public void clickButtonBuy() {
		card.findElement(buttonBuy).click();
	}
}
