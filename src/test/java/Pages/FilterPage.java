package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Runner.DriverFactory;

public class FilterPage {
	
	
public WebDriver ldriver;

public FilterPage(WebDriver driver) {
ldriver=driver;
PageFactory.initElements(driver, this);
}


@FindBy(xpath="//select[@class='product_sort_container']")
@CacheLookup
private WebElement filter;

@FindBy(xpath="//div[@class='inventory_list']/div")
@CacheLookup
private List<WebElement> allresult;


@FindBy(xpath="//div[@class='inventory_list']/div")
@CacheLookup
private List<WebElement> itemlist;


public WebElement get_dropdown_list(){
	return filter;
}

public String[] get_allresult_list(){
	List<WebElement> list=allresult;
	 String [] str=new String[list.size()];
   for(int i=1; i<=list.size(); i++) {
	  
	str[i-1]=DriverFactory.getdriver().findElement(By.xpath("//div[@class='inventory_list']/div[" +i+"]/div[2]/div[1]/a")).getText();
	   
   }
   
   return str;

}

public List<WebElement> get_itemlist_list(){
	return itemlist;
}



}
