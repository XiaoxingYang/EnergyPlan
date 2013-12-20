package com.yxx.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yxx.model.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetSingleRouteFromGoogleServlet extends HttpServlet {

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
				
				String date = (String) request.getSession().getAttribute("date");
				String hour = (String) request.getSession().getAttribute("hour");
				String minute = (String) request.getSession().getAttribute("minute");
				String departure = (String) request.getSession().getAttribute("departure");
				String destination = (String) request.getSession().getAttribute("destination");
				departure = departure.replaceAll("'", "");
				destination = destination.replaceAll("'", "");
				String driving = request.getParameter("driving");
				String bicycling = request.getParameter("bicycling");
				if(driving!=null){
					int people = Integer.parseInt((String)request.getSession().getAttribute("people"));
					new JSONObject();
					JSONObject json = JSONObject.fromObject(driving);
					//System.out.println(json);
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
						//System.out.println(departure+destination+"DRIVING"+i+leavingTime+arrivingTime+Integer.parseInt(duration)+durationText+Integer.parseInt(distance)+distanceText+people);
						tbo.addTransport(departure, destination, "DRIVING", i, leavingTime, arrivingTime, Integer.parseInt(duration), durationText, Integer.parseInt(distance), distanceText, people);
					}
					String type = (String) request.getSession().getAttribute("type");
					ArrayList al = tbo.getTransportByType(departure, destination, type);
					int routeNo = tbo.getRouteNoByType(departure, destination, type);
					request.setAttribute("routeNo", routeNo);
					request.setAttribute("result", al);
				    request.getRequestDispatcher("showSingleRoute.jsp").forward(request, response);
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
						String leavingTime = date+" "+hour+":"+minute+":00";
						int i_duration = Integer.parseInt(duration);
						int i_minute = (Integer.parseInt(minute)+i_duration/60)%60;
						int i_hour = (Integer.parseInt(hour)+i_duration/3600)%24;
						String s_minute = i_minute < 10 ? ("0"+i_minute):(""+i_minute);
						String s_hour = i_minute < 10 ? ("0"+i_hour):(""+i_hour);
						String arrivingTime = date+" "+s_hour+":"+s_minute+":00";
						tbo.addTransport(departure, destination, "BICYCLING", i, leavingTime, arrivingTime, Integer.parseInt(duration), durationText, Integer.parseInt(distance), distanceText, 1);
					}
					String type = (String) request.getSession().getAttribute("type");
					ArrayList al = tbo.getTransportByType(departure, destination, type);
					int routeNo = tbo.getRouteNoByType(departure, destination, type);
					request.setAttribute("routeNo", routeNo);
					request.setAttribute("result", al);
				    request.getRequestDispatcher("showSingleRoute.jsp").forward(request, response);
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
