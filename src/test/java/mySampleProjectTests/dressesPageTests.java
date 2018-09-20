package mySampleProjectTests;

import java.util.ArrayList;
import java.util.List;

import mySampleProjectObjects.BasePage;
import mySampleProjectObjects.dressesPageObjects;
import mySampleProjectObjects.homePageObjects;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class dressesPageTests {

	public dressesPageObjects dpo;
	public homePageObjects hpo;
	public BasePage bp;
	public dressesPageTests() {
		
		dpo=new dressesPageObjects();
		hpo=new homePageObjects();
		bp=new BasePage();
	}
	
	/*@Test
	public void verifyslider()
	{
		hpo.clickDressTab();
		bp.dragandDrop(dpo.getslider());
		bp.getpriceRange(dpo.getprice());
		dpo.countnoofdress();
		dpo.getdresspriceCheck();
		
		//System.out.println("ispresent" + bp.dragandDrop(dpo.getslider()));
		//Assert.assertTrue(bp.dragandDrop(dpo.getslider()).contains("left: 0%"));
		//Assert.assertTrue(bp.elementFound(dpo.gegetsmallcheckboxtslider()));
	}*/
	@BeforeTest
	public void clickDressTab(){
		hpo.clickDressTab();
	}
	
	@Test
		public void verifySizeTabs(){
		Assert.assertTrue(bp.getText(dpo.getsmallcheckbox()).contains("S"));
		Assert.assertTrue(bp.getText(dpo.getmediumcheckbox()).contains("M"));
		Assert.assertTrue(bp.getText(dpo.getlargecheckbox()).contains("L"));
	}
	
	@Test
	public void verifyDressCount()
	{
		
		int imgCount=dpo.getDressCount();
		int displaycount=dpo.getsplitText();
		Assert.assertEquals(imgCount, displaycount);
		//Assert.assertTrue(dpo.display().contains(dpo.getDressCount()));
	}
	
	@Test
	public void verifyAddtocart()
	{
		bp.action(dpo.mouseover());
		dpo.clickAddtoCArt();
		Assert.assertTrue(dpo.getStringCheckAdded().contains("successfully"));
		dpo.clickClose();
	}
	@Test
	public void verifySort()
	{
		dpo.getSelectBox();
		//dpo.getDressCount();
		//dpo.getPriceList();
		List< Double> actualPriceOrder=dpo.getPriceList();
		ArrayList<Double> expectedPriceOrder=new ArrayList<Double>();
		expectedPriceOrder.addAll(dpo.getExpectedPriceList());
		try
		{
		Assert.assertEquals(actualPriceOrder, expectedPriceOrder);
		}
		catch(AssertionError e)
		{
			System.out.println("Not Equal");
			throw e;
		}
		System.out.println("Equal");
		//Assert.assertTrue(actualPriceOrder.equals(expectedPriceOrder));
	}
}
