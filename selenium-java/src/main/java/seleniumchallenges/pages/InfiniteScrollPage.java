package seleniumchallenges.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {
	private WebDriver driver;
	
	private By paragraph = By.cssSelector(".jscroll-added");
	
	public InfiniteScrollPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void scrollToIndex(int index) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		while(driver.findElements(paragraph).size() < index) {
			js.executeScript("window.scrollBy(0, document.body.scrollHeight);");
		}
	}
}
