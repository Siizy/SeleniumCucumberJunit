package orangehr.apphooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import orangehr.factory.DriverFactory;
import orangehr.util.ConfigReader;

public class ApplicationHooks {
	
	private DriverFactory driverFractory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	@Before(order = 0)
	public void getProperty() throws IOException {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}
	
	@Before(order = 1)
	public void launchBrowser() throws Exception {		
		String browserName = prop.getProperty("browser");
		driverFractory = new DriverFactory();
		driver = driverFractory.init_driver(browserName);		
		}
	
	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			String screenShotName = scenario.getName().replaceAll("", "");
			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenShotName);
		}
	}
	
	
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}
	
	
	

}
