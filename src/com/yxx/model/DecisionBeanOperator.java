package com.yxx.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DecisionBeanOperator {
	
	private Connection conn=null;
	private Statement statement = null;
	private ResultSet rs = null;
	
	private int pageSize=8;
	private int rowCount=0;
	private int pageCount=0;
	
	public void addDecision(String username, String departure, String destination, String departureTime, String arriveTime, String vehicle, int distance, float carbon){
		
		destination = destination.replaceAll("'", "");
		departure = departure.replaceAll("'", "");
		
		int decisionId = this.getDecisionCount(username)+1;
		
		try {
			conn = new ConnDB().getConn();
			statement=conn.createStatement();
			statement.executeUpdate("insert into userdecision values ('"
					+decisionId+"','"+username+"','"+departure+"','"+destination+
					"','"+departureTime+"','"+arriveTime+"','"+vehicle+"','"+
					distance+"','"+carbon+"')");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close();
		}
	}
	
	public int getDecisionCount(String username){
		int decisionNumber = 0;
		try {
			conn = new ConnDB().getConn();
			statement=conn.createStatement();
			rs=statement.executeQuery("select count(*) from userdecision where username='"+username+"'");
			if(rs.next()){
				decisionNumber = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close();
		}
		return decisionNumber;
		
	}
	
	public float getCarbonAccumulation(int index){
		float accumulation = 0;
		try {
			conn = new ConnDB().getConn();
			statement=conn.createStatement();
			rs=statement.executeQuery("select sum(carbon) from userdecision where decisionId<="+index);
			if(rs.next()){
				accumulation = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close();
		}
		return accumulation;
		
	}
	
	public int getPageCount(String username){
		
		try{
			conn = new ConnDB().getConn();
			statement=conn.createStatement();
			rs=statement.executeQuery("select count(*) from userdecision where username='"+username+"'");
			
			if(rs.next()){
				rowCount = rs.getInt(1);
				//System.out.println("count"+rs.getInt(1));
			}
			if(rowCount%pageSize==0){
				pageCount=rowCount/pageSize;
			}else{
				pageCount=rowCount/pageSize+1;
			}
	    	
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			this.close();
		}
		return pageCount;
	}
	
	public ArrayList getDecisionByPage(int pageNow,String username){
		
		ArrayList al = new ArrayList();
		
		try{
			conn = new ConnDB().getConn();
			statement = conn.createStatement();
			
			rs=statement.executeQuery("select * from userdecision where username='"
					+username+"' order by decisionId desc limit " +pageSize*(pageNow-1)+","+pageSize);
	    	//rs=statement.executeQuery("select * from transport limit 3,3");
	    	
			while(rs.next()){
				DecisionBean tb = new DecisionBean();
				tb.setDecisionId(rs.getInt(1));
				tb.setDeparture(rs.getString(3));
				tb.setDestination(rs.getString(4));
				tb.setDepartureTime(rs.getString(5));
				tb.setArriveTime(rs.getString(6));
				tb.setVehicle(rs.getString(7));
				tb.setDistance(rs.getInt(8));
				tb.setCarbon(rs.getFloat(9));
				
				
				al.add(tb);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			this.close();
		}
		return al;
	}
	
	public ArrayList getAllDecisions(String username){
		ArrayList al = new ArrayList();
		
		try{
			conn = new ConnDB().getConn();
			statement = conn.createStatement();
			
			rs=statement.executeQuery("select * from userdecision where username='"
					+username+"' order by decisionId");
	    	
			while(rs.next()){
				DecisionBean tb = new DecisionBean();
				tb.setDecisionId(rs.getInt(1));
				tb.setDeparture(rs.getString(3));
				tb.setDestination(rs.getString(4));
				tb.setDepartureTime(rs.getString(5));
				tb.setArriveTime(rs.getString(6));
				tb.setVehicle(rs.getString(7));
				tb.setDistance(rs.getInt(8));
				tb.setCarbon(rs.getFloat(9));
				
				al.add(tb);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			this.close();
		}
		return al;
	}
	
	
	public void close(){
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
}
