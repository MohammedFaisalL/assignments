package com.te.jdbcfirst;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadFromPropertiesFile {

	public static void main(String[] args) {
		try {
			FileInputStream fileInputStream = new FileInputStream("directory.properties");
			Properties properties = new Properties();
			
			properties.load(fileInputStream);
			
			System.out.println("1st data: "+properties.getProperty("Akash1"));
			System.out.println("2nd data: "+properties.getProperty("Akash2"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
