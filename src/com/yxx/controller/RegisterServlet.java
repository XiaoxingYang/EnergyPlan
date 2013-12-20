package com.yxx.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yxx.model.HouseBeanOperation;
import com.yxx.model.UserBeanOperator;

public class RegisterServlet extends HttpServlet {

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
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String identity = request.getParameter("usertype");
		String homeaddr = request.getParameter("homeaddr");
		String frequentaddr = request.getParameter("frequentAddr");
		String workingaddr = request.getParameter("workingAddr");
		String leisureaddr = request.getParameter("leisureAddr");
		String meetingaddr = request.getParameter("meetingAddr");
		String plan = request.getParameter("plan");
		float carbonplan = Float.parseFloat(request.getParameter("carbonplan"));
		UserBeanOperator ubc = new UserBeanOperator();
		String housetype = request.getParameter("housetype");
		int housepeople = Integer.parseInt(request.getParameter("housepeople"));
		String heattype = request.getParameter("heattype");
		String temperature = request.getParameter("temperature");
		if(ubc.checkExisting(username)){
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}else{
			request.getSession().setAttribute("username", username);
			request.getSession().setAttribute("password", password);
			ubc.register(username, password, email, identity, homeaddr, workingaddr, leisureaddr, meetingaddr, frequentaddr, plan, carbonplan);
			HouseBeanOperation hbo = new HouseBeanOperation();
			hbo.save(username, housetype, housepeople, heattype, temperature);
			request.getRequestDispatcher("ShowHomeServlet").forward(request, response);
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
