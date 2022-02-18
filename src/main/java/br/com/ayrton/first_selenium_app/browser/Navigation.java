package br.com.ayrton.first_selenium_app.browser;

import org.openqa.selenium.WebDriver;

public class Navigation {

	//Convenient
	public void to(WebDriver driver, String url) {
		driver.get(url);
	}
	
	//Longer way
	public void toNavigate(WebDriver driver, String url) {
		driver.navigate().to(url);
	}
	
	public void back(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void forward(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}

}
