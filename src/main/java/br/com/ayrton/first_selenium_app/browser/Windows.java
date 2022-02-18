package br.com.ayrton.first_selenium_app.browser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.util.Base64;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.Point;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.print.PrintOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.ayrton.first_selenium_app.app.Resources;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Windows {

	private final String RESOURCES_PATH = Paths.get(Resources.PATH, "browser").toString(); 
	private final String SCRIP_EXAMPLE_HTML = Paths.get(this.RESOURCES_PATH, "windows-script-examples.html").toString();
	private final String PRINT_EXAMPLE_PDF = Paths.get(this.RESOURCES_PATH, "printPageContent.pdf").toString();
	private final String SCREENSHOT_EXAMPLE = Paths.get(this.RESOURCES_PATH, "imageBrowser.png").toString();
	private final String ELEMENT_SCREENSHOT_EXAMPLE = Paths.get(this.RESOURCES_PATH, "imageElement.png").toString();
	
	public void getWindowHandler() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		try {
			System.out.println(driver.getWindowHandle());
		} finally {
			driver.quit();
		}
	}
	
	public void switchWindowsOrTabs() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://www.selenium.dev/documentation/webdriver/browser/windows/");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			
			//Store the ID of the original window
			String originalWindow = driver.getWindowHandle();
			
			//Check we don't have other windows open already
			assert driver.getWindowHandles().size() == 1;
			
			//Click the link which opens in a new window
			//driver.findElement(By.linkText("new window")).click();
			driver.findElement(By.linkText("new window")).click();
			
			//Wait for the new window or tab
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1500));
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			
			//Loop through until we find a new window handle
			for (String windowHandle : driver.getWindowHandles()) {
				if (!originalWindow.contentEquals(windowHandle)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}
			
			//Wait for the new tab to finish loading content
			//wait.until(ExpectedConditions.titleIs("Selenium documentation"));
			wait.until(ExpectedConditions.titleIs("Selenium"));
			
			driver.switchTo().window(originalWindow);
		} finally {
			driver.quit();
		}
	}
	
	public void createWindowOrTabAndSwitch() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			
			//Opens a new tab and switches to new tab
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get("https://www.selenium.dev/documentation/webdriver/browser/windows/");
			
			//Opens a new window and switches to new window
			driver.switchTo().newWindow(WindowType.WINDOW);
			driver.get("https://www.selenium.dev/documentation/webdriver/browser/windows/");
		} finally {
			driver.quit();
		}
	}
	
	//When you are finished with a window or tab and it is not the last
	//window or tab open in your browser, you should close it and switch
	//back to the window you were using previously.
	//You must switch back to a valid window handle in order to continue
	//execution.
	public void closingAWindowOrTab() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://www.selenium.dev/documentation/webdriver/browser/windows/");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			
			//Store the ID of the original window
			String originalWindow = driver.getWindowHandle();
			
			//Check we don't have other windows open already
			assert driver.getWindowHandles().size() == 1;
			
			//Click the link which opens in a new window
			//driver.findElement(By.linkText("new window")).click();
			driver.findElement(By.linkText("new window")).click();
			
			//Wait for the new window or tab
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1500));
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			
			//Loop through until we find a new window handle
			for (String windowHandle : driver.getWindowHandles()) {
				if (!originalWindow.contentEquals(windowHandle)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}
			
			//Wait for the new tab to finish loading content
			//wait.until(ExpectedConditions.titleIs("Selenium documentation"));
			wait.until(ExpectedConditions.titleIs("Selenium"));
			
			//Close the tab or window
			driver.close();
			
			//Switch back to the old tab or window
			driver.switchTo().window(originalWindow);
			
			driver.get("https://www.google.com.br/");
		} finally {
			driver.quit();
		}
	}
	
	//driver.quit();
	//Quit will:
	//1. Close all the windows and tabs associated with that WebDriver session
	//2. Close the browser process
	//3. Close the background driver process
	//4. Notify Selenium Grid that the browser is no longer in use so it can be
	//used by another session (if you are using Selenium Grid)
	//
	//Some test framework offer methods and annotations which you can hook into
	//to tear down at the end of a test.
	//@AfterAll
	//public static void tearDown(){
	//	driver.quit();
	//}
	//
	//If not runnig WebDriver in a test context, you may consider using try/finally
	//which is offered by most languages so that an exception will still clean up the
	//WebDriver session.
	//try {
	//	//WebDriver code here...
	//} finally {
	//	driver.quit();
	//}
	public void quitingTheBrowserAtEndOfSession() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://www.selenium.dev/documentation/webdriver/browser/windows/");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		} finally {
			driver.quit();
		}
	}
	
	/* Window management */
	public void getWindowSize() {
		WebDriver driver = new ChromeDriver();
		try {
			//Access each dimension individually
			int width = driver.manage().window().getSize().getWidth();
			int height = driver.manage().window().getSize().getHeight();
			
			//Or store the dimensions and query them later
			Dimension size = driver.manage().window().getSize();
			int width1 = size.getWidth();
			int height1 = size.getHeight();
			
			System.out.println(width);
			System.out.println(height);
			System.out.println(width1);
			System.out.println(height1);
		} finally {
			driver.quit();
		}
	}
	
	public void setWindowSize() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://www.selenium.dev/documentation/webdriver/browser/windows/");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			driver.manage().window().setSize(new Dimension(1300, 500));
			driver.get("https://www.selenium.dev/documentation/webdriver/browser/windows/");
		} finally {
			driver.quit();
		}
	}
	
	public void getWindowPosition() {
		WebDriver driver = new ChromeDriver();
		try {
			//Access each dimension individually
			int x = driver.manage().window().getPosition().getX();
			int y = driver.manage().window().getPosition().getY();
			
			//Or store the dimensions and query them later
			Point position = driver.manage().window().getPosition();
			int x1 = position.getX();
			int y1 = position.getY();
			
			System.out.println(x);
			System.out.println(y);
			System.out.println(x1);
			System.out.println(y1);
		} finally {
			driver.quit();
		}
	}
	
	public void setWindowPosition() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://www.selenium.dev/documentation/webdriver/browser/windows/");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			driver.manage().window().setPosition(new Point(0,0));
			//driver.get("https://www.selenium.dev/documentation/webdriver/browser/windows/");
			driver.navigate().refresh();
		} finally {
			driver.quit();
		}
	}
	
	public void maximizeWindow() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://www.selenium.dev/documentation/webdriver/browser/windows/");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			driver.manage().window().maximize();
			//driver.get("https://www.selenium.dev/documentation/webdriver/browser/windows/");
			driver.navigate().refresh();
		} finally {
			driver.quit();
		}
	}
	
	//This feature works with Selenium 4 and later versions.
	public void minimizeWindow() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://www.selenium.dev/documentation/webdriver/browser/windows/");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			driver.manage().window().minimize();
			//driver.get("https://www.selenium.dev/documentation/webdriver/browser/windows/");
			driver.navigate().refresh();
		} finally {
			driver.quit();
		}
	}
	
	public void fullscreenWindow() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://www.selenium.dev/documentation/webdriver/browser/windows/");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			driver.manage().window().fullscreen();
			driver.navigate().refresh();
		} finally {
			driver.quit();
		}
	}
	
	public void takeScreenshot() throws IOException {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("http://example.com");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(SCREENSHOT_EXAMPLE));
		} finally {
			driver.quit();
		}
	}
	
	public void takeElementScreenshot() throws IOException {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("http://example.com");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			WebElement element = driver.findElement(By.cssSelector("h1"));
			File scrFile = element.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(ELEMENT_SCREENSHOT_EXAMPLE));
		} finally {
			driver.quit();
		}
	}
	
	public void executeScript() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get(SCRIP_EXAMPLE_HTML);
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			WebElement loginField = driver.findElement(By.name("login"));
			WebElement passwordField = driver.findElement(By.name("pass"));
			loginField.sendKeys("test@gmail.com");
			passwordField.sendKeys("1234");
			
			//Creating the JavascriptExecutor interface object by Type casting
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			//Button Element
			WebElement button = driver.findElement(By.name("btnLogin"));
			
			//Executing JavaScript to click on element
			js.executeScript("arguments[0].click()", button);
			
			//Get return value from script
			String text = (String) js.executeScript("return arguments[0].innerText", button);
			System.out.println("Text: " + text);
			
			//Executing JavaScript directly
			js.executeScript("console.log('hello world')");
			
		} finally {
			driver.quit();
		}
	}
	
	public void printPage() throws IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		WebDriver driver = new ChromeDriver(options);
		try {
			driver.get("https://www.selenium.dev");
			//driver.get("https://www.selenium.dev/documentation/webdriver/browser/windows/");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			PrintsPage printer = (PrintsPage) driver;
			
			PrintOptions printOptions = new PrintOptions();
			printOptions.setPageRanges("1-2");
			
			Pdf pdf = printer.print(printOptions);
			String content = pdf.getContent();
			System.out.println(content);
			
			byte[] bytes = Base64.getDecoder().decode(content);
			
			String dir = PRINT_EXAMPLE_PDF;
			Path path = Paths.get(dir);
			File file = path.toFile();
			if (!file.exists()) {
				Files.createFile(path);
			} else {
				Files.delete(path);
			}
			Files.write(path, bytes, StandardOpenOption.CREATE);
		} finally {
			driver.quit();
		}
	}
	
}
