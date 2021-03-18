package com.mindtree.bigbasket.utilities;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.mindtree.bigbasket.runner.RunnerTest;
import com.relevantcodes.extentreports.LogStatus;

public class Listener implements ITestListener{

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
		
		try {
			RunnerTest.test.log(LogStatus.PASS, "<a href='"+ScreenShot.capture()+"'>"+RunnerTest.test.getTest().getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		try {
			RunnerTest.test.log(LogStatus.FAIL, "<a href='"+ScreenShot.capture()+"'>"+RunnerTest.test.getTest().getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
