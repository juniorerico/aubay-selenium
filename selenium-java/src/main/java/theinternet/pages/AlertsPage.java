package theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {
	private WebDriver driver;
	
	private By buttonJSAlert = By.xpath("//button[text()='Click for JS Alert']");
	
	private By result = By.id("result");
	
	public AlertsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickButtonJsAlert() {
		driver.findElement(buttonJSAlert).click();
	}
	
	public String getResult() {
		return driver.findElement(result).getText();
	}
}
