package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class orderPage {
	
	
	public WebDriver ldriver;
	
	public orderPage(WebDriver driver) {
		ldriver=driver;
		PageFactory.initElements(driver, this);
	
	}
	
	
	
	@FindBy(xpath="//button[@id='checkout']")
	@CacheLookup 
	private WebElement checkout;
	
	@FindBy(xpath="//input[@id='first-name']") 
	@CacheLookup 
	private WebElement firstName;
	
	@FindBy(xpath="//input[@id='last-name']")
	@CacheLookup 
	private WebElement lastName;
	
	@FindBy(xpath="//input[@id='postal-code']") 
	@CacheLookup 
	private WebElement zip_PostalCode;
	
	@FindBy(xpath="//input[@id='continue']")
	@CacheLookup 
	private WebElement continuebutton;
	
	@FindBy(xpath="//div[@class='cart_list']/div[3]/div[2]/div[2]/div") 
	@CacheLookup
	private WebElement amountfirstproduct;

	@FindBy(xpath="//div[@class='cart_list']/div[4]/div[2]/div[2]/div") 
	@CacheLookup
	private WebElement amountsecondproduct;
	
	@FindBy(xpath="//div[@class='summary_subtotal_label']")
	@CacheLookup
	private WebElement itemamt;
	
	@FindBy(xpath="//div[@class='summary_tax_label']")
	@CacheLookup
	private WebElement tax;
	
	@FindBy(xpath="//div[@class='summary_total_label']")
	@CacheLookup
	private WebElement totalamt;
	
	@FindBy(xpath="//div[@id='checkout_complete_container']/h2")
	@CacheLookup
	private WebElement header;
	
	@FindBy(xpath="//div[@class='complete-text']")
	@CacheLookup
	private WebElement bottomheader;
	
	@FindBy(xpath="//button[@id='finish']")
	@CacheLookup 
	private WebElement finish;
	
	
	public void click_on_checkout() {
		checkout.click();
	}
	
	
	public void enter_dtls(String firstname, String lastname, String postalcode) {
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		zip_PostalCode.sendKeys(postalcode);
	}
	
	public void click_on_continuebutton() {
		continuebutton.click();
	}
	
	public float get_fist_product_amt() {
		String firstProamt1 = amountfirstproduct.getText();
		String firstProdamt = firstProamt1.substring(1);
		float amount1 = Float.parseFloat(firstProdamt);
		System.out.println(amount1);
		return amount1;
		
	}
	
	public float get_second_product_amt() {
		String secProdamt2 = amountsecondproduct.getText();
		String secProdamt = secProdamt2.substring(1);
		float amount2 = Float.parseFloat(secProdamt);
		System.out.println(amount2);
		return amount2;
		
	}
	
	public float get_item_amt() {
		String totalitemamt1= itemamt.getText();
	    String totalitemamt = totalitemamt1.substring(13);
	    System.out.println(totalitemamt);
	    float ttlitemamt = Float.parseFloat(totalitemamt);
		return ttlitemamt;
		
	}
	
	public float get_tax_amt() {
		String taxamount1 = tax.getText();
		String taxamount = taxamount1.substring(6);
		 float taxamt = Float.parseFloat(taxamount);
			return taxamt;
		
	}
	
	public float get_total_amt() {
		String total1 = totalamt.getText();
		String total = total1.substring(8);
		 float totalamount = Float.parseFloat(total);
		return totalamount;
		
	}
	
	public String get_header() {
		String headerh = header.getText();
		return headerh;
	}
	
	public String get_bottomheader() {
		String bottomheadertextmsg = bottomheader.getText();
		return bottomheadertextmsg;
	}
	
	public void click_on_finish() {
		finish.click();
		
	}
}
