package AppHooks;

import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.ConfigReader;
import com.qa.factory.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	private DriverFactory driverFactory;
	private ConfigReader configReader;
	private WebDriver driver;
	Properties prop;
	
	
	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		
	}
	
	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
	}
	
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
		
	}
	
	@After(order = 1)
	public void teardown(Scenario scenario) {
		
		if(scenario.isFailed()) {
			//take screenshot
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,550)", "");
			byte[] sourcepath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			
			scenario.attach(sourcepath, "image/png", screenshotName);
		}
	}
	
	
	
}
