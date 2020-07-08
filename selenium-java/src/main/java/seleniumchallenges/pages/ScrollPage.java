package seleniumchallenges.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollPage {
	private WebDriver driver;
	
	private By button = By.cssSelector("#group-6 button");
	
	public ScrollPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickButton() {
		WebElement buttonElement = driver.findElement(button);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", buttonElement);
		
		buttonElement.click();
	}
}
