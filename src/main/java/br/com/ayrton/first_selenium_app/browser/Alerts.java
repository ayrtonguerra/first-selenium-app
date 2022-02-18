package br.com.ayrton.first_selenium_app.browser;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	public void alert() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.selenium.dev/documentation/webdriver/browser/alerts/");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

		// Click the link to activate the alert
		driver.findElement(By.linkText("See an example alert")).click();

		// Wati for the alert to be displayed and store in a variable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1500));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());

		// Store the alert text in a variable
		String text = alert.getText();
		System.out.println(text);

		// Press the OK button
		alert.accept();
		
    	driver.quit();
	}

	public void confirm() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.selenium.dev/documentation/webdriver/browser/alerts/");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

		// Click the link to activate the alert
		driver.findElement(By.linkText("See a sample confirm")).click();

		// Wati for the alert to be displayed and store in a variable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1500));
		wait.until(ExpectedConditions.alertIsPresent());

		// Store the alert in a variable
		Alert alert = driver.switchTo().alert();

		// Store the alert text in a variable for reuse
		String text = alert.getText();
		System.out.println(text);

		// Press the Cancel button
		alert.dismiss();
		
    	driver.quit();
	}

	public void prompt() {
		//WebDriverManager.chromedriver().setup();
		//ChromeOptions options = new ChromeOptions();
		
		WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();
		WebDriver driver = new EdgeDriver(options);
		//WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.selenium.dev/documentation/webdriver/browser/alerts/");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

		// Click the link to activate the alert
		driver.findElement(By.linkText("See a sample prompt")).click();

		// Wati for the alert to be displayed and store in a variable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1500));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());

		// Type your message
		alert.sendKeys("Selenium");

		// Press the OK button
		alert.accept();
		
    	driver.quit();
	}

}
