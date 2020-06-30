package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticingWebElementsCssXPath {
	public static void main(String[] args) {
		// Configuração do WebDriverManager
		WebDriverManager.chromedriver().setup();
		
		// Abre o browser
		WebDriver driver = new ChromeDriver();
		
		// Acessa a página desejada
		driver.get("http://the-internet.herokuapp.com/");
		
		// Encontra o link 'Form Authentication' utilizando o seletor XPath
		WebElement formAuthentication = driver.findElement(By.xpath("//a[text()='Form Authentication']"));
		
		// Clica no botão
		formAuthentication.click();
		
		// Encontra o elemento que possui o id 'username' utilizando o seletor CSS
		WebElement usernameInput = driver.findElement(By.cssSelector("#username"));
		
		// Encontra o elemento que possui o id 'password' utilizando o seletor CSS
		WebElement passwordInput = driver.findElement(By.cssSelector("#password"));
		
		// Encontra o elemento que possui a classe 'radius' utilizando o seletor CSS
		WebElement loginButton = driver.findElement(By.cssSelector(".radius"));
		
		// Digita nestes elementos
		usernameInput.sendKeys("tomsmith");
		passwordInput.sendKeys("SuperSecretPassword!");
		
		// Clica no botão
		loginButton.click();
	}
}
