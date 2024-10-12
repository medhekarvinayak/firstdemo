package com.vin.backend;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.vin.Util.DBUtil;


public class RegForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		String gender = request.getParameter("gender");
		String city = request.getParameter("city");
		System.out.println("name "+name);
		System.out.println("email "+email);
		System.out.println("pass "+pass);
		System.out.println("gender "+gender);
		System.out.println("city "+city);
		
		try
		{
			
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into myform(myname,email,password,gender,city) values(?,?,?,?,?)");
			
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, pass);
			ps.setString(4, gender);
			ps.setString(5, city);
			int ct = ps.executeUpdate();
			PrintWriter out = response.getWriter();
			if(ct > 0)
			{
				response.setContentType("text/html");
				out.println("<h1 style='color:green' >record inserted</h1>");
				RequestDispatcher rd = request.getRequestDispatcher("/Register.jsp");
				rd.include(request, response);
			}
			else
			{
				response.setContentType("text/html");
				out.println("<h1 style='color:red' >record not inserted</h1>");
				RequestDispatcher rd = request.getRequestDispatcher("/Register.jsp");
				rd.include(request, response);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
