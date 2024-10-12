package com.vin.backend;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

import com.vin.Util.DBUtil;

/**
 * Servlet implementation class CallProcedure
 */
public class CallProcedure extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con =DBUtil.getConnection();
		try {
			String name= Optional.ofNullable(request.getParameter("name")).orElse("sample").replace("'", "''") ;
			CallableStatement prepareCall = con.prepareCall("{call test(?)}");
			prepareCall.setString(1, name);
			
			prepareCall.executeUpdate();
			PrintWriter out =response.getWriter();
			out.println("inserted");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
