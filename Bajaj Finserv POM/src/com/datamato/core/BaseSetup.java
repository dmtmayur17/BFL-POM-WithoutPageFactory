package com.datamato.core;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseSetup {
	private final String appiumPort = "4723";
	private final String serverIp = "0.0.0.0";
	//String workingDevice = "d6f08719";a315e67c
	String workingDevice = "d6f08719"; 
	private static AndroidDriver<MobileElement> driver;

	@BeforeSuite
	public void setup() throws MalformedURLException {
		init();
	}

	public AndroidDriver<MobileElement> getDriver() throws MalformedURLException {
		return driver;
	}

	public void init() throws MalformedURLException {
		System.out.println("Application Started..");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "OnePlus5T");
		capabilities.setCapability("udid", workingDevice);
		capabilities.setCapability("appPackage", "com.BajajServiceApp.VikramUAT");
		capabilities.setCapability("appActivity", ".MainActivity");
		capabilities.setCapability("noReset", true);
		String serverUrl = "http://" + serverIp + ":" + appiumPort + "/wd/hub";

		try {
			System.out.println("Argument to driver object : " + serverUrl);
			driver = new AndroidDriver<MobileElement>(new URL(serverUrl), capabilities);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		} catch (NullPointerException | MalformedURLException ex) {
			throw new RuntimeException("appium driver could not be initialised for device ");
		}
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		System.out.println("-----------------------------------------");
		System.out.println("Starting Method :" + method.getName());
		System.out.println("-----------------------------------------");
	}

	@AfterMethod
	public void afterMethod(Method method) {
		System.out.println("-----------------------------------------");
		System.out.println("Ending Method :" + method.getName());
		System.out.println("-----------------------------------------");
	}

	@AfterSuite
	public void tearDown() {
		System.out.println("Application Closed..");
		driver.quit();
	}
}
