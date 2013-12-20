package com.yxx.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yxx.model.TransportBeanOperator;

public class ShowAllOptionServlet extends HttpServlet {

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
			String departure = (String)request.getSession().getAttribute("departure");
			String destination = (String)request.getSession().getAttribute("destination");
			departure = departure.replaceAll("'", "");
			destination = destination.replaceAll("'", "");
			String s_pageNow = request.getParameter("pageNow");

			
			int pageNow = 1;
			int pageCount = 0;
			try {
				if(s_pageNow!=null){
					pageNow = Integer.parseInt(s_pageNow);
				}
				
				TransportBeanOperator tbo=new TransportBeanOperator(); 
			    ArrayList al = tbo.getTransportByPage(pageNow, departure, destination);
			    
			    pageCount = tbo.getPageCount(departure, destination);
			    
			    request.setAttribute("result", al);
			    request.setAttribute("pageCount",pageCount);
			    request.setAttribute("pageNow", pageNow);
			    
			    request.getRequestDispatcher("moreoption.jsp").forward(request, response);

			    
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
