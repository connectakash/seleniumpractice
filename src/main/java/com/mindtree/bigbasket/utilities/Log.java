package com.mindtree.bigbasket.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.mindtree.bigbasket.runner.RunnerTest;

public class Log {

	static {
		SimpleDateFormat format = new SimpleDateFormat("yyyy_mm_dd_hh_mm_ss");
		System.setProperty("current.date.time", format.format(new Date()));
	}
	
	public static void setLogger() {
		RunnerTest.logger=Logger.getLogger(RunnerTest.class);
	}
	
}
