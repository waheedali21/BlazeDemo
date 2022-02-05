package com.qa.roughwork;

import java.io.FileInputStream;
import java.util.Properties;

public class RoughWork {

	public static void main(String[] args) throws Exception {
		
		
		Properties prop;
		FileInputStream fis;
		
		prop = new Properties();
		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\blaze\\congif\\config.properties");
		prop.load(fis);
		
	//	System.out.println(prop.getProperty("Browser"));
		
		//Path of the project
		System.out.println(System.getProperty("user.dir")); //C:\Eclipse2019\BlazeDemo
		

	}

}
