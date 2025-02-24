package StepDef;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Pages.LoginPage;
import Runner.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {
	
	public WebDriver driver;
	LoginPage loginpage=new LoginPage(DriverFactory.getdriver());
	
	@Given("open the url")
	public void open_the_url() {
		
		DriverFactory.getdriver();
		DriverFactory.getdriver().get("https://www.saucedemo.com/");
		
	 
	}

	@When("Enter the username and password {string} {string}")
	public void enter_the_username_and_password(String string, String string2) throws InterruptedException {
		Thread.sleep(5000);
	    loginpage.enter_username_and_password(string, string2);
	}

	@Then("Click on the login button")
	public void click_on_the_login_button() throws InterruptedException {
		Thread.sleep(5000);
	   loginpage.click_on_login();
	}
	@Then("verify the msg {string}")
	public void verify_the_msg(String string) throws InterruptedException {
		Thread.sleep(5000);
	System.out.println(string);
		if(string.equals("Epic sadface: Username and password do not match any user in this service")) {
			String expderro=loginpage.verify_err_msg();
			System.out.println(expderro);
			   String actualerrmsg= string;
			   System.out.println(actualerrmsg);
			   if(expderro.equals(actualerrmsg)) {
				   Assert.assertTrue(true);
			   }
			   else {
				   Assert.assertTrue(false);
			   }
		}
		if(string.endsWith("Swag Labs")) {
			System.out.println(string);
			String expdtitle=loginpage.gettile();
			System.out.println(expdtitle);
			
			String actualtitle=string;
			System.out.println(actualtitle);
			
			if(expdtitle.equals(actualtitle)) {
				Assert.assertTrue(true);
				Thread.sleep(5000);
			} else {
				   Assert.assertTrue(false);
			   }
		}
	   
	     
	}

}
