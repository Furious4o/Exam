package bg.pragmatic.Exam.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {

	public static WebDriver driver;

	public static void init(String kindOfBrowser) {
		switch(kindOfBrowser.toUpperCase()){
		case "CHROME":
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		break;
		
		
		case "FIREFOX":
			System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		break;	
			
		case "IE":
			System.setProperty("webdriver.ie.driver", "C:\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		
		}
	}

	public static void quit() {
		driver.quit();
		
	}
	
	
	
	
	
	
}
