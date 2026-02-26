package com.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DynamicInserting {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/school";
		String un = "postgres";
		String pwd = "123456789";
		
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection connect = DriverManager.getConnection(url, un, pwd);
			
			String sql = "Insert into student values(?, ?, ?, ?)";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, 110);
			ps.setString(2, "Pawan");
			ps.setString(3,  "pawan@gmail.com");
			ps.setString(4, "male");
			
			ps.executeUpdate();
			
			System.out.println("Record inserted successfully");
			ps.close();
		}
		catch(ClassNotFoundException e) {
			System.out.println("Class Not Found Exception");
		}
		catch(SQLException e) {
			System.out.println("SQL Exception");
		}
	}
}
