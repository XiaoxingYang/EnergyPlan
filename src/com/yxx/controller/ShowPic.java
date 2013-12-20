package com.yxx.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowPic extends HttpServlet {

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

	    response.setContentType("image/jpeg;charset=utf-8");
	    String type = request.getParameter("type");
	    String imagepath="";
	    if(type.equalsIgnoreCase("transport")){
	    	imagepath="E:/EnergyService/EnergyService/WebRoot/img/lineChart.jpg";
	    }else if(type.equalsIgnoreCase("house")){
	    	imagepath="E:/EnergyService/EnergyService/WebRoot/img/houselineChart.jpg";
	    }else{
	    	imagepath="E:/EnergyService/EnergyService/WebRoot/img/totallineChart.jpg";
	    }
	    
	    OutputStream output = response.getOutputStream();
	    InputStream imageIn = new FileInputStream(imagepath);
	    BufferedInputStream bis = new BufferedInputStream(imageIn);
	    BufferedOutputStream bos = new BufferedOutputStream(output);
	    byte data[] = new byte[4096];
	    int size = 0; 
	    size = bis.read(data);
	    while(size!=-1){
	    	bos.write(data, 0, size);
	    	size = bis.read(data);
	    }
	    bis.close();
	    bos.flush();
	    bos.close();
	    output.close();
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
