package com.niit.crud.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	//Database Configuration
	private static final String DRIVER = "org.h2.Driver";
	private static final String URL = "jdbc:h2:tcp://localhost/~/testDemo";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "";
	
	//Connection Object
	private static Connection connection = null;
	
	//Initializing connection object
	public static Connection getConnection(){
		if(connection != null){
			return connection;
		}else{
			try {
				Class.forName(DRIVER);
				System.out.println("Driver Loaded!");
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				System.out.println("Connection Established!");
			} catch (SQLException e) {
				System.out.println("SQL Error: "+e.getMessage());
			} catch (ClassNotFoundException e) {
				System.out.println("Driver Error: "+e.getMessage());
			}
			return connection;
		}
	}
}
