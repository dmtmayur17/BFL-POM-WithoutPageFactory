package com.datamato.tests;

import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.datamato.core.BaseSetup;
import com.datamato.pages.PocketInsurance;

public class PocketInsuranceTest extends BaseSetup{


	public PocketInsuranceTest() throws Exception
	{
		
	}
	
	@Test(priority = 1)
	public void scrollDownTillPocketInsuranceAndClickOnSeeDetailsTest() throws MalformedURLException, InterruptedException
	{
		PocketInsurance pocketinsurancePage = new PocketInsurance();
		Assert.assertEquals(pocketinsurancePage.scrollDownTillPocketInsuranceAndClickOnSeeDetails(), true);
	}
	
	@Test(dependsOnMethods = "scrollDownTillPocketInsuranceAndClickOnSeeDetailsTest")
	public void travelPocketinsuranceTest() throws MalformedURLException, InterruptedException
	{
		PocketInsurance pocketinsurancePage = new PocketInsurance();
		Assert.assertEquals(pocketinsurancePage.travelPocketinsurance(), true);
	}
	
	@Test(dependsOnMethods = "travelPocketinsuranceTest")
	public void pilgrimageCoverKnowMoreTest() throws MalformedURLException, InterruptedException
	{
		PocketInsurance pocketinsurancePage = new PocketInsurance();
		Assert.assertEquals(pocketinsurancePage.pilgrimageCoverKnowMore(), true);
	}
	
	@Test(dependsOnMethods = "pilgrimageCoverKnowMoreTest")
	public void pilgrimageCoverApplyNowTest() throws MalformedURLException, InterruptedException
	{
		PocketInsurance pocketinsurancePage = new PocketInsurance();
		Assert.assertEquals(pocketinsurancePage.pilgrimageCoverApplyNow(), true);
	}
	
	@Test(dependsOnMethods = "pilgrimageCoverApplyNowTest")
	public void pilgrimageCoverBrochureTest() throws MalformedURLException, InterruptedException
	{
		PocketInsurance pocketinsurancePage = new PocketInsurance();
		Assert.assertEquals(pocketinsurancePage.pilgrimageCoverBrochure(), true);
	}	
}





