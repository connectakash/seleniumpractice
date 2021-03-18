package com.mindtree.bigbasket.reusablecomponents;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mindtree.bigbasket.exceptions.ReusableComponentException;
import com.mindtree.bigbasket.utilities.ConfigPropertyReader;

public class WebDriverHelper {
	
	ConfigPropertyReader reader = new ConfigPropertyReader();

	public void OpenUrl(WebDriver driver) {
		driver.get(reader.getURL());
	}
	
	public void sendKeys(WebDriver driver,By by,String keysToSend) throws ReusableComponentException {
		try {
		driver.findElement(by).sendKeys(keysToSend);
		}catch (Exception e) {
			// TODO: handle exception
			throw new ReusableComponentException(e);
		}
	}
	
	public void clickElement(WebDriver driver,By by) throws ReusableComponentException {
		try {
		driver.findElement(by).click();
		}catch (Exception e) {
			// TODO: handle exception
			throw new ReusableComponentException(e);
		}
	}
	
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(reader.getWait(),TimeUnit.SECONDS);
	}
	
	public void explicitWait(WebDriver driver,By by) {
		WebDriverWait wait = new WebDriverWait(driver, reader.getWait());
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	public void moveToElement(WebDriver driver,By by) {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(by)).perform();
	}

}
