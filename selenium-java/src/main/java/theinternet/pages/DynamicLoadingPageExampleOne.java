package theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		// Aguarda até que alguma condição aconteça. Nesse caso, aguarda que o elemento esteja visível
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(result));
		
		// Hard Wait
		// A pior maneira de utilizar Waits no Selenium
		// Esta solução faz com que a execução do Java pare por um tempo antes de continuar
		// Não é recomendado, pois aumenta o tempo de execução do teste
//		try {
//			Thread.sleep(6000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		return driver.findElement(result).getText();
	}
}
