package com.vin.backend;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.vin.Util.DBUtil;

/**
 * Servlet implementation class UserData
 */
public class UserData extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try 
		{
			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select myname,email,city from myform ");
			List<List<String>> list=new ArrayList<>();
			while(rs.next())
			{
				list.add(Arrays.asList(rs.getString("myname"),rs.getString("email"),rs.getString("city")));
				
			}
			System.out.println(list);
			HttpSession sss = request.getSession();
			sss.setAttribute("users", list);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/userdata.jsp");
			requestDispatcher.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
