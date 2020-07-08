package theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {
	private WebDriver driver;
	
	private By linkExampleOne = By.linkText("Example 1: Element on page that is hidden");
	
	public DynamicLoadingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public DynamicLoadingPageExampleOne clickExampleOne() {
		driver.findElement(linkExampleOne).click();
		return new DynamicLoadingPageExampleOne(driver);
	}
}
