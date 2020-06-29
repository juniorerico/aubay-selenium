package learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HelloWebDriver {
	public static void main(String[] args) {
		// Propriedade exigida pelo Selenium para informar o caminho do webdriver
		// do browser que formos testar
		//System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		
		// Configura��o do WebDriverManager
		// Evita realizar o passo acima, pois ao utilizar o m�todo setup() abaixo
		// as configura��es s�o feitas automaticamente baseadas no browser instalado na m�quina
		WebDriverManager.chromedriver().setup();
		
		// Instancia o ChromeDriver, um novo browser ser� executado
		WebDriver driver = new ChromeDriver();
		
		// Maximiza o browser aberto
		driver.manage().window().maximize();
		
		// Navega at� a p�gina desejada, neste caso, o site do google
		//driver.get("http://www.google.com");
		
		// Outra maneira de executar a mesma a��o da linha acima
		driver.navigate().to("http://www.google.com");
		
		// Imprime o t�tulo da p�gina aberta
		System.out.println(driver.getTitle());
		
		// Fecha o browser
		driver.quit();
	}
}
