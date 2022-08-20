package com.javaserveletprac;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class Mysqldemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String n = req.getParameter("Name");
		String em = req.getParameter("Email");
		String ph = req.getParameter("Phone");
		String c = req.getParameter("Course");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/regform","root", "root");
//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery("Select * from PersonalDetails");
//			while(rs.next()) {
//				System.out.println(rs.getString(1)+" "+ rs.getString(2));
//			}
			PreparedStatement ps = con.prepareStatement("insert into personaldet values(?,?,?,?)");
			
			ps.setString(1,n);
			ps.setString(2, em);
			ps.setString(3, ph);
			ps.setString(4, c);
			
			int i= ps.executeUpdate();
			if(i>0)
				out.print("You are Successfully Registered....");
			
		
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		out.close();
		
	}
	

}
