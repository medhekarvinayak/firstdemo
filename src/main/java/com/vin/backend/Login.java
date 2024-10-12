package com.vin.backend;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.vin.Util.DBUtil;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		
		try {
			
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("select count(*) from myform where myname=? and password=?");
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				response.setContentType("text/html");
				out.println("<h1 style='color:red'>invalid credentials</h1>");
				HttpSession ss = request.getSession();
				ss.setAttribute("name", name);
				RequestDispatcher rd = request.getRequestDispatcher("/Profile.jsp");
				rd.forward(request, response);
			}
			else
			{
				response.setContentType("text/html");
				out.println("<h1 style='color:red'>invalid credentials</h1>");
				RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
				rd.include(request, response);
			}
				
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
