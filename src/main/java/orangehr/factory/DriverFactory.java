package orangehr.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverFactory {
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	public WebDriver init_driver(String browser) throws Exception {
        switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
			break;

		default:			
			throw new Exception("Please provide a valid driver");
		}
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

}
