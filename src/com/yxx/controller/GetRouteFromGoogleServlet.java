package com.yxx.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yxx.model.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetRouteFromGoogleServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String u = (String)request.getSession().getAttribute("username");
		if(u==null){
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}else{
			try {
				TransportBeanOperator tbo=new TransportBeanOperator(); 
				
				tbo.clearTransport();
				
				int people = Integer.parseInt((String)request.getSession().getAttribute("people"));
				String date = (String) request.getSession().getAttribute("date");
				String hour = (String) request.getSession().getAttribute("hour");
				hour = Integer.parseInt(hour) < 10 ? ("0"+hour):(""+hour);
				String minute = (String) request.getSession().getAttribute("minute");
				minute = Integer.parseInt(minute) < 10 ? ("0"+minute):(""+minute);
				String departure = (String) request.getSession().getAttribute("departure");
				departure = departure.replaceAll("'", "");
				String destination = (String) request.getSession().getAttribute("destination");
				destination = destination.replaceAll("'", "");
				String driving = request.getParameter("driving");
				String walking = request.getParameter("walking");
				String bicycling = request.getParameter("bicycling");
				String transit = request.getParameter("transit");
				
				if(driving!=null){
					new JSONObject();
					JSONObject json = JSONObject.fromObject(driving);
					
					JSONArray RoutesArray = json.getJSONArray("driving");
					for(int i = 0; i < RoutesArray.size(); i ++){
						JSONObject routesJson = RoutesArray.getJSONObject(i);
						String distanceText = routesJson.getString("distanceText");
						String distance = routesJson.getString("distance");
						String durationText = routesJson.getString("durationText");
						String duration = routesJson.getString("duration");
						String leavingTime = date+" "+hour+":"+minute+":00";
						int i_duration = Integer.parseInt(duration);
						int i_minute = (Integer.parseInt(minute)+i_duration/60)%60;
						int i_hour = (Integer.parseInt(hour)+i_duration/3600)%24;
						String s_minute = i_minute < 10 ? ("0"+i_minute):(""+i_minute);
						String s_hour = i_minute < 10 ? ("0"+i_hour):(""+i_hour);
						String arrivingTime = date+" "+s_hour+":"+s_minute+":00";
						tbo.addTransport(departure, destination, "DRIVING", i, leavingTime, arrivingTime, Integer.parseInt(duration), durationText, Integer.parseInt(distance), distanceText, people);
					}
				}
				if(walking!=null){
					new JSONObject();
					JSONObject json = JSONObject.fromObject(walking);
					
					JSONArray RoutesArray = json.getJSONArray("walking");
					for(int i = 0; i < RoutesArray.size(); i ++){
						JSONObject routesJson = RoutesArray.getJSONObject(i);
						String distanceText = routesJson.getString("distanceText");
						String distance = routesJson.getString("distance");
						String durationText = routesJson.getString("durationText");
						String duration = routesJson.getString("duration");
//						System.out.println("walking:"+durationText+" "+distanceText);					
						String leavingTime = date+" "+hour+":"+minute+":00";
						int i_duration = Integer.parseInt(duration);
						int i_minute = (Integer.parseInt(minute)+i_duration/60)%60;
						int i_hour = (Integer.parseInt(hour)+i_duration/3600)%24;
						String s_minute = i_minute < 10 ? ("0"+i_minute):(""+i_minute);
						String s_hour = i_minute < 10 ? ("0"+i_hour):(""+i_hour);
						String arrivingTime = date+" "+s_hour+":"+s_minute+":00";
						tbo.addTransport(departure, destination, "WALKING", i, leavingTime, arrivingTime, Integer.parseInt(duration), durationText, Integer.parseInt(distance), distanceText, people);
					}
				}
				
				if(bicycling!=null){
					new JSONObject();
					JSONObject json = JSONObject.fromObject(bicycling);
					
					JSONArray RoutesArray = json.getJSONArray("bicycling");
					for(int i = 0; i < RoutesArray.size(); i ++){
						JSONObject routesJson = RoutesArray.getJSONObject(i);
						String distanceText = routesJson.getString("distanceText");
						String distance = routesJson.getString("distance");
						String durationText = routesJson.getString("durationText");
						String duration = routesJson.getString("duration");
//						System.out.println("bicycling:"+durationText+" "+distanceText);					
						String leavingTime = date+" "+hour+":"+minute+":00";
						int i_duration = Integer.parseInt(duration);
						int i_minute = (Integer.parseInt(minute)+i_duration/60)%60;
						int i_hour = (Integer.parseInt(hour)+i_duration/3600)%24;
						String s_minute = i_minute < 10 ? ("0"+i_minute):(""+i_minute);
						String s_hour = i_minute < 10 ? ("0"+i_hour):(""+i_hour);
						String arrivingTime = date+" "+s_hour+":"+s_minute+":00";
						
						tbo.addTransport(departure, destination, "BICYCLING", i, leavingTime, arrivingTime, Integer.parseInt(duration), durationText, Integer.parseInt(distance), distanceText, people);
					}
				}
				if(transit!=null){
					new JSONObject();
					JSONObject json = JSONObject.fromObject(transit);
					
					JSONArray RoutesArray = json.getJSONArray("transit");
					for(int i = 0; i < RoutesArray.size(); i ++){
						JSONObject routesJson = RoutesArray.getJSONObject(i);
						String distanceText = routesJson.getString("distanceText");
						String distance = routesJson.getString("distance");
						String durationText = routesJson.getString("durationText");
						String duration = routesJson.getString("duration");					
						String lt = routesJson.getString("departure_time");
						String[] aa = lt.split(" ");
						String leavingTime = date+" "+aa[4];
						String at = routesJson.getString("arrival_time");
						String[] ab = at.split(" ");
						String arrivingTime = date+" "+ab[4];
						tbo.addTransport(departure, destination, "TRANSIT", i, leavingTime, arrivingTime, Integer.parseInt(duration), durationText, Integer.parseInt(distance), distanceText, people);
					}
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
