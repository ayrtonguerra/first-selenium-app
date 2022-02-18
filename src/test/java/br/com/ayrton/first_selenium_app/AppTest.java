package br.com.ayrton.first_selenium_app;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {

	@Test
	public void shouldAnswerWithTrue() {
		//assertTrue(true);
		
		this.chromeSession();
	}

	@Test
	public void chromeSession() {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.quit();
	}

}
