package StepDef;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Runner.Add_to_cart_page;
import Runner.DriverFactory;
import io.cucumber.java.en.Then;

public class Add_to_cart {
	
	public WebDriver driver;
	
	
	Add_to_cart_page page=new Add_to_cart_page(DriverFactory.getdriver());
	
	
	@Then("click on two items add to cart")
	public void click_on_items_add_to_cart() throws InterruptedException {
		Thread.sleep(2000);
		page.click_two_items();
		Thread.sleep(2000);
		page.click_go_to_cart();
		
	 
	}

	@Then("check counts in viewcart option {string}")
	public void check_counts_in_viewcart_option(String string) throws InterruptedException {
		Thread.sleep(2000);
		String count=page.verifycount();
		System.out.println(count);
		System.out.println(string);
		if(count.equals(string)) {
			Assert.assertTrue(true);
			Thread.sleep(5000);
		}else {
			Assert.assertTrue(false);
		}
	}

}
