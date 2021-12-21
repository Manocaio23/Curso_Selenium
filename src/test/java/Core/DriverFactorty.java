package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactorty {
 private static  WebDriver driver; 
 private DriverFactorty() {
	
}
 
 public static WebDriver GetDriver() {
	if (driver==null) {
		 System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
	}
	
		return driver;
		
		
 }
 
 public static void killDriver() {
	 if (driver!=null) {
		 driver.quit();
		 driver=null;
	}
	
 }
}
