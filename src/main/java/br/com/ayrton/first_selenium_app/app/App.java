package br.com.ayrton.first_selenium_app.app;

import br.com.ayrton.first_selenium_app.browser.Windows;

public class App {
    
    public static void main(String[] args) throws Exception {
    	Windows w = new Windows();
    	w.executeScript();
    	w.printPage();
    }
    
}
