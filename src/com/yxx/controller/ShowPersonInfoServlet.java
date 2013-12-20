package com.yxx.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yxx.model.HouseBeanOperation;
import com.yxx.model.UserBeanOperator;

public class ShowPersonInfoServlet extends HttpServlet {

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
				UserBeanOperator ubo = new UserBeanOperator();
				ArrayList al = ubo.getUserInfo(username);
				
				request.setAttribute("userinfo", al);
				HouseBeanOperation hbo = new HouseBeanOperation();
				ArrayList al2 = hbo.getHouseInfo(username);
				request.setAttribute("userhouse", al2);
				String action = request.getParameter("action");
				//System.out.print(action);
				if(action==null){
					request.getRequestDispatcher("personinfo.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("personInfoEdit.jsp").forward(request, response);
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
