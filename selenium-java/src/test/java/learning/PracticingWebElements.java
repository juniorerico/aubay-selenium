package learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticingWebElements {	
	public static void main(String[] args) {
		// Configuração do WebDriverManager
		WebDriverManager.chromedriver().setup();
		
		// Abre o chrome
		WebDriver driver = new ChromeDriver();
		
		// abre a página desejada
		driver.get("http://the-internet.herokuapp.com/");
		
		// Encontra todos os elementos que possuem a tag 'a' (ou seja, todos os links)
		// Obs: o métodos 'findElements' retorna uma lista de element List<WebElement>
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		// Imprime o tamanho da lista (a quantidade de links presentes na página)
		System.out.println(links.size());
		
		// Encontra o elemento que possui o text 'Form Authentication' dentro do link
		WebElement formAuthentication = driver.findElement(By.linkText("Form Authentication"));
		
		// clica no elemento
		formAuthentication.click();
	}
}
