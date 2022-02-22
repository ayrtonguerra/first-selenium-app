package br.com.ayrton.first_selenium_app.elements;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import br.com.ayrton.first_selenium_app.app.Resources;

public class SelectLists {
	private final String RESOURCES_PATH = Paths.get(Resources.PATH, "elements").toString();
	private final String SELECT_LIST_EXAMPLE_HTML = Paths.get(this.RESOURCES_PATH, "select-list-example.html").toString();
	
	//To use the Selenium Select class, you will need the following import statement:
	//import org.openqa.selenium.support.ui.Select;
	public void selectAndDeselectOptions() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get(SELECT_LIST_EXAMPLE_HTML);
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			
			//You are then able to create a Select object using a WebElement that references a
			// <select> element.
			WebElement selectElement = driver.findElement(By.id("selectElementID"));
			Select selectObject = new Select(selectElement);
			
			
			//There are three ways to select the first option from the above element:
			//Select an <option> based upon the <select> element's index
			selectObject.selectByIndex(0);
			Thread.sleep(500);
			
			//Select an <option> based upon its value attribute
			selectObject.selectByValue("value2");
			Thread.sleep(500);
			
			//Select an <option> based upon its text
			selectObject.selectByVisibleText("Cheese");
			Thread.sleep(500);
			
			
			//You can then check which options are selected by using:
			//Return a List<WebElement> of options that have been selected
			List<WebElement> allSelectedOptions = selectObject.getAllSelectedOptions();
			System.out.println(allSelectedOptions);
			
			//Return a WebElement referencing the first selection option found by walking
			// down the DOM
			WebElement firstSelectedOption = selectObject.getFirstSelectedOption();
			System.out.println(firstSelectedOption);
			
			
			
		} finally {
			driver.quit();
		}
	}
}






