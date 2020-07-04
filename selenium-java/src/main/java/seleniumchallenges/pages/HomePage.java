package seleniumchallenges.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seleniumchallenges.components.ProductCard;

public class HomePage {
	private WebDriver driver;

	private By productCard = By.cssSelector("#group-4 .card");
	private By result = By.id("result-4");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// Compra um produto pelo nome
	public void buy(String name) {
		// Obtém todos os cards da página
		List<WebElement> cards = driver.findElements(productCard);

		// Percorre a lista de cards
		for(WebElement card : cards) {
			// Cria uma instância do Page Componente
			ProductCard productCard = new ProductCard(card);
			
			// Compara se o nome do card é igual ao que foi passado para o método
			if(productCard.getName().equals(name)) {
				productCard.clickButtonBuy();
			}
		}
	}
	
	// Retorna o resultado do desafio 4
	// OBS: O nome desse método deveria ser mais descritivo. Ex: getResultFour()
	public String getResult() {
		return driver.findElement(result).getText();
	}
}
