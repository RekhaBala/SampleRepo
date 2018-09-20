package mySampleProjectObjects;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dressesPageObjects extends BasePage {
	
	public dressesPageObjects() {
		PageFactory.initElements(driver, this);
	}
	
	
	/*@FindBy(xpath="//div[@class='right-block']//*[@class='price product-price']")
	private List<WebElement> dressCount;
	
	@FindBy(xpath="//*[@id='layered_price_slider']//div")
	private WebElement slider;
	
	@FindBy(xpath="//span[@id='layered_price_range']")
	private WebElement priceRange;
	public WebElement getslider(){
		return slider;
	}
	public WebElement getprice(){
		return priceRange;
	}
	public void countnoofdress(){
		
		System.out.println(count.size());
	}
	*/

	@FindBy(xpath="//*[@id='category']//h1//*[@class='heading-counter']")
	private WebElement itemcount;
	@FindBy(xpath="//ul[@class='product_list grid row']/li")
	private List<WebElement> count;
	
	@FindBy(xpath="//*[@id='ul_layered_id_attribute_group_1']/li[1]//a")
	private WebElement smallcheckBox;
	@FindBy(xpath="//*[@id='ul_layered_id_attribute_group_1']/li[2]//a")
	private WebElement mediumcheckBox;
	@FindBy(xpath="//*[@id='ul_layered_id_attribute_group_1']/li[3]//a")
	private WebElement largecheckBox;

	@FindBy(xpath="//*[@class='product_list grid row']//li[1]")
	private WebElement mouseovertarget;
	@FindBy(xpath="//ul[@class='product_list grid row']//li[1]//a[@title='Add to cart']")
	private WebElement clickAddtoCart;

	@FindBy(xpath="//div[@id='layer_cart']/div[1]/div[1]/h2")
	private WebElement checkadded;
	@FindBy(xpath="//div[@id='layer_cart']/div[1]/div[1]/span")
	private WebElement close;

	@FindBy(id="selectProductSort")
	private WebElement selectBox;
	@FindBy(xpath="//ul[@class='product_list grid row']/li//div[@class='right-block']//span[@itemprop='price']")
	private List<WebElement> priceList;
	
	public String display(){
		String name=itemcount.getText();
		System.out.println("The printed text is"+name);
		return name;
	}
	public Integer getDressCount() {	
		int size=count.size();
		System.out.println(size);
		return size;
	}
	public Integer getsplitText()
	{ 
		int number=0;
		String name=itemcount.getText();
		String[] arr= name.split(" ");
		for(int i=0;i<arr.length;i++)
		{
			if(i==2)
			{
				number=Integer.parseInt(arr[i]);
				break;
			}
		}
		System.out.println(number);
		return number;
	}
	public WebElement getsmallcheckbox(){
		return smallcheckBox;
	}
	public void clickAddtoCArt(){
		clickAddtoCart.click();
	}
	public WebElement getmediumcheckbox(){
		return mediumcheckBox;
	}
	public WebElement getlargecheckbox(){
		return largecheckBox;
	}
	public WebElement mouseover(){
		return mouseovertarget;
	}

	public void clickClose(){
		close.click();
	}
	public void getSelectBox(){
		Select sortBy=new Select(selectBox);
		sortBy.selectByValue("price:asc");
	}
	public List<Double> getPriceList()
	{
		ArrayList<Double> list=new ArrayList<Double>();
		WebDriverWait wdw=new WebDriverWait(driver,30);
		wdw.until(ExpectedConditions.visibilityOfAllElements(priceList));
		for(WebElement ele:priceList){
			String price=ele.getText();
			list.add(Double.parseDouble(price.replace("$", " ").trim()));
		}
		System.out.println(list);
		return list;
	}
	public List<Double> getExpectedPriceList()
	{
		ArrayList<Double> list1=new ArrayList<Double>();
		for(WebElement ele:priceList){
			String price=ele.getText();
			list1.add(Double.parseDouble(price.replace("$", " ").trim()));
		}
		//Collections.sort(list, Collections.reverseOrder());
		Collections.sort(list1);
		System.out.println(list1);
		return list1;
	}
	
	public String getStringCheckAdded(){
		WebDriverWait wdw=new WebDriverWait(driver,30);
		wdw.until(ExpectedConditions.visibilityOf(checkadded));
		String name=checkadded.getText();
		System.out.println("name is" + name);
		return name;
	}
	


}
