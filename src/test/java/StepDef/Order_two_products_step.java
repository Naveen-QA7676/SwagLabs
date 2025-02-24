package StepDef;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Pages.orderPage;
import Runner.DriverFactory;
import io.cucumber.java.en.Then;

public class Order_two_products_step{
	
	
	public WebDriver driver;
	orderPage page=new orderPage(DriverFactory.getdriver());
	
	@Then("click on checkout option")
	public void click_on_checkout_option() throws InterruptedException {
		Thread.sleep(2000);
	   page.click_on_checkout();
	   System.out.println("clicked on checkout button");
	}

	@Then("enter the details {string} {string} {string}")
	public void enter_the_details(String string, String string2, String string3) throws InterruptedException {
		Thread.sleep(2000);
		page.enter_dtls(string, string2, string3);
		System.out.println("entered dtls");
			
	}
	@Then("click on continue button")
	public void click_on_continue_button() throws InterruptedException {
		Thread.sleep(2000);
	    page.click_on_continuebutton();
	    System.out.println("clicked on continue button");
	}

	@Then("verify the total amount")
	public void verify_the_total_amount() throws InterruptedException {
		Thread.sleep(2000);
	   float firstProdAmt=page.get_fist_product_amt();
	   System.out.println("first product amout:" + firstProdAmt);
	   float SecProdAmt=page.get_second_product_amt();
	   System.out.println("second product amount:" + SecProdAmt);
	   float ItemAmt=page.get_item_amt();
	   System.out.println("item amount shown below:" + ItemAmt);
	   float TaxAmt=page.get_tax_amt();
	   System.out.println("tax amount shown below:" + TaxAmt);
	   float TotalAmt=page.get_total_amt();
	   System.out.println("total amount shown below:" + TotalAmt);
	   
	   float totalprodamt=firstProdAmt+SecProdAmt;
	   System.out.println("total amount calculated based on first and second product:" + totalprodamt);
	  
	   float verifytotalamt=totalprodamt+TaxAmt;
	   System.out.println("total amount calculated based on first and second product with tax:" + verifytotalamt);
	   if(verifytotalamt==TotalAmt) {
		   Assert.assertTrue(true);
		   System.out.println("amount matched");
	   }else
	   {
		   Assert.assertTrue(false);
		   System.out.println("amount doesn't matched");
	   }
	   
	}

	@Then("click on the finish button")
	public void click_on_the_finish_button() throws InterruptedException {
		Thread.sleep(2000);
		page.click_on_finish();
		Thread.sleep(2000);
		String header=page.get_header();
		System.out.println(header);
		String bottomheader=page.get_bottomheader();
		System.out.println(bottomheader);
		
		if(header.equals("Thank you for your order!")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}


}
