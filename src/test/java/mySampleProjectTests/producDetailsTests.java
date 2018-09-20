package mySampleProjectTests;

import mySampleProjectObjects.BasePage;
import mySampleProjectObjects.productDetailsPageObjects;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class producDetailsTests {
	public productDetailsPageObjects pdp; 
	public BasePage bp;
	public producDetailsTests() {
	
		pdp=new productDetailsPageObjects();
		bp=new BasePage();
	}
	@BeforeMethod
	public void clickTshirtTab()
	{
		pdp.clickTShirtTab();
	}
	
	@Test
	public void verifyTwitter(){
		bp.frames(pdp.getframes());
		Assert.assertTrue(bp.elementFound(pdp.gettwitter()));
		Assert.assertTrue(bp.elementFound(pdp.getshare()));
		Assert.assertTrue(bp.isPresent(pdp.getdescription()));

		pdp.clickclose();
	}
	
	/*@Test
	public void verifyDescription()
	{
		bp.frames(pdp.getframes());
		Assert.assertTrue(bp.isPresent(pdp.getdescription()));
		//pdp.clickclose();
	}*/
	

}
