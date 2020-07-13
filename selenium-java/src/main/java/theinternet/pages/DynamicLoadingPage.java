package theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {
	private WebDriver driver;
	
	private By linkExampleOne = By.linkText("Example 1: Element on page that is hidden");
	private By linkExampleTwo = By.linkText("Example 2: Element rendered after the fact");
	
	public DynamicLoadingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public DynamicLoadingPageExampleOne clickExampleOne() {
		driver.findElement(linkExampleOne).click();
		return new DynamicLoadingPageExampleOne(driver);
	}
	
	public DynamicLoadingPageExampleTwo clickExampleTwo() {
		driver.findElement(linkExampleTwo).click();
		return new DynamicLoadingPageExampleTwo(driver);
	}
}
