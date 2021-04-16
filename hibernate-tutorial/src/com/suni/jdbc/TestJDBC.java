package com.suni.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;



public class TestJDBC {

	public static void main(String[] args) {
		String jdbcUrl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&severTimezone=UTC";
		String user="hbstudent";
		String pass="hbstudent";
		try {
			System.out.println("Conntecting to DB...");
			Connection myConn=DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println("Connection successful");
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
