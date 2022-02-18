package br.com.ayrton.first_selenium_app.gettingStarted;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstScript {

	public void firstExample() {
    	WebDriverManager.chromedriver().setup();
    	ChromeOptions options = new ChromeOptions();
    	WebDriver driver = new ChromeDriver(options);    	
    	
    	driver.get("https://www.google.com.br/");
    	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    	
    	WebElement searchBox = driver.findElement(By.name("q"));
    	WebElement searchButton = driver.findElement(By.name("btnK"));
    	
    	searchBox.sendKeys("Selenium");
    	searchButton.click();
    	
    	searchBox = driver.findElement(By.name("q"));
    	
    	driver.quit();
    }
	
}
