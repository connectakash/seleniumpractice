package com.mindtree.bigbasket.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.bigbasket.exceptions.PageObjectException;
import com.mindtree.bigbasket.exceptions.ReusableComponentException;
import com.mindtree.bigbasket.reusablecomponents.WebDriverHelper;
import com.mindtree.bigbasket.uistore.BestSellersSearchUi;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BestSellerSelectPage {
	
	WebDriverHelper wh = new WebDriverHelper();
	public void selectBestSellerItem(WebDriver driver,ExtentReports extent,ExtentTest test,Logger log) throws PageObjectException {
		try {
			wh.clickElement(driver, BestSellersSearchUi.select);
			test.log(LogStatus.PASS, "BestSellerItem selected");
			log.info("BestSellerItem selected");
			//wh.explicitWait(driver, BestSellersSearchUi.addtocart);
//			try {
//				Thread.sleep(4000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		} catch (ReusableComponentException e) {
			// TODO Auto-generated catch block
			test.log(LogStatus.FAIL, "BestSellerItem not able to be selected");
			log.info("BestSellerItem not able to be selected");
			throw new PageObjectException("BestSellerItem not able to be selected",e);
		}
		
		try {
			wh.clickElement(driver,BestSellersSearchUi.addtocart);
			test.log(LogStatus.PASS, "Add to cart button clicked");
			log.info("Add to cart button clicked");
		} catch (ReusableComponentException e) {
			// TODO Auto-generated catch block
			test.log(LogStatus.FAIL, "Add to cart button not clicked");
			log.info("Add to cart button not clicked");
			throw new PageObjectException("Add to cart button not clicked",e);
		}
	}

}
