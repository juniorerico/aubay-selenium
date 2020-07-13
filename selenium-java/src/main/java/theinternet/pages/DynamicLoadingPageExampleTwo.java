package theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPageExampleTwo {
	private WebDriver driver;
	
	private By startButton = By.cssSelector("#start button");
	private By result = By.cssSelector("#finish h4");
	
	public DynamicLoadingPageExampleTwo(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickStartButton(){
		driver.findElement(startButton).click();
	}
	
	public String getResult() {		
		return driver.findElement(result).getText();
	}
}
