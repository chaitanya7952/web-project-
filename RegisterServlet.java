package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String uname=request.getParameter("username");
		String pass=request.getParameter("password");
		String age=request.getParameter("age");
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			PreparedStatement psp = con.prepareStatement("insert into student values(?,?,?,?,?,?)");
			psp.setString(1, name);
	    	psp.setString(2,uname );
	    	psp.setString(3,pass );
	    	psp.setString(4,age );
	    	psp.setString(5,gender );
	    	psp.setString(6,address );
	    	int i = psp.executeUpdate();
	    	response.setContentType("text/html");
	    	PrintWriter out = response.getWriter();
	    	if(i>0) {
	    		out.println("Successfully Register");
	    	}else {
	    		out.println("Not Register");
	    	}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
