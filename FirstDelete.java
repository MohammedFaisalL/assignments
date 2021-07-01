package com.te.jdbcfirst;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class FirstDelete {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;

		try {
			FileInputStream fileInputStream = new FileInputStream("dbInfo.properties");
			Properties properties = new Properties();

			properties.load(fileInputStream);

			Class.forName(properties.getProperty("driver"));
			connection = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("user"),
					properties.getProperty("password"));
			statement = connection.createStatement();
			int result = statement.executeUpdate(properties.getProperty("deleteQuery"));

			if (result != 0) {
				System.out.println(result + " rows affected");
				System.out.println("deleted succesfully!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
