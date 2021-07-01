package com.te.jdbcfirst;

import java.io.FileOutputStream;
import java.util.Properties;

public class StorePropertyFile {

	public static void main(String[] args) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("directory.properties");

			Properties properties = new Properties();
			properties.setProperty("Akash1", "123456");
			properties.setProperty("Akash2", "223456");

			properties.store(fileOutputStream, "My First Properties File!!");
			System.out.println("Data Successfully Stored!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
