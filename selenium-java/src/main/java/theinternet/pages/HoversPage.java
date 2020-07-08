package theinternet.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPage {
	private WebDriver driver;
	
	private By figure = By.cssSelector(".figure"); 
	
	public HoversPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void hoverFigures() {
		List<WebElement> figures = driver.findElements(figure);
		
		for(WebElement figureElement : figures) {
			Actions actions = new Actions(driver);
			actions.moveToElement(figureElement);
			
			actions.build().perform();
		}
	}
}
