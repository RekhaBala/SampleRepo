package mySampleProjectTests;

import java.sql.Driver;

import mySampleProjectObjects.BasePage;
import mySampleProjectObjects.homePageObjects;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class homePageTests {

	public homePageObjects hpo;
	public BasePage bp;
	public homePageTests()
	{
		hpo=new homePageObjects();
		bp=new BasePage();
	}
	@Test
	public void verifyTabs()
	{
		Assert.assertTrue(bp.elementFound(hpo.getwomenTab()));
		Assert.assertTrue(bp.elementFound(hpo.getDressesTab()));
		Assert.assertTrue(bp.elementFound(hpo.gettshirtTab()));
	}
	@Test
	public void verifResPage()
	{
		hpo.clickWomenTab();
		Assert.assertTrue(hpo.title.contains("My Store"));
		
		hpo.clickDressTab();
		Assert.assertTrue(bp.getText(hpo.getDressesCompare()).contains("DRESSES"));
		
		hpo.clickTshirtTab();
		Assert.assertTrue(bp.getText(hpo.getTshirtCompare()).contains("T-SHIRTS"));
	}
	@Test
	public void verifyNewsletter()
	{
		hpo.enterMailid();
		Assert.assertTrue(bp.elementFound(hpo.getsuccess()));
	}
	@AfterClass
	public void quitBrower()
	{
	   bp.driver.close();
	}
}
