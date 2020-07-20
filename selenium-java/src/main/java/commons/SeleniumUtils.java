package commons;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {
	private static final int DEFAUT_TIMEOUT = 10;

	/**
	 * Tira um screenshot da tela e salva na pasta '/screenshots'
	 * 
	 * @param driver
	 * @param filename
	 */
	public static void takeScreenshot(WebDriver driver, String filename) {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String srcFolder = "C:\\Users\\Erico\\git\\aubay-selenium\\selenium-java\\screenshots\\";
		String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

		File destFile = new File(srcFolder + date + "_" + filename + ".jpg");

		try {
			FileHandler.copy(screenshot, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Aguarda até que o elemento esteja visível na tela. O tempo máximo é passado
	 * pelo parametro 'timeout'
	 * 
	 * @param driver
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public static WebElement waitForElementToBeVisible(WebDriver driver, By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 * Aguarda até que o elemento esteja visível na tela. O tempo máximo é o
	 * DEFAULT_TIMEOUT.
	 * 
	 * @param driver
	 * @param locator
	 * @return
	 */
	public static WebElement waitForElementToBeVisible(WebDriver driver, By locator) {
		return waitForElementToBeVisible(driver, locator, DEFAUT_TIMEOUT);
	}

	/**
	 * Aguarda até que o elemento seja clicáve. O tempo máximo é passado pelo
	 * parametro 'timeout'
	 * 
	 * @param driver
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public static WebElement waitForElementToBeClickable(WebDriver driver, By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	/**
	 * Aguarda até que o elemento seja clicável. O tempo máximo é o DEFAULT_TIMEOUT
	 * 
	 * @param driver
	 * @param locator
	 * @return
	 */
	public static WebElement waitForElementToBeClickable(WebDriver driver, By locator) {
		return waitForElementToBeClickable(driver, locator, DEFAUT_TIMEOUT);
	}

	/**
	 * Verifica se um elemento está visível na página, após 1 segundo.
	 * 
	 * @param driver
	 * @param locator
	 * @return
	 */
	public static boolean isElementVisible(WebDriver driver, By locator) {
		try {
			waitForElementToBeVisible(driver, locator, 1);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Posiciona o mouse sobre o elemeto
	 * 
	 * @param driver
	 * @param element
	 */
	public static void hoverElement(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.build().perform();
	}

	/**
	 * Faz a página rolar até o elemento. O topo do elemento é alinhado com o topo
	 * da página
	 * 
	 * @param driver
	 * @param element
	 */
	public static void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	/**
	 * Seleciona uma opção no dropdown pelo value
	 * 
	 * @param element
	 * @param value
	 */
	public static void selectDropDown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
	
	/**
	 * Digita em um input. Caso o 'value' esteja vazio, limpa o input
	 * 
	 * @param element
	 * @param value
	 */
	public static void sendKeys(WebElement element, String value) {
		if (value.isEmpty()) {
			element.clear();
		} else {
			element.sendKeys(value);
		}
	}
}