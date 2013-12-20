package com.yxx.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserBeanOperator {
	private Connection conn=null;
	private Statement statement = null;
	private ResultSet rs = null;
	
	public boolean checkUser(String username, String password){
		boolean valid = false;
		try {
			conn = new ConnDB().getConn();
			statement=conn.createStatement();
			rs=statement.executeQuery("select passwd from userinfo where username='"+username+"'");
			if(rs.next()){
				if(rs.getString(1).equals(password)){
					valid=true;
				}else{
					valid=false;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close();
		}
		return valid;
	}
	
	public boolean checkExisting(String username){
//		System.out.println("checkexisting");
		boolean existing = false;
		try {
			conn = new ConnDB().getConn();
			statement=conn.createStatement();
			rs=statement.executeQuery("select * from userinfo where username='"+username+"'");
			
			if(rs.next()){
				existing=true;
			}else{
				existing=false;
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close();
		}
		return existing;
	}
	
	public void register(String username, String password, String email, String identity, String homeaddr, String workingaddr, String meetingaddr, String leisureaddr, String frequentaddr, String plan, float carbonplan){
//		System.out.println("register");
		try {
			conn = new ConnDB().getConn();
			statement=conn.createStatement();
			statement.executeUpdate("insert into userinfo values ('"+username+"','"+password+"','"+identity+"','"+email+"','"+homeaddr+"','"+workingaddr+"','"+meetingaddr+"','"+leisureaddr+"','"+frequentaddr+"','"+plan+"','"+carbonplan+"')");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close();
		}
	}
	
	public String getPlan(String username){
		String plan=null;
		try {
			conn = new ConnDB().getConn();
			statement=conn.createStatement();
			rs=statement.executeQuery("select * from userinfo where username='"+username+"'");
			if(rs.next()){
				plan=rs.getString(10);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close();
		}
		return plan;
	}
	
	public float getCarbonplan(String username){
		float carbonplan=0;
		try {
			conn = new ConnDB().getConn();
			statement=conn.createStatement();
			rs=statement.executeQuery("select * from userinfo where username='"+username+"'");
			if(rs.next()){
				carbonplan=rs.getFloat(11);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close();
		}
		return carbonplan;
	}
	
	public String getHomeAddr(String username){
		String homeAddr=null;
		try {
			conn = new ConnDB().getConn();
			statement=conn.createStatement();
			rs=statement.executeQuery("select homeaddr from userinfo where username="+username);
			if(rs.next()){
				homeAddr=rs.getString(5);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close();
		}
		return homeAddr;
	}
	
	public void updateUserInfo(String user, String password, String usertype, String email, String homeaddr, String workingaddr, String meetingaddr, String leisureaddr, String frequentaddr, String plan, Float carbonplan){
		try {
			conn = new ConnDB().getConn();
			statement=conn.createStatement();
			statement.executeUpdate("update userinfo set passwd='"+password+"',usertype='"+usertype+"',email='"+email+"',homeaddr='"+homeaddr+"',workingaddr='"+workingaddr+"',meetingaddr='"+meetingaddr+"',leisureaddr='"+leisureaddr+"',frequentaddr='"+frequentaddr+"',plan='"+plan+"',carbonplan='"+carbonplan+"' where username='"+user+"'");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public ArrayList getUserInfo(String username){
		ArrayList al = new ArrayList();
		try {
			conn = new ConnDB().getConn();
			statement=conn.createStatement();
			rs=statement.executeQuery("select * from userinfo where username='"+username+"'");
			
			while(rs.next()){
				UserBean tb = new UserBean();
				tb.setUsername(rs.getString(1));
				tb.setPasswd(rs.getString(2));
				tb.setUsertype(rs.getString(3));
				tb.setEmail(rs.getString(4));
				tb.setHomeaddr(rs.getString(5));
				tb.setWorkingaddr(rs.getString(6));
				tb.setMeetingaddr(rs.getString(7));
				tb.setLeisureaddr(rs.getString(8));
				tb.setFrequentaddr(rs.getString(9));
				tb.setPlan(rs.getString(10));
				tb.setCarbonplan(rs.getFloat(11));
				
				al.add(tb);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close();
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
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
