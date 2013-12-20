package com.yxx.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yxx.model.DecisionBeanOperator;
import com.yxx.model.GenerateChart;
import com.yxx.model.GenerateHouseChart;
import com.yxx.model.GenerateTotalChart;
import com.yxx.model.HomeDecisionOperation;

public class AddHouseServlet extends HttpServlet {

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
			float carbon = Float.parseFloat(request.getParameter("carbon"));
			int homehour = Integer.parseInt(request.getParameter("homehour"));
			HomeDecisionOperation hdo = new HomeDecisionOperation();
			hdo.addDecision(username, homehour, carbon);

			GenerateHouseChart gc = new GenerateHouseChart();
			gc.generateChart(username);
			
			GenerateTotalChart gc2 = new GenerateTotalChart();
			gc2.generateChart(username);
			
			request.getRequestDispatcher("ShowHomeDecisionServlet").forward(request, response);
			
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
