package theinternet.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.SeleniumUtils;

public class DynamicLoadingPageExampleOne {
	private WebDriver driver;
	
	private By startButton = By.cssSelector("#start button");
	private By result = By.cssSelector("#finish h4");
	
	public DynamicLoadingPageExampleOne(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickStartButton(){
		driver.findElement(startButton).click();
	}
	
	public String getResult() {
		// Explicity Wait
		// A melhor maneira de utilizar Waits no Selenium
		// Aguarda at� que alguma condi��o aconte�a. Nesse caso, aguarda que o elemento esteja vis�vel
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(result));
		
		// Hard Wait
		// A pior maneira de utilizar Waits no Selenium
		// Esta solu��o faz com que a execu��o do Java pare por um tempo antes de continuar
		// N�o � recomendado, pois aumenta o tempo de execu��o do teste
//		try {
//			Thread.sleep(6000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		// Fluent Wait
		// Uma maneira mais configur�vel de utilizar Waits no Selenium
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//				.withTimeout(Duration.ofSeconds(10))
//				.pollingEvery(Duration.ofSeconds(1))
//				.ignoring(Exception.class);
//		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(result));
		
		return SeleniumUtils.waitForElementToBeVisible(driver, result, 5).getText();
	}
}
