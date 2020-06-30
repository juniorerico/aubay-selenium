package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticingWebElements2 {
	public static void main(String[] args) {
		// Configuração do WebDriverManager
		WebDriverManager.chromedriver().setup();
		
		// Abre o browser
		WebDriver driver = new ChromeDriver();
		
		// Acessa a página desejada
		driver.get("http://the-internet.herokuapp.com/");
		
		// Encontra o link que possui o texto 'Form Authentication'
		WebElement formAuthentication = driver.findElement(By.linkText("Form Authentication"));
		
		// Clica no link
		formAuthentication.click();
		
		// Encontra o elemento que tenha o id 'username'
		WebElement usernameInput = driver.findElement(By.id("username"));
		
		// Encontra o elemento que tenha o name 'password'
		WebElement passwordInput = driver.findElement(By.name("password"));
		
		// Encontra o elemento que tenha a class 'radius'
		WebElement loginButton = driver.findElement(By.className("radius"));
		
		// Digita neste elemento
		usernameInput.sendKeys("tomsmith");
		passwordInput.sendKeys("SuperSecretPassword!");
		
		// clica no botão
		loginButton.click();
	}
}
