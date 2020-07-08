package commons;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utils {
	// Tira um screenshot da tela e salva na pasta '/screenshots'
	static public void takeScreenshot(WebDriver driver, String filename) {
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String srcFolder = "C:\\Users\\Erico\\git\\aubay-selenium\\selenium-java\\screenshots\\";
		String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		
		File destFile = new File(srcFolder + date + "_" + filename + ".jpg");
		
		try {
			FileHandler.copy(screenshot, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}