package learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HelloWebDriver {
	public static void main(String[] args) {
		// Propriedade exigida pelo Selenium para informar o caminho do webdriver
		// do browser que formos testar
		//System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		
		// Configuração do WebDriverManager
		// Evita realizar o passo acima, pois ao utilizar o método setup() abaixo
		// as configurações são feitas automaticamente baseadas no browser instalado na máquina
		WebDriverManager.chromedriver().setup();
		
		// Instancia o ChromeDriver, um novo browser será executado
		WebDriver driver = new ChromeDriver();
		
		// Maximiza o browser aberto
		driver.manage().window().maximize();
		
		// Navega até a página desejada, neste caso, o site do google
		//driver.get("http://www.google.com");
		
		// Outra maneira de executar a mesma ação da linha acima
		driver.navigate().to("http://www.google.com");
		
		// Imprime o título da página aberta
		System.out.println(driver.getTitle());
		
		// Fecha o browser
		driver.quit();
	}
}
