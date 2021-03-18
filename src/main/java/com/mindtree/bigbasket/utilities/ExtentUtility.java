package com.mindtree.bigbasket.utilities;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mindtree.bigbasket.runner.RunnerTest;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentUtility {
	
	public static String fileLoc=null;

	public void getExtent() {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy_mm_dd_hh_mm_ss");
		fileLoc=dateformat.format(new Date())+".html";
		RunnerTest.extent=new ExtentReports("./reports/"+fileLoc,true);
	}
	
	public void startTest(ExtentReports extent,Method method) {
		RunnerTest.test=extent.startTest(this.getClass().getSimpleName()+"::"+method.getName(),method.getName());
	}
	
	public void endExtent() {
		RunnerTest.extent.flush();
		RunnerTest.extent.close();
	}

}
