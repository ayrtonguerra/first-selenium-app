package br.com.ayrton.first_selenium_app.elements;

import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.ayrton.first_selenium_app.app.Resources;

public class Interactions {
	private final String RESOURCES_PATH = Paths.get(Resources.PATH, "elements").toString(); 
	private final String SENDKEYS_EXAMPLE_HTML = Paths.get(this.RESOURCES_PATH, "sendkeys-example.html").toString();
	
	//The element click command is executed on the center of the element. If the center
	// of the element is obscured for some reason, Selenium will return an element click
	// intercepted error.
	public void click() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://www.google.com.br/");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			driver.findElement(By.cssSelector("[name='q']")).sendKeys("webElement");
			
			//Click on the search button
			driver.findElement(By.name("btnK")).click();
		} finally {
			driver.quit();
		}
	}
	
	//The element send keys command types the provided keys into an editable element.
	//Typically, this means an element is an input element of a form with a text type
	// or an element with a content-editable attribute. If it is not editable, an
	// invalid element state error is returned.
	public void sendKeys() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://www.google.com.br/");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			
			//Enter text "q" and perform keyboard action "Enter"
			driver.findElement(By.name("q")).sendKeys("q" + Keys.ENTER);
		} finally {
			driver.quit();
		}
	}
	
	public void sendKeysText() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get(SENDKEYS_EXAMPLE_HTML);
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			Thread.sleep(1000);
			
			//Enter text "It's a test"
			driver.findElement(By.id("pEditable")).sendKeys(Keys.CONTROL + "a" + Keys.CONTROL + "It's a test");
			Thread.sleep(1000);
		} finally {
			driver.quit();
		}
	}
	
	//The element clear command resets the content of an element. This requires
	// an element to be editable, and resettable. Typically, this means an element
	// is an input element of a form with a text type or an element with a content-editable
	// attribute. If these conditions are not met, an invalid element state error is returned.
	public void clear() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://www.google.com.br/");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			
			//Store 'SearchInput' element
			WebElement searchInput = driver.findElement(By.name("q"));
			searchInput.sendKeys("selenium");
			
			//Clears the entered text
			searchInput.clear();
			
			Thread.sleep(500);
		} finally {
			driver.quit();
		}
	}
	
	//In Selenium 4 this is no longer implemented with a separate endpoint and functions
	// by executing a script. As such, it is recommended not to use this method an to 
	// click the applicable form submission button instead.
	public void submit() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://www.google.com.br/");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			
			//Store 'SearchInput' element
			WebElement searchInput = driver.findElement(By.name("q"));
			searchInput.sendKeys("selenium");
			
			//Clears the entered text
			searchInput.submit();
		} finally {
			driver.quit();
		}
	}
	
}
