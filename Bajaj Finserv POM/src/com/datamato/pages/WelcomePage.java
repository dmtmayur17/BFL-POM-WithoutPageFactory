package com.datamato.pages;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.datamato.core.BaseSetup;

public class WelcomePage {

	BaseSetup baseSetup;
	private WebElement newUser;
	private WebElement existingCustomer;
	private WebElement welcomeText;
	private WebElement existingCustomertxt;
	private WebElement checkWhetherLoginPageDisplayed;
	private WebElement experiaID;
	private WebElement password;
	private WebElement loginButton;
	private WebElement checkWhetherWeAreLoggedIn;
	private WebElement recommendedOfferTab;
	private WebElement checkWhetherRecommendedOffersTabClicked;
	

	public WelcomePage() throws MalformedURLException
	{
		baseSetup = new BaseSetup();		
	}

	public boolean welcomePageLoad() throws MalformedURLException, InterruptedException
	{
		Thread.sleep(3000);
		existingCustomer = baseSetup.getDriver().findElement(By.xpath("//*[@class='android.view.View' and ./*[./*[@class='android.widget.Image']] and ./*[@text='Existing Customer']]"));	
		
		if (existingCustomer.isDisplayed())
		{
			System.out.println("Welcome page loaded successfully....!");
			existingCustomer.click();
			return true;
		}
		else
		{
			System.out.println("Welcome page not loaded successfully...!");
			return false;
		}
	}
	
	public boolean loginPageLoad() throws MalformedURLException, InterruptedException
	{
		Thread.sleep(3000);
		checkWhetherLoginPageDisplayed = baseSetup.getDriver().findElement(By.xpath("//*[@text='LOG IN TO ACCESS CUSTOMER SERVICE']"));
		Thread.sleep(4000);																				
		if (checkWhetherLoginPageDisplayed.isDisplayed())
		{
			if(checkWhetherLoginPageDisplayed.getText().equals("LOG IN TO ACCESS CUSTOMER SERVICE"));
			return true;
		}
		return false;
	}

	public boolean loginWithExistingUsersCredentials() throws MalformedURLException, InterruptedException
	{
		Thread.sleep(3000);
		experiaID = baseSetup.getDriver().findElement(By.xpath("//*[@class='android.widget.EditText' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@class='android.view.View']]]"));
		experiaID.sendKeys("163961");
		
		password = baseSetup.getDriver().findElement(By.xpath("//*[@class='android.widget.EditText' and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@class='android.view.View']]]]"));
		password.sendKeys("Bajaj@123");
		
		loginButton = baseSetup.getDriver().findElement(By.xpath("//*[@text='LOGIN']"));
		loginButton.click();
	
		Thread.sleep(3000);
		checkWhetherWeAreLoggedIn = baseSetup.getDriver().findElement(By.xpath("//*[@text='Active Relations' and @class='android.view.View']"));
		Thread.sleep(4000);
		if (checkWhetherWeAreLoggedIn.isDisplayed())
		{
			if(checkWhetherWeAreLoggedIn.getText().equals("Active Relations"));
			return true;
		} 
		return false;
	}
	public boolean recommendedOffers() throws MalformedURLException, InterruptedException
	{
		Thread.sleep(3000);
		recommendedOfferTab = baseSetup.getDriver().findElement(By.xpath("//*[@text='rec offers-outline Recommended']"));
		recommendedOfferTab.click();
		
		Thread.sleep(3000);
		checkWhetherRecommendedOffersTabClicked = baseSetup.getDriver().findElement(By.xpath("//*[@text='Recommended Offers' and @class='android.view.View']"));
		
		Thread.sleep(4000);
		if (checkWhetherRecommendedOffersTabClicked.isDisplayed())
		{
			if(checkWhetherRecommendedOffersTabClicked.getText().equals("Recommended Offers"));
			return true;
		} 
		return false;
	}
}
