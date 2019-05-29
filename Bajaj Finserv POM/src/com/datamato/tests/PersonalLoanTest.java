package com.datamato.tests;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.datamato.core.BaseSetup;
import com.datamato.pages.PersonalLoan;
import com.datamato.pages.WelcomePage;

public class PersonalLoanTest extends BaseSetup{


	public void PersonalLoanTest() throws Exception
	{
		
	}
	
	@Test(priority = 1)
	public void calculatorTest() throws MalformedURLException, InterruptedException
	{
		PersonalLoan personalLoanPage = new PersonalLoan();
		Assert.assertEquals(personalLoanPage.calculators(), true);
	}
	
	@Test(dependsOnMethods="calculatorTest")
	public void applyNowTest() throws MalformedURLException, InterruptedException
	{
		PersonalLoan personalLoanPage = new PersonalLoan();
		Assert.assertEquals(personalLoanPage.applyNow(), true);
	}
	@Test(dependsOnMethods="applyNowTest")
	public void seeDetailsTest() throws MalformedURLException, InterruptedException
	{
		PersonalLoan personalLoanPage = new PersonalLoan();
		Assert.assertEquals(personalLoanPage.seeDetails(), true);
	}
	
}





