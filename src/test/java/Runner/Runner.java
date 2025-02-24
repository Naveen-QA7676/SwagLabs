package Runner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features={"Features\\Login.feature"},
glue= {"StepDef","Runner"},
tags="@Filterfuncationality",
monochrome=true,
plugin= {"pretty",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)

public class Runner extends AbstractTestNGCucumberTests{
	
	private static ThreadLocal<String> browsername=new ThreadLocal<String>();
	
	
	@BeforeClass
	@Parameters({"browser"})
	public void setBrowser(String browser) {
		browsername.set(browser);
	}
	
	
	public static String getbrowser() {
		return browsername.get();
	}

}
