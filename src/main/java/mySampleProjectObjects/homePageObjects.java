package mySampleProjectObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePageObjects extends BasePage{
	
	public homePageObjects()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id='block_top_menu']//li[1]//*[text()='Women']")
	private WebElement womenTab;
	
	@FindBy(xpath="//*[@id='block_top_menu']//li[3]//*[text()='T-shirts']")
	private WebElement tshirtTab;
	
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[2]/a[text()='Dresses']")
	private WebElement dressTab;
	
	@FindBy(xpath="//*[@id='category']//h1//*[@class='cat-name']")
	private WebElement dresstitle;
	
	@FindBy(xpath="//*[@id='category']//h1//*[@class='cat-name']")
	private WebElement tshirttitle;
	
	@FindBy(id="newsletter-input")
	private WebElement newsletter;
	
	@FindBy(name="submitNewsletter")
	private WebElement submit;
	
	@FindBy(xpath="//p[@class='alert alert-danger']")
	private WebElement danger;
	
	@FindBy(xpath="//p[@class='alert alert-success']")
	private WebElement success;
	
	public WebElement getwomenTab(){
		return womenTab;
	}
	public void clickWomenTab(){
		womenTab.click();
	}
	public WebElement getDressesTab(){
		return dressTab;
	}
	
	public void clickDressTab(){
		dressTab.click();
	}
	
	public WebElement getDressesCompare(){
		return dresstitle;
	}
	
	public WebElement gettshirtTab(){
		return tshirtTab;
	}
	public void clickTshirtTab(){
		tshirtTab.click();
	}
	public WebElement getTshirtCompare(){
		return tshirttitle;
	}
	public WebElement getsuccess(){
		return success;
	}
	public WebElement getdanger(){
		return danger;
	}
	public void enterMailid(){
		try{
		newsletter.sendKeys("iewrioweurq6577@gmail.com");
		submit.click();
		}
		catch(Exception e){
			throw e;
		}
	}
	public String mailid(){
		String id=newsletter.getText();
		return id;
	}
	
}
