package com.mindtree.bigbasket.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mindtree.bigbasket.exceptions.PageObjectException;
import com.mindtree.bigbasket.exceptions.ReusableComponentException;
import com.mindtree.bigbasket.reusablecomponents.WebDriverHelper;
import com.mindtree.bigbasket.uistore.CartUi;
import com.mindtree.bigbasket.uistore.SearchItemUi;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SearchPage {
	
	WebDriverHelper wh = new WebDriverHelper();

	public void searchItem(WebDriver driver,ExtentReports extent,ExtentTest test,Logger log, String item) throws PageObjectException {
		try {
			wh.sendKeys(driver, SearchItemUi.searchBar, item);
			log.info("Keys sent to search bar");
			test.log(LogStatus.PASS, "Keys sent to Search Bar successfully");
			
			
		} catch (ReusableComponentException e) {
			// TODO Auto-generated catch block
			log.error("Unable to send keys to search bar");
			test.log(LogStatus.FAIL, "Unable to send keys to search bar");
			throw new PageObjectException("Unable to send keys to the search bar",e);
		}
		
		
		
		try {
			wh.clickElement(driver, SearchItemUi.searchButton);
			log.info("Search icon clicked successfully");
			test.log(LogStatus.PASS, "Search icon clicked successfully");
			String title=driver.getTitle();
			System.out.println(title);
			driver.navigate().back();
			driver.findElement(SearchItemUi.searchBar).clear();
			Assert.assertEquals(title, "Best Online Grocery Store in India. Save Big on Grocery Shopping | bigbasket.com");
			//wh.explicitWait(driver, CartUi.cartbutton);
		} catch (ReusableComponentException e) {
			// TODO Auto-generated catch block
			log.info("Search icon clicking Unsuccessfull");
			test.log(LogStatus.PASS, "Search icon clicking Unsuccessfull");
			throw new PageObjectException("Unable to click search icon",e);
		}
	}

}
