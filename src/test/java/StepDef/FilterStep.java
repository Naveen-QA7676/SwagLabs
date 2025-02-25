package StepDef;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSourceType;

import Pages.FilterPage;
import Runner.DriverFactory;
import io.cucumber.java.en.Then;

public class FilterStep {
	
	
	public WebDriver driver;
	FilterPage page=new FilterPage(DriverFactory.getdriver());
	String[] str1=page.get_allresult_list();
	String[] priceinitial=page.get_allresult_listPrice();
	
	@Then("get all the results {string}")
	public void get_all_the_results(String stringna) throws InterruptedException {
		Thread.sleep(2000);
		if(stringna.equals("Name (A to Z)")||stringna.equals("Name (Z to A)")) {
			for(int i=0;i<str1.length;i++) {
				System.out.println(str1[i]);
			}
		}
		if(stringna.equals("Price (low to high)")||stringna.equals("Price (high to low)")) {
			for(int i=0;i<priceinitial.length;i++) {
				System.out.println(priceinitial[i]);
			}
		}
	
	}

	@Then("get all the dropdowns from the dropdown")
	public void get_all_the_dropdowns_from_the_dropdown() throws InterruptedException {
		Thread.sleep(2000);
		Select select=new Select(page.get_dropdown_list());
		
		List<WebElement> options=select.getOptions();
		 for(WebElement element:options) {
		    	System.out.println(element.getText());
		    }
		
	   
	}

	@Then("select the dropdown {string}")
	public void select_the_dropdown(String string) throws InterruptedException {
		Thread.sleep(2000);
Select select=new Select(page.get_dropdown_list());
		
		select.selectByVisibleText(string);
		
	   Thread.sleep(5000);
	}

	@Then("varify according to dropdown selected {string}")
	public void varify_according_to_dropdown_selected(String strr) throws InterruptedException {
		Thread.sleep(2000);
		if(strr.equals("Name (Z to A)")) {
			String[] str2=page.get_allresult_list();
			
			for(int i=0;i<str2.length;i++) {
				System.out.println(str2[i]);
			}
			
			Arrays.sort(str1,Comparator.reverseOrder());
//			List<String> list=Arrays.asList(str1);
//			Collections.sort(list);
			
			String [] str3=new String[str1.length];
			for(int i=0;i<str1.length;i++) {
				
				System.out.println(str1[i]);
				str3[i]=str1[i];

				if(str3[i].equals(str2[i])) {
					Assert.assertTrue(true);
				}
				else {
					Assert.assertTrue(false);
				}
			}
			
			
		}
		if(strr.equals("Name (A to Z)")) {
        String[] str2=page.get_allresult_list();
			
			for(int i=0;i<str2.length;i++) {
				System.out.println(str2[i]);
			}
			
			Arrays.sort(str1,Comparator.naturalOrder());
//			List<String> list=Arrays.asList(str1);
//			Collections.sort(list);
			
			String [] str3=new String[str1.length];
			for(int i=0;i<str1.length;i++) {
				
				System.out.println(str1[i]);
				str3[i]=str1[i];

				if(str3[i].equals(str2[i])) {
					Assert.assertTrue(true);
				}
				else {
					Assert.assertTrue(false);
				}
			}
		}
		
		if(strr.equals("Price (low to high)")) {
	        String[] priceAfter=page.get_allresult_listPrice();
	        
	        for(int i=0;i<priceAfter.length;i++) {
	        	System.out.println(priceAfter[i]);
	        }
				
	        Arrays.sort(priceinitial, Comparator.comparingDouble(s -> Double.parseDouble(s.replace("$", ""))));
//			List<String> list=Arrays.asList(str1);
//			Collections.sort(list);
			
			String [] str3=new String[priceinitial.length];
			for(int i=0;i<priceinitial.length;i++) {
				
				System.out.println(priceinitial[i]);
				str3[i]=priceinitial[i];

				if(str3[i].equals(priceAfter[i])) {
					Assert.assertTrue(true);
				}
				else {
					Assert.assertTrue(false);
				}
			}
				
			}
		
		if(strr.equals("Price (high to low)")) {
	        String[] priceAfter=page.get_allresult_listPrice();
	        
	        for(int i=0;i<priceAfter.length;i++) {
	        	System.out.println(priceAfter[i]);
	        }
				
	        Arrays.sort(priceinitial, Comparator.comparingDouble((String s) -> Double.parseDouble(s.replace("$", ""))).reversed());
//			List<String> list=Arrays.asList(str1);
//			Collections.sort(list);
			
			String [] str3=new String[priceinitial.length];
			for(int i=0;i<priceinitial.length;i++) {
				
				System.out.println(priceinitial[i]);
				str3[i]=priceinitial[i];

				if(str3[i].equals(priceAfter[i])) {
					Assert.assertTrue(true);
				}
				else {
					Assert.assertTrue(false);
				}
			}
				
			}
		
	    
	}
	
	

}
