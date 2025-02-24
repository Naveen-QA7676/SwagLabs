package Runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tldriver=new ThreadLocal<WebDriver>();
	
	
	public WebDriver init_driver() {
		String browsername=Runner.getbrowser();
		
		switch(browsername.toLowerCase()) {
		case "firefox":
			tldriver.set(new FirefoxDriver());
			break;
			
		case "chrome":
			tldriver.set(new ChromeDriver());
			break;
			
		case "edge":
			tldriver.set(new EdgeDriver());
			break;
			
		}
		
		getdriver().manage().window().maximize();
		getdriver().manage().deleteAllCookies();
		return getdriver();
		
		
	}
	

	
	public static WebDriver getdriver() {
		return tldriver.get();
	}
}
