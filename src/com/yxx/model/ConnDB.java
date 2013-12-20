package com.yxx.model;

import java.sql.*;
public class ConnDB {
	private Connection conn=null;
	String driver = "com.mysql.jdbc.Driver"; 
	String url = "jdbc:mysql://127.0.0.1:3306/test"; 
	String user = "root"; 
	String password = "123";
	public Connection getConn(){
		try{
			
			Class.forName(driver); 
			conn = DriverManager.getConnection(url, user, password); 
//			if(!conn.isClosed()) {
//				System.out.println("Succeeded connecting to the Database!"); 
//			}
				
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
		
	}
}
