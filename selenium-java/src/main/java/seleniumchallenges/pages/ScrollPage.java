package seleniumchallenges.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.SeleniumUtils;

public class ScrollPage {
	private WebDriver driver;
	
	private By button = By.cssSelector("#group-6 button");
	
	public ScrollPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickButton() {
		WebElement buttonElement = driver.findElement(button);
		
		SeleniumUtils.scrollToElement(driver, buttonElement);
				
		buttonElement.click();
	}
}
