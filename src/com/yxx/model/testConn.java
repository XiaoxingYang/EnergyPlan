package com.yxx.model;

import java.sql.*;  
import java.util.ArrayList;
public class testConn { 
	public static void main(String[] args){ 
	String departure="SW112QP";
	String destination="SW72AZ";
	Connection conn=null;
	Statement statement=null;
	ResultSet rs=null;
		
	String driver = "com.mysql.jdbc.Driver"; 
	String url = "jdbc:mysql://127.0.0.1:3306/test"; 
	String user = "root"; 
	String password = "123"; 
	
	int pageSize=5;
	int pageNow=1;
	
	try { 
		Class.forName(driver); 
		conn = DriverManager.getConnection(url, user, password); 
		if(!conn.isClosed()) 
			System.out.println("Succeeded connecting to the Database!"); 
		statement = conn.createStatement(); 
		int decisionId=3;
		String username="stu001";
		String departureTime = "2013-08-04 23:32:00";
		String arriveTime = "2013-08-04 23:32:07";
		String vehicle = "smallcar";
		float distance = (float) 2.3;
		float carbon = (float) 3.2;
		
		String housetype = "a";
		int housepeople = 1;
		String heattype = "b";
		String temperature = "c";
		statement.executeUpdate("insert into userhouse values ('"+username+"','"+housetype+"','"+housepeople+"','"+heattype+"','"+temperature+"')");
//		while(rs.next()){
//			int a = rs.getInt(4);
//			System.out.println(a);
//		}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			try {
				if(rs!=null){
					rs.close();
				}
				if(statement!=null){
					statement.close();
				}
				if(conn!=null){
					conn.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	
//	TransportBeanOperator tbo = new TransportBeanOperator();
//	ArrayList al = tbo.getOptimalTransport("SW112QP", "EH1", "carbon");
//	for(int i = 1; i<=al.size();i++){
//		TransportBean tb = (TransportBean)al.get(i-1);
//		System.out.println(tb.getLeavingTime());
//		System.out.println(tb.getArrivingTime());
//	}
	
	}
}
