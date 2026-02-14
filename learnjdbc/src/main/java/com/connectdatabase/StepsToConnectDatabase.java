package com.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StepsToConnectDatabase {
	public static void main(String[] args) {
		// Load the driver class
		
		String url = "jdbc:postgresql://localhost:5432/school";
		String un = "postgres";
		String pwd = "123456789";
		
		try {
			Class.forName("org.postgresql.Driver");
			
			// to establish connection
			Connection connect = DriverManager.getConnection(url, un, pwd);
			String sql = "insert into student values(108, 'avni', 'avni@gmail.com', 'female'), (109, 'palak', 'palak@gmail.com', 'female')";
			
			// create statement
			Statement st = connect.createStatement();
			
			// Execute query
			st.execute(sql);
			
			connect.close();
			System.out.println("Data inserted");
		} 
		catch (ClassNotFoundException e) {
			System.out.println("Class Not Found Exception");
		}
		catch(SQLException e){
			System.out.println("SQl Exception");
		}
	}
}