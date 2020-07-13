package theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commons.SeleniumUtils;

public class DynamicControlsPage {
	private WebDriver driver;
	
	private By buttonEnable = By.cssSelector("#input-example button");
	private By input = By.cssSelector("#input-example input");
	
	public DynamicControlsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickEnable() {
		driver.findElement(buttonEnable).click();
	}
	
	public void typeInput(String text) {
		SeleniumUtils.waitForElementToBeClickable(driver, input).sendKeys(text);
	}
}
