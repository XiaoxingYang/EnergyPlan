package com.yxx.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yxx.model.DecisionBeanOperator;
import com.yxx.model.HomeDecisionOperation;

public class ShowHomeDecisionServlet extends HttpServlet {

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
			String s_pageNow = request.getParameter("pageNow");
	
			int pageNow = 1;
			int pageCount = 0;
			try {
				if(s_pageNow!=null){
					pageNow = Integer.parseInt(s_pageNow);
				}
				
				HomeDecisionOperation tbo=new HomeDecisionOperation(); 
			    ArrayList al = tbo.getDecisionByPage(pageNow, username);
			    
			    pageCount = tbo.getPageCount(username);
			    
			    request.setAttribute("decision", al);
			    request.setAttribute("pageCount",pageCount);
			    request.setAttribute("pageNow", pageNow);
			    
			    request.getRequestDispatcher("homeDecision.jsp").forward(request, response);
			}catch (Exception e) {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
