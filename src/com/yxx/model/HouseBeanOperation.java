package com.yxx.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class HouseBeanOperation {

	private Connection conn=null;
	private Statement statement = null;
	private ResultSet rs = null;
	
	public void save(String username, String housetype, int housepeople, String heattype, String temperature){
		try {
			conn = new ConnDB().getConn();
			statement=conn.createStatement();
			statement.executeUpdate("insert into userhouse values ('"+username+"','"+housetype+"','"+housepeople+"','"+heattype+"','"+temperature+"')");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close();
		}
	}
	
	public ArrayList getHouseInfo(String username){
		ArrayList al = new ArrayList();
		try {
			conn = new ConnDB().getConn();
			statement=conn.createStatement();
			rs=statement.executeQuery("select * from userhouse where username='"+username+"'");
			
			while(rs.next()){
				HouseBean tb = new HouseBean();
				tb.setUsername(rs.getString(1));
				tb.setHousetype(rs.getString(2));
				tb.setPeople(rs.getInt(3));
				tb.setHeattype(rs.getString(4));
				tb.setTemperature(rs.getString(5));
				
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
	
	public void updateUserHouse(String username, String housetype, int housepeople, String heattype, String temperature){
		try {
			conn = new ConnDB().getConn();
			statement=conn.createStatement();
			statement.executeUpdate("update userhouse set housetype='"+housetype+"',housepeople='"+housepeople+"',heattype='"+heattype+"',temperature='"+temperature+"' where username='"+username+"'");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public float calculateCarbon(String username, int homehour){
		float houseCarbon = 1;
		ArrayList al = this.getHouseInfo(username);
		HouseBean hb = new HouseBean();
		if(al!=null){
			hb = (HouseBean) al.get(0);
			String heattype = hb.getHeattype();
			String housetype = hb.getHeattype();
			if(housetype.equalsIgnoreCase("small house/flat")){
				if(heattype.equalsIgnoreCase("gas")){
					houseCarbon = (float) (12000*0.203);
				}else{
					houseCarbon = (float) (3000*0.517);
				}
			}else if(housetype.equalsIgnoreCase("medium")){
				if(heattype.equalsIgnoreCase("gas")){
					houseCarbon = (float) (18000*0.203);
				}else{
					houseCarbon = (float) (4800*0.517);
				}
			}else{
				if(heattype.equalsIgnoreCase("gas")){
					houseCarbon = (float) (27000*0.203);
				}else{
					houseCarbon = (float) (7000*0.517);
				}
			}
			int people = hb.getPeople();
			houseCarbon/=people;
			String temperature = hb.getTemperature();
			if(temperature.equalsIgnoreCase("cool")){
				houseCarbon/=1.2;
			}else if(temperature.equalsIgnoreCase("warm")){
				houseCarbon*=1.2;
			}else if(temperature.equalsIgnoreCase("hot")){
				houseCarbon*=1.4;
			}else{
				
			}
			houseCarbon = houseCarbon/365/24*homehour;
			return houseCarbon;
		}else{
			return 0;
		}
		
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
