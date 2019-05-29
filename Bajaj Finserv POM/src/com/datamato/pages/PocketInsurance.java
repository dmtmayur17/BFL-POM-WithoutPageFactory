package com.datamato.pages;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import com.datamato.core.BaseSetup;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class PocketInsurance {

	BaseSetup baseSetup;
	int i = 1;
	
	private WebElement checkWhetherClickedOnPocketInsurance;
	private WebElement travelButton;
	private WebElement checkWhetherClickedOnTravelButtonButton;
	private WebElement knowMoreButton;
	private WebElement checkWhetherClickedOnKnowMoreButton;
	private WebElement knowMorePocketinsuranceBackButton;
	private WebElement applyNowButton; 
	private WebElement checkWhetherClickedOnApplyNowButton; 
	private WebElement applyNowPocketinsuranceBackButton; 
	
	private WebElement brochureButton; 
	private WebElement checkWhetherClickedOnBrochureButton; 
	private WebElement brochurePocketinsuranceBackButton; 
	
	

	public PocketInsurance() throws MalformedURLException
	{
		baseSetup = new BaseSetup();		
	}
	
	public void scrollDownDown() throws MalformedURLException
	{
		i++;
		//System.out.println("Size of Mobile: " +driver.manage().window().getSize());
		Dimension dimention = baseSetup.getDriver().manage().window().getSize();
		
		Double scrollHeightStart = dimention.getHeight() * 0.5;
		int scrollStart = scrollHeightStart.intValue();
		
		Double scrollHeightEnd = dimention.getHeight() * 0.2;
		int scrollEnd = scrollHeightEnd.intValue();
		
		new TouchAction<>(baseSetup.getDriver())
			.press(PointOption.point(0, scrollStart))
			.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
			.moveTo(PointOption.point(0, scrollEnd))
			.release().perform();
	}


	public List<MobileElement> getItemWebView() throws InterruptedException, MalformedURLException
	{
		//return (List<MobileElement>) driver.findElements(By.xpath("((((//*[@id='tabpanel-t1-3']/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*/*[@text='SEE DETAILS'])[10]"));
		return (List<MobileElement>)baseSetup.getDriver().findElements(By.xpath("((((//*[@id='tabpanel-t0-3']/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*/*[@text='SEE DETAILS'])[10]"));
	}

	public void scrollTillWebView() throws InterruptedException, MalformedURLException
	{	
			while(getItemWebView().size() == 1)
			{
				if(i<8)
				scrollDownDown();
				else break;
			}
		
		if(i >=8)//getItemWebView().size() > 1
		{
			getItemWebView().get(0).click();
		}
		Thread.sleep(4000);
		
	}

	public boolean scrollDownTillPocketInsuranceAndClickOnSeeDetails() throws MalformedURLException, InterruptedException
	{
		scrollTillWebView();
		checkWhetherClickedOnPocketInsurance = baseSetup.getDriver().findElement(By.xpath("//*[@text='TYPES OF INSURANCE']"));
		Thread.sleep(3000);
		if (checkWhetherClickedOnPocketInsurance.isDisplayed())
		{
			System.out.println("Pocket Insurance Page loaded successfully....!");
			if(checkWhetherClickedOnPocketInsurance.getText().equals("TYPES OF INSURANCE"));
			{
				return true;
			}
		}
		else
		{
			System.out.println("Pocket Insurance Page not loaded...!");
			return false;
		}	
	}
	
	public boolean travelPocketinsurance() throws MalformedURLException, InterruptedException
	{
		Thread.sleep(3000);
		travelButton = baseSetup.getDriver().findElement(By.xpath("//*[@class='android.view.View' and ./*[@class='android.widget.Image'] and ./*[@text='Travel']]"));	
		travelButton.click();
		checkWhetherClickedOnTravelButtonButton = baseSetup.getDriver().findElement(By.xpath("//*[@text='Travel' and @class='android.view.View']"));
		Thread.sleep(3000);
		if (checkWhetherClickedOnTravelButtonButton.isDisplayed())
		{
			System.out.println("Travel Page loaded successfully....!");
			if(checkWhetherClickedOnTravelButtonButton.getText().equals("Travel"));
			{
				return true;
			}
		}
		else
		{
			System.out.println("Travel Page not loaded...!");
			return false;
		}
	}
	
	public boolean pilgrimageCoverKnowMore() throws MalformedURLException, InterruptedException
	{
		Thread.sleep(3000);
		knowMoreButton = baseSetup.getDriver().findElement(By.xpath("//*[@text='KNOW MORE' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@text='PILGRIMAGE COVER']]]]"));	
		knowMoreButton.click();
		checkWhetherClickedOnKnowMoreButton = baseSetup.getDriver().findElement(By.xpath("//*[@text='Prompt services for a worry-free pilgrimage']"));
		Thread.sleep(3000);
		if (checkWhetherClickedOnKnowMoreButton.isDisplayed())
		{
			System.out.println("Know More Page loaded successfully....!");
			if(checkWhetherClickedOnKnowMoreButton.getText().equals("Prompt services for a worry-free pilgrimage"));
			{
				knowMorePocketinsuranceBackButton = baseSetup.getDriver().findElement(By.xpath("//*[@text='arrow back']"));	
				knowMorePocketinsuranceBackButton.click();										
				return true;
			}
		}
		else
		{
			System.out.println("Know More Page not loaded...!");
			return false;
		}
	}
	
	public boolean pilgrimageCoverApplyNow() throws MalformedURLException, InterruptedException
	{
		Thread.sleep(3000);
		applyNowButton = baseSetup.getDriver().findElement(By.xpath("(((//*[@id='tabpanel-t0-3']/*[@class='android.view.View'])[2]/*/*/*[@class='android.view.View' and ./parent::*[@class='android.view.View' and (./preceding-sibling::* | ./following-sibling::*)[@class='android.view.View']]])[2]/*/*[@text='APPLY NOW'])[1]"));	
		applyNowButton.click();
		checkWhetherClickedOnApplyNowButton = baseSetup.getDriver().findElement(By.xpath("//*[@text='Pilgrimage Holiday Insurance- Application Form']"));
		Thread.sleep(3000);
		if (checkWhetherClickedOnApplyNowButton.isDisplayed())
		{
			System.out.println("Apply Now Page loaded successfully....!");
			if(checkWhetherClickedOnApplyNowButton.getText().equals("Pilgrimage Holiday Insurance- Application Form"));
			{
				applyNowPocketinsuranceBackButton = baseSetup.getDriver().findElement(By.xpath("//*[@contentDescription='close button']"));	
				applyNowPocketinsuranceBackButton.click();
				return true;
			}
		}
		else
		{
			System.out.println("Apply Now Page not loaded...!");
			return false;
		}
	}
	
	public boolean pilgrimageCoverBrochure() throws MalformedURLException, InterruptedException
	{
		Thread.sleep(3000);
		brochureButton = baseSetup.getDriver().findElement(By.xpath("//*[@text='BROCHURE' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@text='PILGRIMAGE COVER']]]]"));	
		brochureButton.click();
		checkWhetherClickedOnBrochureButton = baseSetup.getDriver().findElement(By.xpath("//*[@text='atm-assault-robbery.pdf']"));
		Thread.sleep(3000);
		if (checkWhetherClickedOnBrochureButton.isDisplayed())
		{
			System.out.println("Brochure Page loaded successfully....!");
			if(checkWhetherClickedOnBrochureButton.getText().equals("atm-assault-robbery.pdf"));
			{
				brochurePocketinsuranceBackButton = baseSetup.getDriver().findElement(By.xpath("//*[@contentDescription='Navigate up']"));	
				brochurePocketinsuranceBackButton.click();
				return true;
			}
		}
		else
		{
			System.out.println("Brochure Page not loaded...!");
			return false;
		}
	}
	
	

	
}
