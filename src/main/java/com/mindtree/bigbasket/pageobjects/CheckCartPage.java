package com.mindtree.bigbasket.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.bigbasket.exceptions.PageObjectException;
import com.mindtree.bigbasket.exceptions.ReusableComponentException;
import com.mindtree.bigbasket.reusablecomponents.WebDriverHelper;
import com.mindtree.bigbasket.uistore.CartUi;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CheckCartPage {
	
	WebDriverHelper wh = new WebDriverHelper();
	

	public void CheckCart(WebDriver driver,ExtentReports extent,ExtentTest test,Logger log) throws PageObjectException {
		try {
//			wh.moveToElement(driver, CartUi.cartbutton);
//			wh.explicitWait(driver, CartUi.viewCartBtn);
			//wh.implicitWait(driver);
			wh.clickElement(driver, CartUi.selectItem);
			log.info("Item selected");
			test.log(LogStatus.PASS, "Item selected");
			driver.navigate().back();
		} catch (ReusableComponentException e) {
			// TODO Auto-generated catch block
			log.info("Item not selected");
			test.log(LogStatus.FAIL, "Item not selected");
			throw new PageObjectException("Item not selected",e);
		}
//		
//		try {
//			wh.clickElement(driver, CartUi.cartBtn);
//			log.info("Add to cart clicked");
//			test.log(LogStatus.PASS, "Add to cart clicked");
//			driver.navigate().back();
//		} catch (ReusableComponentException e) {
//			// TODO Auto-generated catch block
//			log.info("Add to cart not clicked");
//			test.log(LogStatus.FAIL, "Add to cart not clicked");
//			throw new PageObjectException("Add to cart not clicked",e);
//		}
	}

}
