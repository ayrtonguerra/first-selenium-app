package br.com.ayrton.first_selenium_app.elements;

import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.ayrton.first_selenium_app.app.Resources;

public class Locators {

	private final String RESOURCES_PATH = Paths.get(Resources.PATH, "elements").toString(); 
	private final String LOCATOR_EXAMPLE_HTML = Paths.get(this.RESOURCES_PATH, "locators-example.html").toString();
	
	/* Relative Locators */
	/* Acima */
	public void above() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get(LOCATOR_EXAMPLE_HTML);
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			
			By locator = RelativeLocator.with(By.tagName("input")).above(By.id("password"));
			driver.findElement(locator).sendKeys("email@email.com");
			Thread.sleep(1000);
		} finally {
			driver.quit();
		}
	}
	
	/* Abaixo */
	public void below() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get(LOCATOR_EXAMPLE_HTML);
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			
			By locator = RelativeLocator.with(By.tagName("input")).below(By.id("email"));
			driver.findElement(locator).sendKeys("1234");
			Thread.sleep(1000);
		} finally {
			driver.quit();
		}
	}
	
	/* À esquerda */
	public void toLeftOf() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get(LOCATOR_EXAMPLE_HTML);
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			driver.findElement(By.id("email")).sendKeys("email@email.com");
			driver.findElement(By.id("password")).sendKeys("1234");
			Thread.sleep(1000);
			
			By locator = RelativeLocator.with(By.tagName("button")).toLeftOf(By.id("submit"));
			driver.findElement(locator).click();
			Thread.sleep(1000);
		} finally {
			driver.quit();
		}
	}
	
	/* À direita */
	public void toRightOf() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get(LOCATOR_EXAMPLE_HTML);
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			driver.findElement(By.id("email")).sendKeys("email@email.com");
			driver.findElement(By.id("password")).sendKeys("1234");
			Thread.sleep(1000);
			
			By locator = RelativeLocator.with(By.tagName("button")).toRightOf(By.id("cancel"));
			driver.findElement(locator).click();
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Thread.sleep(1000);
		} finally {
			driver.quit();
		}
	}
	
	/* Por perto */
	public void near() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get(LOCATOR_EXAMPLE_HTML);
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			
			By locator = RelativeLocator.with(By.tagName("input")).near(By.id("lbl-email"));
			driver.findElement(locator).click();
			
			Thread.sleep(1000);
		} finally {
			driver.quit();
		}
	}
	
	/* Encadeando localizadores relativos */
	public void chainingRelativeLocators() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get(LOCATOR_EXAMPLE_HTML);
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			
			By locator = RelativeLocator.with(By.tagName("button")).below(By.id("email")).toRightOf(By.id("cancel"));
			driver.findElement(locator).click();
			
			Thread.sleep(1000);
		} finally {
			driver.quit();
		}
	}
	
}
