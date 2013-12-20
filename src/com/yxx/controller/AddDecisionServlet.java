package com.yxx.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yxx.model.*;

public class AddDecisionServlet extends HttpServlet {

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
			String departure = (String) request.getSession().getAttribute("departure");
			String destination = (String) request.getSession().getAttribute("destination");
			String vehicle = request.getParameter("vehicle");
			int routeNo = Integer.parseInt(request.getParameter("routeNo"));
			//System.out.println(vehicle+routeNo);
			
			try {
				TransportBeanOperator tbo=new TransportBeanOperator(); 
			    ArrayList al = tbo.getOneData(departure, destination, vehicle, routeNo);
			    
			    TransportBean tb=null;
			    if(al!=null){
			    	tb = (TransportBean) al.get(0);
			    }
			    
			    DecisionBeanOperator dbo = new DecisionBeanOperator();
			    dbo.addDecision(username, departure, destination, tb.getLeavingTime(), tb.getArrivingTime(), vehicle, tb.getDistance(), tb.getCarbon());
			    
			    GenerateChart gc = new GenerateChart();
				gc.generateChart(username);
				
				GenerateTotalChart gtc = new GenerateTotalChart();
				gtc.generateChart(username);
			    
			    request.getRequestDispatcher("ShowAllDecisionServlet").forward(request, response);
			    
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
