package com.yxx.model;

import java.sql.*;
import java.util.ArrayList;

public class HomeDecisionOperation {
	private Connection conn=null;
	private Statement statement = null;
	private ResultSet rs = null;
	
	private int pageSize=8;
	private int rowCount=0;
	private int pageCount=0;
	
	public void addDecision(String username, int homehour, float carbon){
		
		int decisionId = this.getDecisionCount(username)+1;
		
		try {
			conn = new ConnDB().getConn();
			statement=conn.createStatement();
			statement.executeUpdate("insert into homedecision values ('"
					+username+"','"+decisionId+"','"+carbon+"','"+homehour+"')");
			
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
			rs=statement.executeQuery("select count(*) from homedecision where username='"+username+"'");
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
			rs=statement.executeQuery("select sum(carbon) from homedecision where decisionId<="+index);
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
			rs=statement.executeQuery("select count(*) from homedecision where username='"+username+"'");
			
			if(rs.next()){
				rowCount = rs.getInt(1);
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
			
			rs=statement.executeQuery("select * from homedecision where username='"
					+username+"' order by decisionId desc limit " +pageSize*(pageNow-1)+","+pageSize);
	    	
			while(rs.next()){
				HomeDecisionBean tb = new HomeDecisionBean();
				tb.setDecisionId(rs.getInt(2));
				tb.setHomehour(rs.getInt(4));
				tb.setCarbon(rs.getFloat(3));
				
				
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
			
			rs=statement.executeQuery("select * from homedecision where username='"
					+username+"' order by decisionId");
	    	
			while(rs.next()){
				HomeDecisionBean tb = new HomeDecisionBean();
				tb.setDecisionId(rs.getInt(2));
				tb.setCarbon(rs.getFloat(3));
				tb.setHomehour(rs.getInt(4));
				
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
