package com.datamato.tests;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.datamato.core.BaseSetup;
import com.datamato.pages.WelcomePage;

public class WelcomePageTest extends BaseSetup{


	public void welcomePageTest() throws Exception
	{
		
	}
	
	@Test(priority = 1)
	public void welcomeTest() throws MalformedURLException, InterruptedException
	{
		WelcomePage welcomePage = new WelcomePage();
		Assert.assertEquals(welcomePage.welcomePageLoad(), true);
	}
	
	@Test(dependsOnMethods="welcomeTest")
	public void testExistingUserTest() throws MalformedURLException, InterruptedException
	{
		WelcomePage welcomePage = new WelcomePage();
		Assert.assertEquals(welcomePage.loginPageLoad(), true);
	}
	
	@Test(dependsOnMethods="testExistingUserTest")
	public void loginWithExistingUsersCredentialsTest() throws MalformedURLException, InterruptedException
	{
		WelcomePage welcomePage = new WelcomePage();
		Assert.assertEquals(welcomePage.loginWithExistingUsersCredentials(), true);
	}
	@Test(dependsOnMethods="loginWithExistingUsersCredentialsTest")
	public void recommendedOffersTest() throws MalformedURLException, InterruptedException
	{
		WelcomePage welcomePage = new WelcomePage();
		Assert.assertEquals(welcomePage.recommendedOffers(), true);
	}
}





