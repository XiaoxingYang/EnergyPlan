package com.yxx.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yxx.model.UserBean;
import com.yxx.model.UserBeanOperator;

public class ShowHomeServlet extends HttpServlet {

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
			UserBeanOperator ubo = new UserBeanOperator();
			ArrayList al = ubo.getUserInfo(u);
			if(al.get(0)!=null){
				UserBean ub = (UserBean) al.get(0);
				request.setAttribute("workingaddr", ub.getWorkingaddr());
				request.setAttribute("meetingaddr", ub.getMeetingaddr());
				request.setAttribute("leisureaddr", ub.getLeisureaddr());
				request.setAttribute("frequentaddr", ub.getFrequentaddr());
				request.setAttribute("homeaddr", ub.getHomeaddr());
			}
			request.getRequestDispatcher("homepage.jsp").forward(request, response);
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
