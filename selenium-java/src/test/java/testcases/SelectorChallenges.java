package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectorChallenges {
	private WebDriver driver;
	
	// A Annotation @BeforeTest é executada antes do testes iniciarem
	// Geralmente utilizamos esse método para realizar as configurações iniciais do teste,
	// como: configurar o WebDriver, abrir o browser, acessar a página, etc...
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://juniorerico.github.io/aubay-selenium/selectors-practice.html");
	}
	
	// A Annotation @Test identifica um teste
	// Ela é executada após o @BeforeTest. Podem existir múltiplos @Test em uma classe
	// Caso o atributo 'priority' não seja especificado, os testes serão executados 
	// na ordem que aparecem na classe
	@Test(priority = 2)
	public void challengeOne() {
		WebElement button = driver.findElement(By.cssSelector("#group-1 .btn-warning"));
		button.click();

		WebElement result = driver.findElement(By.id("result-1"));
		
		// O método 'Assert.assertEquals' verifica se dois objetos são iguais ou não
		// No caso abaixo, verificamos se o texto do elemento 'result' é igual a 'Muito bem!'
		// Isso irá indicar se o teste passou ou falhou no relatório final
		Assert.assertEquals(result.getText(), "Muito bem!");
		
		// É possível também utilizar o 'Assert.assertTrue' para verificar 
		// se uma condição é verdadeira ou falsa. O código abaixo realiza a mesma verificação
		// do código anterior, porém utilizando o método '.equals()'
		
		// Assert.assertTrue(result.getText().equals("Muito bem!"));
	}
	
	// Esse teste será executado primeiro, pois seu 'priority' é menor que o do teste anterior
	@Test(priority = 1)
	public void challengeThree() {
		WebElement button = driver.findElement(By.xpath("//div[@id='group-3']//button[text()='Botão 4']"));
		button.click();

		WebElement result = driver.findElement(By.id("result-3"));

		Assert.assertEquals(result.getText(), "Muito bem!");
	}

	// A Annotation '@AfterTest' indica que um método será executado ao final de todos os testes
	// Neste caso, após os testes, o browser será fechado.
	@AfterTest
	public void tearDown() {
		// driver.quit();
	}
}
