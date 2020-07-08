package seleniumchallenges.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IFramePage {
	private WebDriver driver;
	
	private By iframe = By.cssSelector("iframe");
	private By buttonYellowGroupOne = By.cssSelector("#group-1 .btn-warning");
	private By resultGroupOne = By.id("result-1");
	
	public IFramePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void switchToIframe() {
		driver.switchTo().frame(driver.findElement(iframe));
	}
	
	public void switchToDefault() {
		driver.switchTo().defaultContent();
	}
	
	public void clickButtonYellowGroupOne() {
		driver.findElement(buttonYellowGroupOne).click();
	}
	
	public String getResultOne() {
		return driver.findElement(resultGroupOne).getText();
	}
}
