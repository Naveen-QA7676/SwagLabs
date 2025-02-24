package Runner;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
	
	
	public WebDriver driver;
	public DriverFactory driverfactory;
	
	
	@Before(order=0)
	public void getProperty() {
		driverfactory=new DriverFactory();
		driver=driverfactory.init_driver();
		 try {
	            ExtentCucumberAdapter.addTestStepLog("Starting Scenario...");
	        } catch (Exception e) {
	            System.out.println("Extent Reports initialization failed: " + e.getMessage());
	        }
	    }
		
	
	
	@After(order=1)
	public void teardown(Scenario scenario) {
		 if (scenario.isFailed()) {
	            // Capture Screenshot on Failure
	            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	            scenario.attach(screenshot, "image/png", "Failure Screenshot");

	            try {
	                if (ExtentCucumberAdapter.getCurrentStep() != null) {
	                    ExtentCucumberAdapter.addTestStepLog("Scenario Failed: " + scenario.getName());
	                }
	            } catch (Exception e) {
	                System.out.println("Extent Reports log failed: " + e.getMessage());
	            }
	        } else {
	            try {
	                if (ExtentCucumberAdapter.getCurrentStep() != null) {
	                    ExtentCucumberAdapter.addTestStepLog("Scenario Passed: " + scenario.getName());
	                }
	            } catch (Exception e) {
	                System.out.println("Extent Reports log failed: " + e.getMessage());
	            }
	        }
		 
DriverFactory.getdriver().quit();
}
	
}
