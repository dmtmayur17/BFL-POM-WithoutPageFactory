package com.datamato.core;

import java.net.MalformedURLException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Driver extends BaseSetup {
	protected AppiumDriver<MobileElement> driver;

	public Driver() throws MalformedURLException{
		this.driver = super.getDriver();
		System.out.println(driver);
	}
}
