package com.yxx.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yxx.model.*;
public class SaveSessionServlet extends HttpServlet {

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

		String username = (String)request.getSession().getAttribute("username");
		if(username==null){
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}else{
			
			String departure = request.getParameter("departure");
			String destination = request.getParameter("destination");
			String date = request.getParameter("date");
			String hour = request.getParameter("hour");
			String minute = request.getParameter("minute");
			String people = request.getParameter("people");
			String type = request.getParameter("type");
			
			try {

			    request.getSession().setAttribute("departure", departure);
			    request.getSession().setAttribute("destination", destination);
			    request.getSession().setAttribute("date", date);
			    request.getSession().setAttribute("hour", hour);
			    request.getSession().setAttribute("minute", minute);
			    request.getSession().setAttribute("people", people);
			    request.getSession().setAttribute("type", type);
			    
			    String temp = request.getHeader("Referer");
			    int index = temp.lastIndexOf("/");
			    int length = temp.length();
			    String resource = temp.substring(index+1, length-4);
			    if(resource.equalsIgnoreCase("journeyplan")){
			    	request.getRequestDispatcher("getRoutFromGoogle.jsp").forward(request, response);
			    }else if(resource.equalsIgnoreCase("findCarRoute")){
			    	request.getRequestDispatcher("getCarRouteFromGoogle.jsp").forward(request, response);
			    }else if(resource.equalsIgnoreCase("findBicycleRoute")){
			    	request.getRequestDispatcher("getBicycleRouteFromGoogle.jsp").forward(request, response);
			    }
			    else{
			    	request.getRequestDispatcher("getRoutFromGoogle.jsp").forward(request, response);
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

		doGet(request,response);
	}

}
