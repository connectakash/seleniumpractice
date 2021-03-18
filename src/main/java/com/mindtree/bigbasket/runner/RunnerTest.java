package com.mindtree.bigbasket.runner;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mindtree.bigbasket.exceptions.PageObjectException;
import com.mindtree.bigbasket.pageobjects.BestSellerSelectPage;
import com.mindtree.bigbasket.pageobjects.CheckCartPage;
import com.mindtree.bigbasket.pageobjects.SearchPage;
import com.mindtree.bigbasket.reusablecomponents.BrowserHelper;
import com.mindtree.bigbasket.reusablecomponents.WebDriverHelper;
import com.mindtree.bigbasket.utilities.ConfigPropertyReader;
import com.mindtree.bigbasket.utilities.EmailSending;
import com.mindtree.bigbasket.utilities.ExcelReader;
import com.mindtree.bigbasket.utilities.ExtentUtility;
import com.mindtree.bigbasket.utilities.Listener;
import com.mindtree.bigbasket.utilities.Log;
import com.mindtree.bigbasket.utilities.ProgressBar;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



@Listeners(Listener.class)
public class RunnerTest {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static Logger logger=null;
	
	BrowserHelper bh = new BrowserHelper();
	WebDriverHelper wh = new WebDriverHelper();
	ExtentUtility eutil = new ExtentUtility();
	SearchPage spage =new SearchPage();
	BestSellerSelectPage bp = new BestSellerSelectPage();
	ProgressBar p = new ProgressBar();
	CheckCartPage cp = new CheckCartPage();
	ConfigPropertyReader reader = new ConfigPropertyReader();
	ExcelReader ereader = new ExcelReader();
	
	
	
	
	@BeforeSuite
	void beforeSuite() {
		Log.setLogger();
		driver=bh.getBrowser();
		eutil.getExtent();
		p.setUpProgressBar(4);
	}
	
	@BeforeTest
	void beforeTest() {
		wh.OpenUrl(driver);
	}
	
	@BeforeMethod
	void beforeMethod(Method method) {
		eutil.startTest(extent, method);
	}
	
	@AfterSuite
	void afterSuite() {
		eutil.endExtent();
		EmailSending.sendEmail(reader.getUserName(), reader.getUserPassword());
	}
	
	@AfterTest
	void afterTest() {
		driver.close();
		driver.quit();
	}
	
	@AfterMethod
	void afterMethod() {
		p.increaseProgressBar();
		extent.endTest(test);
	}
	
	@DataProvider
	public Iterator<String> getItems() throws Exception{
		ArrayList<String> myData = ereader.getDataExcel();
			return myData.iterator();
	}
	
	@Test(priority = 1,dataProvider = "getItems")
	void searchItems(String item) {
		try {
			spage.searchItem(driver, extent, test, logger,item);
		} catch (PageObjectException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	
	
	@Test(priority = 3)
	void BestSellerItem() {
		try {
			bp.selectBestSellerItem(driver, extent, test, logger);
		} catch (PageObjectException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	@Test(priority = 2)
	void cartcheck() {
		try {
			cp.CheckCart(driver, extent, test, logger);
		} catch (PageObjectException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		//driver.findElement(By.xpath("//a[@class='bb-expressdesktop-link']")).click();
	}
	
	
}
