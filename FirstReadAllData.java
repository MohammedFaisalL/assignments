package com.te.jdbcfirst;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class FirstReadAllData {

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
			ResultSet resultSet = statement.executeQuery(properties.getProperty("selectAllQuery"));

			while (resultSet.next()) {
				System.out.println(" Id = " + resultSet.getInt(1));
				System.out.println(" Name = " + resultSet.getString(2));
				System.out.println(" Date = " + resultSet.getString(3));
				System.out.println(" Address = " + resultSet.getString(4));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
