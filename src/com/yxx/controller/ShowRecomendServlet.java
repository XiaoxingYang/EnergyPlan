package com.yxx.controller;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yxx.model.TransportBeanOperator;
import com.yxx.model.UserBeanOperator;

public class ShowRecomendServlet extends HttpServlet {

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
			try {
				String departure = (String) request.getSession().getAttribute("departure");
				String destination = (String) request.getSession().getAttribute("destination");
				departure = departure.replaceAll("'", "");
				destination = destination.replaceAll("'", "");
				UserBeanOperator ubo = new UserBeanOperator();
				String plan = ubo.getPlan(username);
				
				TransportBeanOperator tbo=new TransportBeanOperator(); 
			    ArrayList al = tbo.getOptimalTransport(departure,destination, plan);
			    
			    request.setAttribute("result", al);
			    
			    request.getRequestDispatcher("searchresult.jsp").forward(request, response);

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
