package com.mindtree.bigbasket.utilities;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.mindtree.bigbasket.runner.RunnerTest;

public class ScreenShot {

	public static String capture() throws IOException {
		TakesScreenshot shot = (TakesScreenshot)RunnerTest.driver;
		
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy_mm_dd_hh_mm_ss");
		String path = System.getProperty("user.dir")+"/screenshots/"+formatDate.format(new Date())+".png";
		File src=shot.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		
		FileUtils.copyFile(src, dest);
		
		return path;
	}

}
