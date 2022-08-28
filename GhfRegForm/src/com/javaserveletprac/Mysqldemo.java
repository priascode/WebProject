package com.javaserveletprac;

import java.io.*;
import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//@WebServlet("/register")// Annotation
public class Mysqldemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");// content type
		PrintWriter out = res.getWriter();// to  print the output
		// Storing Details entered by the user in variable
		String n = req.getParameter("Name");
		String em = req.getParameter("Email");
		String ph = req.getParameter("Phone");
		String wt = req.getParameter("Whatsapp");
		String dob = req.getParameter("Dob");
		String dt = req.getParameter("dist");
		String ad = req.getParameter("addr");
		String an = req.getParameter("Adno");
		String gn = req.getParameter("gender");
		String fn = req.getParameter("Fname");
		String fc = req.getParameter("Focc");
		String mn = req.getParameter("Mname");
		String mc = req.getParameter("Mocc");
		String ainc = req.getParameter("Annincome");
		String pph = req.getParameter("PPhno");
		String fg = req.getParameter("Fgs");
		try {
			Class.forName("com.mysql.jdbc.Driver");//Driver manager class
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/regform","root", "root");//jdbc regform db connection( "url","uname","pwd")
			// Statement for inserting values into pdetails table
			PreparedStatement ps = con.prepareStatement("INSERT INTO pdetails(Name,Email,Phno,whatsappNo,DOB,District,Address,AadharNumber,Gender)  VALUES(?,?,?,?,?,?,?,?,?)");
			//PreparedStatement psd = con.prepareStatement("INSERT INTO personaldetails(FathersName, FathersOccupation, MothersName, MothersOccupation, Annualincome, ParentsPhno, FirstGraduateStatus) VALUES(?,?,?,?,?,?,?)");
			ps.setString(1,n);//using the above ref statement set user input values into the Table
			ps.setString(2, em);
			ps.setString(3, ph);
			ps.setString(4, wt);
			ps.setString(5, dob);
			ps.setString(6, dt);
			ps.setString(7, ad);
			ps.setString(8, an);
			ps.setString(9, gn);
			

		    ps = con.prepareStatement("INSERT INTO personaldetails(FathersName, FathersOccupation, MothersName, MothersOccupation, Annualincome, ParentsPhno, FirstGraduateStatus) VALUES(?,?,?,?,?,?,?)");
			ps.setString(1,fn);
			ps.setString(2, fc);
			ps.setString(3, mn);
			ps.setString(4, mc);
			ps.setString(5, ainc);
			ps.setString(6, pph);
			ps.setString(7, fg);
			
			
			
			int i= ps.executeUpdate();//check the status of Execution
			if(i>0)
				out.print("You are Successfully Registered....");
			 Statement st = con.createStatement();//creating Statement using jdbc connection
		     ResultSet rs = st.executeQuery(" select *from pdetails,personaldetails order by pdetails.Sno desc limit 1;"); // Executing query to retrieve user data from Pdetails table
		     
		     
		     while(rs.next()) {
		    	 	out.println("<h3>Name :"+rs.getString(2)+"</h3>");
		    	 	out.println("<h3>EmailId:" + rs.getString(3)+"</h3>");
		    	 	out.println("<h3>Phone number:"+rs.getString(4)+"</h1>");
		    	 	out.println("<h3>Whatsapp number:"+rs.getString(5)+"</h1>");
		    	 	out.println("<h3>Date of Birth: "+rs.getString(6)+"</h3>");
		    	 	out.println("<h3>District:"+ rs.getString(7)+"</h3>");
		    	 	out.println("<h3>Address:" + rs.getString(8)+"</h3>");
		    	 	out.println("<h3>Aadhar Number:" + rs.getString(9)+"</h3>");
		    	 	out.println("<h3>Gender: "+rs.getString(10)+"</h3>");
		    	 	out.println("<h3>Father Name: "+rs.getString(12)+"</h3>");
		    	 	out.println("<h3>Father's Occupation: "+rs.getString(13)+"</h3>");
		    	 	out.println("<h3>Mother's Name:"+rs.getString(14)+"</h3>");
		    	 	out.println("<h3>Mother's Occupation: "+rs.getString(15)+"</h3>");
		    	 	out.println("<h3>Annual Income: "+rs.getString(16)+"</h3>");
		    	 	out.println("<h3>Parent's Phone number : "+rs.getString(17)+"</h3>");
		    	 	out.println("<h3>First Graduate Status: "+rs.getString(18)+"</h3>");
		   
		    	 	
		    	 	
		     }
		}
			catch(Exception e)
			{
				System.out.println(e);
			}
		out.close();
		
	}
	

}
