package com.mindtree.bigbasket.reusablecomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mindtree.bigbasket.utilities.ConfigPropertyReader;

public class BrowserHelper {
	
	ConfigPropertyReader reader = new ConfigPropertyReader();

	public WebDriver getBrowser() {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver",reader.getDriverPath());
		driver=new ChromeDriver();
		return driver;
	}

}
