package br.com.ayrton.first_selenium_app.browser;

import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.ayrton.first_selenium_app.app.Resources;

public class Frames {

	private final String RESOURCES_PATH = Paths.get(Resources.PATH, "browser").toString(); 
	private final String FRAME_EXAMPLE_HTML = Paths.get(this.RESOURCES_PATH, "frame-example.html").toString();
	
	//The most flexible option
	public void usingWebElement() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get(FRAME_EXAMPLE_HTML);
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			
			//Store the web element
			WebElement iframe = driver.findElement(By.cssSelector("#modal>iframe"));
			
			//Switch to the frame
			driver.switchTo().frame(iframe);
			
			//Now we can clink the button
			//driver.findElement(By.tagName("button")).click();
			driver.findElement(By.cssSelector("button.close")).click(); //Closing the message about Log4j Vulnerability
		} finally {
			driver.quit();
		}
	}
	
	//If your frame has an id or name attribute, this can be used instead. If the name or ID is not unique on the page, then the first one found will be switched to.
	public void usingNameOrId() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get(FRAME_EXAMPLE_HTML);
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			
			//Using the ID
			//driver.switchTo().frame("buttonframe");
			
			//Or using the name instead
			driver.switchTo().frame("myframe");
			
			//Now we can clink the button
			driver.findElement(By.cssSelector("button.close")).click(); //Closing the message about Log4j Vulnerability
		} finally {
			driver.quit();
		}
	}
	
	public void usingAnIndex() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get(FRAME_EXAMPLE_HTML);
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			
			//Switches to the first frame
			driver.switchTo().frame(0);
			
			//Now we can clink the button
			driver.findElement(By.cssSelector("button.close")).click(); //Closing the message about Log4j Vulnerability
		} finally {
			driver.quit();
		}
	}
	
	public void leavingFrame() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get(FRAME_EXAMPLE_HTML);
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			
			//Switches to the first frame
			driver.switchTo().frame(0);
			
			//Now we can clink the button
			driver.findElement(By.cssSelector("button.close")).click(); //Closing the message about Log4j Vulnerability
			
			//Return to the top level
			driver.switchTo().defaultContent();
			
			driver.findElement(By.name("message")).sendKeys("Ok!");
		} finally {
			driver.quit();
		}
	}
	
}
