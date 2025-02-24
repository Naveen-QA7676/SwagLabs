package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Runner.DriverFactory;

public class LoginPage {
	public WebDriver ldriver;
	public LoginPage(WebDriver driver) {
		ldriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	

	
	@FindBy(xpath="//input[@id='user-name']") 
	@CacheLookup 
	private WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	@CacheLookup 
	private WebElement password;
	
	@FindBy(xpath="//input[@id='login-button']") 
	@CacheLookup 
	private WebElement loginbutton;
	
	@FindBy(xpath="//h3[contains(text(),'Epic sadface: Username and password do not match a')]")
	@CacheLookup 
	private WebElement erromsg;
	

	
	
	
	
	
	public void enter_username_and_password(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		
	}
	
	
	public void click_on_login() {
		loginbutton.click();
	}
	
	public String verify_err_msg() {
		String errormsg=erromsg.getText();
		return errormsg;
		
		
	}
	
	
	public String gettile() {
		String title=DriverFactory.getdriver().getTitle();
		return title;
	}
}
