package mySampleProjectObjects;

import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.json.Json;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class BasePage {
	public static WebDriver driver;
	public String browser;
	public String title;
	JsonObject json=jsonFile();
	public BasePage()
	{
		if(driver==null)
		{
			browser=json.get("browser").getAsString();
			if(browser.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\HOME\\Downloads\\chromedriver.exe");
				driver=new ChromeDriver();
			}
			else if(browser.equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\HOME\\Downloads\\geckodriver.exe");
				driver=new FirefoxDriver();
			}
			driver.get(json.get("URL").getAsString());
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			title=driver.getTitle();
		}
		
	}
	public void action(WebElement ele)
	{
		Actions over=new Actions(driver);
		over.moveToElement(ele).build().perform();
	}
	public void dragandDrop(WebElement ele)
	{
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		Actions over=new Actions(driver);
		int x=0;
		/*over.clickAndHold(ele);
		over.moveByOffset(30, 0).build().perform();*/
		 int width=ele.getSize().getWidth();
		//String size= ele.getAttribute("Style");
		//return size;
		//int sizeint=Integer.parseInt(size);
		over.dragAndDropBy(ele,((width*x)/50), 0).build().perform();
		//js.executeScript("arguments[0].setAttribute('style', 'left: 24%;')",ele);

	}
	public void getpriceRange(WebElement ele){
		String range=ele.getText();
		String[] arr=range.split("\\$");
		for(int i=0;i<arr.length;i++){
				if(i==1){
					arr[i]=arr[i].replace("-", "").trim();
					System.out.println(arr[i]);
				}
				else{
				System.out.println(arr[i].trim());
				}
		}
	}	
	public void frames(WebElement ele)
	{
		driver.switchTo().frame(ele);
	}
	public boolean elementFound(WebElement ele)
	{
		boolean set=false;
		try{
			set= ele.isDisplayed();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return set;
	}
	public String getText(WebElement ele)
	{
		String smalltext=ele.getText();
		return smalltext;
	}
	public boolean isPresent(WebElement ele)
	{
		String name=ele.getText();
		if((name!=null) && (name.length()<=200))
		{
			return true;
		}
		return false;
	}
	public JsonObject jsonFile()
	{
		JsonObject json=null;
		try
		{
			File file=new File("./src/test/resources/config.json");
			FileReader fr=new FileReader(file.getAbsolutePath());
			JsonParser parser=new JsonParser();
			Object obj=parser.parse(fr);
			json=(JsonObject)obj;
		}catch(Exception e){
			e.printStackTrace();
		}
		return json;
	}

}
