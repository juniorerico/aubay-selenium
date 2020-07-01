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
	
	// A Annotation @BeforeTest � executada antes do testes iniciarem
	// Geralmente utilizamos esse m�todo para realizar as configura��es iniciais do teste,
	// como: configurar o WebDriver, abrir o browser, acessar a p�gina, etc...
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://juniorerico.github.io/aubay-selenium/selectors-practice.html");
	}
	
	// A Annotation @Test identifica um teste
	// Ela � executada ap�s o @BeforeTest. Podem existir m�ltiplos @Test em uma classe
	// Caso o atributo 'priority' n�o seja especificado, os testes ser�o executados 
	// na ordem que aparecem na classe
	@Test(priority = 2)
	public void challengeOne() {
		WebElement button = driver.findElement(By.cssSelector("#group-1 .btn-warning"));
		button.click();

		WebElement result = driver.findElement(By.id("result-1"));
		
		// O m�todo 'Assert.assertEquals' verifica se dois objetos s�o iguais ou n�o
		// No caso abaixo, verificamos se o texto do elemento 'result' � igual a 'Muito bem!'
		// Isso ir� indicar se o teste passou ou falhou no relat�rio final
		Assert.assertEquals(result.getText(), "Muito bem!");
		
		// � poss�vel tamb�m utilizar o 'Assert.assertTrue' para verificar 
		// se uma condi��o � verdadeira ou falsa. O c�digo abaixo realiza a mesma verifica��o
		// do c�digo anterior, por�m utilizando o m�todo '.equals()'
		
		// Assert.assertTrue(result.getText().equals("Muito bem!"));
	}
	
	// Esse teste ser� executado primeiro, pois seu 'priority' � menor que o do teste anterior
	@Test(priority = 1)
	public void challengeThree() {
		WebElement button = driver.findElement(By.xpath("//div[@id='group-3']//button[text()='Bot�o 4']"));
		button.click();

		WebElement result = driver.findElement(By.id("result-3"));

		Assert.assertEquals(result.getText(), "Muito bem!");
	}

	// A Annotation '@AfterTest' indica que um m�todo ser� executado ao final de todos os testes
	// Neste caso, ap�s os testes, o browser ser� fechado.
	@AfterTest
	public void tearDown() {
		// driver.quit();
	}
}
