package com.mindtree.bigbasket.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropertyReader {
	
	Properties prop=new Properties();

	public ConfigPropertyReader() {
		BufferedReader reader = null;
		 try {
			reader = new BufferedReader(new FileReader("./testdata/Configuration.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 System.setProperty("org.freemarker.loggerLibrary", "none");
		 
		 try {
			prop.load(reader);
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	public String getDriverPath() {
		String path = prop.getProperty("driverpath");
		return path;
	}
	
	public String getURL() {
		String url = prop.getProperty("url");
		return url;
	}
	
	public long getWait() {
		String w=prop.getProperty("wait");
		Long wait = new Long(w);
		return wait;
	}
	
	public String getUserName() {
		String username=prop.getProperty("username");
		return username;
	}
	
	public String getUserPassword() {
		String username=prop.getProperty("password");
		return username;
	}

}
