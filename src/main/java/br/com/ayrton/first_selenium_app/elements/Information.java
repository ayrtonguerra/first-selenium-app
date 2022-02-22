package br.com.ayrton.first_selenium_app.elements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Information {

	
	
	//This method is used to check if the referenced Element is displayed or not 
	// on a webpage.
	public void isDisplayed() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://www.google.com.br/");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			
			//return true if element is displayed else returns false
			boolean value = driver.findElement(By.name("q")).isDisplayed();
			System.out.println("isDisplayed: " + value);
		} finally {
			driver.quit();
		}
	}
	
	//This method is used to check if the connected Element is enabled or disabled on a 
	// webpage.
	public void isEnabled() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://www.google.com.br/");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			
			//returns true if element is enabled else returns false
			boolean value = driver.findElement(By.name("q")).isEnabled();
			System.out.println("isEnabled: " + value);
		} finally {
			driver.quit();
		}
	}
	
	//This method determines if the referenced Element is Selected or not.
	//This method is widely used on Check boxes, radio buttons, input elements,
	// and option elements.
	//Returns a boolean value, True if referenced element is Selected in the current
	// browsing context else returns false.
	public void isSelected() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://the-internet.herokuapp.com/checkboxes");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			
			//returns true if element is checked else returns false
			boolean value = driver.findElement(By.cssSelector("input[type='checkbox']:first-of-type")).isSelected();
			System.out.println("isSelected: " + value);
			value = driver.findElement(By.cssSelector("input[type='checkbox']:last-of-type")).isSelected();
			System.out.println("isSelected: " + value);
			
			Thread.sleep(1000);
		} finally {
			driver.quit();
		}
	}
	
	//Is is used to fetch the TagName of the referenced Element which has the focus in the current
	// browsing context.
	public void tagName() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://www.example.com");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			
			//returns TagName of the element
			String value = driver.findElement(By.cssSelector("h1")).getTagName();
			System.out.println("TagName: " + value);
		} finally {
			driver.quit();
		}
	}
	
	//It is used to fetch the dimensions and coordinates of the referenced element.
	//The fetched data body contain the following details:
	//1. X-axis position from the top-left corner of the element
	//2. Y-axis position from the top-left corner of the element
	//3. Height of the element
	//4. Width of the element
	public void sizeAndPosition() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://www.example.com");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			
			//returns height, width, x and y coordinates referenced element
			Rectangle res = driver.findElement(By.cssSelector("h1")).getRect();
			
			// Rectangle class provides getX, getY, getWidth, getHeight methods
			System.out.println("X: " + res.getX());
			System.out.println("Y: " + res.getY());
			System.out.println("Width: " + res.getWidth());
			System.out.println("Height: " + res.getHeight());
		} finally {
			driver.quit();
		}
	}
	
	//Retrieves the value of specified computed style property of an element
	// in the current browsing context.
	public void getCssValue() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://www.example.com");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			
			//retrieves the computed style property 'color' of linktext
			String cssValue = driver.findElement(By.linkText("More information...")).getCssValue("color");
			System.out.println("Color: " + cssValue);
		} finally {
			driver.quit();
		}
	}
	
	//Retrieves the rendered text of the specified element.
	public void textContent() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://www.example.com");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			
			//Retrieves the text of the element
			String text = driver.findElement(By.cssSelector("h1")).getText();
			System.out.println("Text: " + text);
		} finally {
			driver.quit();
		}
	}
	
}
