package models;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

public static Connection createConnection() {
	
	Connection con = null;
	String url = "jdbc:mysql://localhost:3306/studentdb";
	String username = "root";
	String password = "D1996.11.06Dd";
	
	try {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		con = DriverManager.getConnection(url, username, password);
		System.out.println("Printing connection object" + con);
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return con;
	
}}


	
	
	
	
	
	
	
	
