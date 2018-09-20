package mySampleProjectObjects;

import java.io.File;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mySampleProjectObjects.BasePage;



public class productDetailsPageObjects extends BasePage{
	
	public productDetailsPageObjects() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[contains(@class,'socialsharing')]/button[contains(@class,'twitter')]/i")
	private WebElement twitter;
	@FindBy(xpath="//*[contains(@class,'socialsharing')]/button[contains(@class,'facebook')]/i")
	private WebElement share;
	
	@FindBy(xpath="//*[@id='homefeatured']/li[2]//img")
	private WebElement product;
	
	@FindBy(xpath="//*[contains(@id,'fancybox-frame')]")
	private WebElement frameid;
	
	@FindBy(xpath="//*[@id='short_description_content']/p")
	private WebElement description;
	
	@FindBy(xpath="//a[@title='Close']")
	private WebElement close;
	
	public WebElement gettwitter(){
		return twitter;
	}
	public WebElement getshare(){
		return share;
	}

	public WebElement getproduct(){
		return product;
	}
	public WebElement getframes(){
		return frameid;
	}

	public WebElement getdescription(){
		return description;
	}
	public void clickTShirtTab(){
		product.click();
	}
	public void clickclose(){
		close.click();
	}

}
