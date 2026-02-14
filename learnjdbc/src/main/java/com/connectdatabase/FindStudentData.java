package com.connectdatabase;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class FindStudentData {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/school";
		String un = "postgres";
		String pwd = "123456789";
		
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection connect = DriverManager.getConnection(url, un, pwd);
			Statement st = connect.createStatement();
			
			String sql = "select * from student";
			ResultSet res = st.executeQuery(sql);
			
			while(res.next()) {
				System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getString(4));
			}
		}
		catch(ClassNotFoundException e) {
			System.out.println("Class Not Found Exception");
		}
		catch(SQLException e) {
			System.out.println("SQL Exception");
		}
	}
}
