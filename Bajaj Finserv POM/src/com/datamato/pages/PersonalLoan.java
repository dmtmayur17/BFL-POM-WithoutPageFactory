package com.datamato.pages;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.datamato.core.BaseSetup;

public class PersonalLoan {

	BaseSetup baseSetup;
	private WebElement calculatorButton;
	private WebElement checkWhetherClickedOnCalculatorButton;
	private WebElement calculatorBackButton;
	private WebElement applyNowButton;
	private WebElement checkWhetherClickedOnApplyNowButton;
	private WebElement applyNowBackButton;
	private WebElement seedetailsButton;
	private WebElement checkWhetherClickedOnseedetailsButton;
	private WebElement seedetailsBackButton;

	public PersonalLoan() throws MalformedURLException
	{
		baseSetup = new BaseSetup();		
	}

	public boolean calculators() throws MalformedURLException, InterruptedException
	{
		Thread.sleep(3000);
		calculatorButton = baseSetup.getDriver().findElement(By.xpath("((((//*[@id='tabpanel-t0-3']/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*/*[@text='CALCULATORS'])[1]"));	
		calculatorButton.click();
		checkWhetherClickedOnCalculatorButton = baseSetup.getDriver().findElement(By.xpath("//*[@text='Flexi Interest-only Loan EMI Calculator' and (./preceding-sibling::* | ./following-sibling::*)[@class='android.view.View' and ./*[@text='Home']]]"));
		Thread.sleep(3000);
		if (checkWhetherClickedOnCalculatorButton.isDisplayed())
		{
			System.out.println("Calculators Page loaded successfully....!");
			if(checkWhetherClickedOnCalculatorButton.getText().equals("Flexi Interest-only Loan EMI Calculator"));
			{
				calculatorBackButton = baseSetup.getDriver().findElement(By.xpath("//*[@contentDescription='close button']"));	
				calculatorBackButton.click();
				return true;
			}
		}
		else
		{
			System.out.println("Calculators Page not loaded...!");
			return false;
		}
	}
	
	public boolean applyNow() throws MalformedURLException, InterruptedException
	{
		Thread.sleep(3000);
		applyNowButton = baseSetup.getDriver().findElement(By.xpath("((((//*[@id='tabpanel-t0-3']/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*/*[@text='APPLY NOW'])[1]"));	
		applyNowButton.click();
		checkWhetherClickedOnApplyNowButton = baseSetup.getDriver().findElement(By.xpath("//*[@text='Getting Personal Loans couldn’t be quicker!']"));
		Thread.sleep(3000);
		if (checkWhetherClickedOnApplyNowButton.isDisplayed())
		{
			System.out.println("Apply Now Page loaded successfully....!");
			if(checkWhetherClickedOnApplyNowButton.getText().equals("Getting Personal Loans couldn’t be quicker!"));
			{
				applyNowBackButton = baseSetup.getDriver().findElement(By.xpath("//*[@contentDescription='close button']"));	
				applyNowBackButton.click();
				return true;
			}
		}
		else
		{
			System.out.println("Apply Now Page not loaded...!");
			return false;
		}
	}
	
	public boolean seeDetails() throws MalformedURLException, InterruptedException
	{
		Thread.sleep(3000);
		seedetailsButton = baseSetup.getDriver().findElement(By.xpath("((((//*[@id='tabpanel-t0-3']/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*/*[@text='SEE DETAILS'])[1]"));	
		seedetailsButton.click();
		checkWhetherClickedOnseedetailsButton = baseSetup.getDriver().findElement(By.xpath("//*[@text='Personal Loan' and (./preceding-sibling::* | ./following-sibling::*)[./*[@text='Home']]]"));
		Thread.sleep(3000);
		if (checkWhetherClickedOnseedetailsButton.isDisplayed())
		{
			System.out.println("See Details Page loaded successfully....!");
			if(checkWhetherClickedOnseedetailsButton.getText().equals("Personal Loan"));
			{
				seedetailsBackButton = baseSetup.getDriver().findElement(By.xpath("//*[@contentDescription='close button']"));	
				seedetailsBackButton.click();
				return true;
			}
		}
		else
		{
			System.out.println("See Details Page not loaded...!");
			return false;
		}
	}

	
}
