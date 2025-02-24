package Runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Add_to_cart_page {
	
	
	public WebDriver ldriver;
	
	public Add_to_cart_page(WebDriver driver) {
		ldriver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']")
	@CacheLookup
	private WebElement addToCart1;
	
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
	@CacheLookup
	private WebElement addToCart2;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']") 
	@CacheLookup 
	private WebElement addtocart;
	
	
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	@CacheLookup
	private WebElement count;
	
	
	
	
	public void click_two_items() {
		addToCart1.click();
		System.out.println("clicked first item");
		addToCart2.click();
		System.out.println("clicked second item");
	}
	
	public void click_go_to_cart() {
		addtocart.click();
	
		System.out.println("clicked addtocart option");
	}
	
	public String verifycount() {
		String countString=count.getText();
		System.out.println(countString);
		return countString;
	}
	
	
	
	
	
	
	
	
	

}
