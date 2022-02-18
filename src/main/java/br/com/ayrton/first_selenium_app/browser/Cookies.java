package br.com.ayrton.first_selenium_app.browser;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cookies {

	//You need to be on the domain that the cookie will be valid for.
	//If you are trying to preset cookies before you start interacting with a site
	//and your homepage is large / takes a while to load an alternative is to find
	//a smaller page on the site (tipically the 404 page is small, e.g. http://example.com/some404page)
	public void add() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("http://www.example.com");
			
			//Adds the cookie into current browser context
			driver.manage().addCookie(new Cookie("key", "value"));
		} finally {
			driver.quit();
		}
	}
	
	public void getCookieNamed() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("http://www.example.com");
			driver.manage().addCookie(new Cookie("foo", "bar"));
			
			//Get cookie details with named cookie 'foo'
			Cookie cookie1 = driver.manage().getCookieNamed("foo");
			System.out.println(cookie1);
		} finally {
			driver.quit();
		}
	}
	
	public void getAllCookies() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("http://www.example.com");
			//Add few cookies
			driver.manage().addCookie(new Cookie("test1", "cookie1"));
			driver.manage().addCookie(new Cookie("test2", "cookie2"));
			
			//Get All avaliable cookies
			Set<Cookie> cookies = driver.manage().getCookies();
			System.out.println(cookies);
		} finally {
			driver.quit();
		}
	}
	
	public void deleteCookieNamed() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("http://www.example.com");
			//Add few cookies
			driver.manage().addCookie(new Cookie("test1", "cookie1"));
			Cookie cookie1 = new Cookie("test2", "cookie2");
			driver.manage().addCookie(cookie1);
			
			//Delete a cookie with name 'test1'
			driver.manage().deleteCookieNamed("test1");
			
			/*
			 Selenium Java bindings also provides a way to delete
			 cookie by passing cookie object of current browsing context
			 */
			driver.manage().deleteCookie(cookie1);
		} finally {
			driver.quit();
		}
	}
	
	public void deleteAllCookies() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("http://www.example.com");
			//Add few cookies
			driver.manage().addCookie(new Cookie("test1", "cookie1"));
			driver.manage().addCookie(new Cookie("test2", "cookie2"));
			
			//Deletes all cookies
			driver.manage().deleteAllCookies();
		} finally {
			driver.quit();
		}
	}
	
	//As of now this feature is landed in chrome (80+ version), Firefox (79+ version) and works with Selenium 4 and later versions.
	public void sameSiteCookie() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("http://www.example.com");
			//When the sameSite attribute is set as Strict, the cookie will not be sent along with requests initiated by third party websites.
			Cookie cookie = new Cookie.Builder("key", "value").sameSite("Strict").build();
			//When you set a cookie sameSite attribute to Lax, the cookie will be sent along with the GET request initiated by third party website.
			Cookie cookie1 = new Cookie.Builder("key", "value").sameSite("Lax").build();
			driver.manage().addCookie(cookie);
			driver.manage().addCookie(cookie1);
			System.out.println(cookie.getSameSite());
			System.out.println(cookie1.getSameSite());
		} finally {
			driver.quit();
		}
	}
	
}
