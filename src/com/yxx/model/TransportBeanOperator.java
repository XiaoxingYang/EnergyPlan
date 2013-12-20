package com.yxx.model;
import java.sql.*;
import java.util.ArrayList;
public class TransportBeanOperator {
	
	private Connection conn=null;
	private Statement statement = null;
	private ResultSet rs = null;
	
	private int pageSize=8;
	private int rowCount=0;
	private int pageCount=0;
	
	public void clearTransport(){
		
		try{
			conn = new ConnDB().getConn();
			statement = conn.createStatement();
			
			statement.executeUpdate("Truncate table transport");
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			this.close();
		}
	}
	
	public int getPageCount(String departure, String destination){
		destination = destination.replaceAll("'", "");
		departure = departure.replaceAll("'", "");
		try{
			conn = new ConnDB().getConn();
			statement=conn.createStatement();
			rs=statement.executeQuery("select count(*) from transport where departure='"+departure+"' and destination='"+destination+"'");
			
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
	
	public float calcCarbon(String vehicle, int distance, int people){
		float carbon = 0;
		distance/=1000;
		if(vehicle.equalsIgnoreCase("driving")){
			carbon = (float) (0.6*distance/people);
		}else if(vehicle.equalsIgnoreCase("walking")){
			carbon = (float) (0.02*distance);
		}else if(vehicle.equalsIgnoreCase("bicycling")){
			carbon = (float) (0.015*distance);
		}else if(vehicle.equalsIgnoreCase("transit")){
			carbon = (float) (0.06*distance);
		}
		return carbon;
	}
	
	public void addTransport(String departure, String destination, String vehicle, int routeNo, String leavingTime, String arrivingTime, int duration, String durationText, int distance, String distanceText, int people){
		try{
			
			destination = destination.replaceAll("'", "");
			departure = departure.replaceAll("'", "");
			
			conn = new ConnDB().getConn();
			statement = conn.createStatement();
			
			float carbon = calcCarbon(vehicle, distance, people);
			statement.executeUpdate("insert into transport values ('"+departure+"','"+
					destination+"','"+vehicle+"','"+routeNo+"','"+leavingTime+"','"+
					arrivingTime+"','"+duration+"','"+durationText+"','"+distance+"','"+
					distanceText+"','"+carbon+"')");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			this.close();
		}
		
	}
	
	public ArrayList getOptimalTransport(String departure, String destination, String plan){
		pageSize=5;

		destination = destination.replaceAll("'", "");
		departure = departure.replaceAll("'", "");
		
		ArrayList al = new ArrayList();
		
		try{
			conn = new ConnDB().getConn();
			statement = conn.createStatement();
			if(plan.equals("Time Saving")){
				int acceptedDuration = 0;
				rs = statement.executeQuery("select avg(duration) from (select * from transport order by duration limit 0,3) as temp");
				if(rs.next()){
					acceptedDuration = (int) ((rs.getInt(1)*0.3)>1800?(rs.getInt(1)*1.3):rs.getInt(1)+1800);
				}
				rs=statement.executeQuery("select * from transport where departure='"
						+departure+"' and destination='"+destination+
						"' and duration <="+acceptedDuration +
						" order by carbon limit 0,"+pageSize);
		    	
			}
			else {
				rs=statement.executeQuery("select * from transport where departure='"
						+departure+"' and destination='"+destination+
						"' and (vehicle, routeNo) not in (select vehicle, routeNo from transport " +
						"where (vehicle='WALKING' and duration >=3600) or (vehicle='BICYCLING' and duration >=3600)) " +
						"order by carbon limit 0,"+pageSize);
		    	
			}
			
			while(rs.next()){
				TransportBean tb = new TransportBean();
				tb.setDeparture(rs.getString(1));
				tb.setDestination(rs.getString(2));
				tb.setVehicle(rs.getString(3));
				tb.setRouteNo(rs.getInt(4));
				tb.setLeavingTime(rs.getString(5));
				tb.setArrivingTime(rs.getString(6));
				tb.setDuration(rs.getInt(7));
				tb.setDurationText(rs.getString(8));
				tb.setDistance(rs.getInt(9));
				tb.setDistanceText(rs.getString(10));
				tb.setCarbon(rs.getFloat(11));
				
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

	public ArrayList getTransportByPage(int pageNow,String departure,String destination){
		
		destination = destination.replaceAll("'", "");
		departure = departure.replaceAll("'", "");
		
		ArrayList al = new ArrayList();
		
		try{
			conn = new ConnDB().getConn();
			statement = conn.createStatement();
			
			rs=statement.executeQuery("select * from transport where departure='"
					+departure+"' and destination='"+destination+"' order by carbon limit "+pageSize*(pageNow-1)+","+pageSize);
	    	//rs=statement.executeQuery("select * from transport limit 3,3");
	    	
			while(rs.next()){
				TransportBean tb = new TransportBean();
				tb.setDeparture(rs.getString(1));
				tb.setDestination(rs.getString(2));
				tb.setVehicle(rs.getString(3));
				tb.setRouteNo(rs.getInt(4));
				tb.setLeavingTime(rs.getString(5));
				tb.setArrivingTime(rs.getString(6));
				tb.setDuration(rs.getInt(7));
				tb.setDurationText(rs.getString(8));
				tb.setDistance(rs.getInt(9));
				tb.setDistanceText(rs.getString(10));
				tb.setCarbon(rs.getFloat(11));
				
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
	
	public ArrayList getOneData(String departure, String destination, String vehicle, int routeNo){
		
		destination = destination.replaceAll("'", "");
		departure = departure.replaceAll("'", "");
		
		ArrayList al = new ArrayList();
		try{
			conn = new ConnDB().getConn();
			statement = conn.createStatement();
			
			rs=statement.executeQuery("select * from transport where departure='"
					+departure+"' and destination='"+destination+"' and vehicle='"+vehicle+"' and routeNo="+routeNo);
	    	
			while(rs.next()){
				TransportBean tb = new TransportBean();
				tb.setDeparture(rs.getString(1));
				tb.setDestination(rs.getString(2));
				tb.setVehicle(rs.getString(3));
				tb.setRouteNo(rs.getInt(4));
				tb.setLeavingTime(rs.getString(5));
				tb.setArrivingTime(rs.getString(6));
				tb.setDuration(rs.getInt(7));
				tb.setDurationText(rs.getString(8));
				tb.setDistance(rs.getInt(9));
				tb.setDistanceText(rs.getString(10));
				tb.setCarbon(rs.getFloat(11));
				
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
	
	public ArrayList getTransportByType(String departure, String destination, String type){

		destination = destination.replaceAll("'", "");
		departure = departure.replaceAll("'", "");
		
		ArrayList al = new ArrayList();
		
		try{
			conn = new ConnDB().getConn();
			statement = conn.createStatement();
			if(type.equals("Quickest")){
				rs=statement.executeQuery("select * from transport where departure='"
						+departure+"' and destination='"+destination+
						"' order by duration limit 0,1");
		    	
			}else{
				rs=statement.executeQuery("select * from transport where departure='"
						+departure+"' and destination='"+destination+
						"' order by distance limit 0,1");
		    	
			}
			
			while(rs.next()){
				TransportBean tb = new TransportBean();
				tb.setDeparture(rs.getString(1));
				tb.setDestination(rs.getString(2));
				tb.setVehicle(rs.getString(3));
				tb.setRouteNo(rs.getInt(4));
				tb.setLeavingTime(rs.getString(5));
				tb.setArrivingTime(rs.getString(6));
				tb.setDuration(rs.getInt(7));
				tb.setDurationText(rs.getString(8));
				tb.setDistance(rs.getInt(9));
				tb.setDistanceText(rs.getString(10));
				tb.setCarbon(rs.getFloat(11));
				
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
	
	public int getRouteNoByType(String departure, String destination, String type){
		int routeNo = 0;
		destination = destination.replaceAll("'", "");
		departure = departure.replaceAll("'", "");
		try{
			conn = new ConnDB().getConn();
			statement = conn.createStatement();
			if(type.equals("Quickest")){
				rs=statement.executeQuery("select routeNo from transport where departure='"
						+departure+"' and destination='"+destination+
						"' order by duration limit 0,1");
		    	
			}else{
				rs=statement.executeQuery("select routeNo from transport where departure='"
						+departure+"' and destination='"+destination+
						"' order by distance limit 0,1");
		    	
			}
			
			while(rs.next()){
				routeNo = rs.getInt(1);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			this.close();
		}
		return routeNo;
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
