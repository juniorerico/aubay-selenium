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
		// Aguarda at� que alguma condi��o aconte�a. Nesse caso, aguarda que o elemento esteja vis�vel
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(result));
		
		// Hard Wait
		// A pior maneira de utilizar Waits no Selenium
		// Esta solu��o faz com que a execu��o do Java pare por um tempo antes de continuar
		// N�o � recomendado, pois aumenta o tempo de execu��o do teste
//		try {
//			Thread.sleep(6000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		return driver.findElement(result).getText();
	}
}
