package com.example.personmanagement;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	static Connection con;
	public static Connection createCon() {
		String url = "jdbc:mysql://localhost:3306/person";
		String user = "root";
		String password = "1234";
		
		//Step 1: Load the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		}catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
	
	
}
