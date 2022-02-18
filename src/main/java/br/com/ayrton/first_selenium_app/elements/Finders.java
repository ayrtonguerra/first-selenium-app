package br.com.ayrton.first_selenium_app.elements;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.ayrton.first_selenium_app.app.Resources;

public class Finders {
	private final String RESOURCES_PATH = Paths.get(Resources.PATH, "elements").toString(); 
	private final String FINDERS_EXAMPLE_HTML = Paths.get(this.RESOURCES_PATH, "finders-example.html").toString();
	
	public void evaluatingEntireDom() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get(FINDERS_EXAMPLE_HTML);
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			
			WebElement vegetable = driver.findElement(By.className("tomatoes"));
			System.out.println(vegetable);
			Thread.sleep(1000);
		} finally {
			driver.quit();
		}
	}
	
	public void evaluatingASubsetOfTheDom() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get(FINDERS_EXAMPLE_HTML);
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			
			WebElement fruits = driver.findElement(By.id("fruits"));
			WebElement fruit = fruits.findElement(By.id("tomatoes"));
			System.out.println(fruits);
			System.out.println(fruit);
		} finally {
			driver.quit();
		}
	}
	
	public void optimizedLocator() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get(FINDERS_EXAMPLE_HTML);
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			
			WebElement fruit = driver.findElement(By.cssSelector("#fruits .tomatoes"));
			System.out.println(fruit);
		} finally {
			driver.quit();
		}
	}
	
	public void allMatchingAndGetElement() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get(FINDERS_EXAMPLE_HTML);
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			
			List<WebElement> elements = driver.findElements(By.tagName("li"));
			System.out.println("List:\n" + elements + "\n");
			
			for (WebElement element : elements) {
				System.out.println("Paragraph text: " + element.getText());
			}
		} finally {
			driver.quit();
		}
	}
	
	public void findingElementsFromElement() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://example.com");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			
			//Get element with tag name 'div'
			WebElement element = driver.findElement(By.tagName("div"));
			
			//Get all the elements available with name 'p'
			List<WebElement> elements = element.findElements(By.tagName("p"));
			for (WebElement e : elements) {
				System.out.println(e.getText());
			}
			
		} finally {
			driver.quit();
		}
	}
	
	public void getActiveElement() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("http://google.com");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			driver.findElement(By.cssSelector("[name='q']")).sendKeys("webElement");
			
			//Get attibute of current active element
			String attr = driver.switchTo().activeElement().getAttribute("title");
			System.out.println(attr);
		} finally {
			driver.quit();
		}
	}
	
}
