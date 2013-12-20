package com.yxx.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yxx.model.HouseBeanOperation;
import com.yxx.model.UserBeanOperator;

public class PersonInfoEditServlet extends HttpServlet {

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
			String user = (String)request.getSession().getAttribute("username");
			String password = request.getParameter("password");
			String usertype = request.getParameter("usertype");
			String email = request.getParameter("email");
			String homeaddr = request.getParameter("homeaddr");
			String workingAddr = request.getParameter("workingAddr");
			String meetingAddr = request.getParameter("meetingAddr");
			String leisureAddr = request.getParameter("leisureAddr");
			String frequentAddr = request.getParameter("frequentAddr");
			String plan = request.getParameter("plan");
			float carbonplan = Float.parseFloat(request.getParameter("carbonplan"));
			String housetype = request.getParameter("housetype");
			int housepeople = Integer.parseInt(request.getParameter("housepeople"));
			String heattype = request.getParameter("heattype");
			String temperature = request.getParameter("temperature");
			UserBeanOperator ubo = new UserBeanOperator();
			ubo.updateUserInfo(user, password, usertype, email, homeaddr, workingAddr, meetingAddr, leisureAddr, frequentAddr, plan, carbonplan);
			HouseBeanOperation hbo = new HouseBeanOperation();
			hbo.updateUserHouse(user, housetype, housepeople, heattype, temperature);
			request.getRequestDispatcher("ShowPersonInfoServlet").forward(request, response);
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
