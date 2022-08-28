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
	@WebServlet("/register")// Annotation
	public class Regform  extends HttpServlet {
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
			String ainc = req.getParameter("AnnIncome");
			String pph = req.getParameter("PPhno");
			String fg = req.getParameter("Fgs");
			String sib =req.getParameter("Sibdet");
			
			String ten = req.getParameter("Tenth");
		//	String tep = req.getParameter("Tenper");
			String hsc = req.getParameter("Hscm");
		//	String hsp = req.getParameter("Hscper");
			String crs = req.getParameter("course");
			String spf = req.getParameter("specify");
			String yr= req.getParameter("year");
			String cg = req.getParameter("clg");
			String cga = req.getParameter("clgaddr");
			String psp = req.getParameter("semper");
			String splt = req.getParameter("spltal");
			String aim = req.getParameter("aim");
			
			
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
				int i= ps.executeUpdate();//check the status of Execution
				if(i>0)
					out.print("You are Successfully Registered....");
				 Statement st = con.createStatement();//creating Statement using jdbc connection
			     ResultSet rs = st.executeQuery(" select *from pdetails order by pdetails.Sno desc limit 1;"); // Executing query to retrieve user data from Pdetails table
			     
			     
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
			     }
			    ps = con.prepareStatement("INSERT INTO personaldetails(FathersName, FathersOccupation, MothersName, MothersOccupation, Annualincome, ParentsPhno, FirstGraduateStatus,SiblingDetails) VALUES(?,?,?,?,?,?,?,?)");
				ps.setString(1,fn);
				ps.setString(2, fc);
				ps.setString(3, mn);
				ps.setString(4, mc);
				ps.setString(5, ainc);
				ps.setString(6, pph);
				ps.setString(7, fg);
				ps.setString(8, sib);
				int in= ps.executeUpdate();//check the status of Execution
				if(in>0)
				 st = con.createStatement();//creating Statement using jdbc connection
			     rs = st.executeQuery(" select *from personaldetails order by Sno desc limit 1;"); // Executing query to retrieve user data from Pdetails table
			     
			     
			     while(rs.next()) {
				out.println("<h3>Father Name: "+rs.getString(2)+"</h3>");
			    	 	out.println("<h3>Father's Occupation: "+rs.getString(3)+"</h3>");
			    	 	out.println("<h3>Mother's Name:"+rs.getString(4)+"</h3>");
			    	 	out.println("<h3>Mother's Occupation: "+rs.getString(5)+"</h3>");
			    	 	out.println("<h3>Annual Income: "+rs.getString(6)+"</h3>");
			    	 	out.println("<h3>Parent's Phone number : "+rs.getString(7)+"</h3>");
			    	 	out.println("<h3>First Graduate Status: "+rs.getString(8)+"</h3>");
			    	 	out.println("<h3>Siblings Details: "+rs.getString(9)+"</h3>");
			   
			   }
			     ps = con.prepareStatement("INSERT INTO edudetails(Sslcmark,Hscmark,Course,Specification,Currentyear,College,CollegeAddress,Previousper,Speciality,Aim) VALUES(?,?,?,?,?,?,?,?,?,?)");
			     	ps.setString(1,ten);
				    ps.setString(2, hsc);
					ps.setString(3, crs);
					ps.setString(4, spf);
					ps.setString(5, yr);
					ps.setString(6, cg);
					ps.setString(7, cga);
					ps.setString(8, psp);
					ps.setString(9, splt);
					ps.setString(10, aim);
					int ie= ps.executeUpdate();//check the status of Execution
					if(ie>0)
						st = con.createStatement();//creating Statement using jdbc connection
						rs = st.executeQuery(" select *from edudetails order by Sno desc limit 1;");
						while(rs.next()) {
								out.println("<h3>10th mark Obtained: "+rs.getString(2)+"</h3>");
							    out.println("<h3>10th percentage: "+rs.getString(3)+"</h3>");
							    out.println("<h3>12th mark Obtained:"+rs.getString(4)+"</h3>");
							    out.println("<h3>12th percentage: "+rs.getString(5)+"</h3>");
							    out.println("<h3>Course Studying: "+rs.getString(6)+"</h3>");
							    out.println("<h3>Specification: "+rs.getString(7)+"</h3>");
							    out.println("<h3>Current year: "+rs.getString(8)+"</h3>");
							    out.println("<h3>College name: "+rs.getString(9)+"</h3>");
							    out.println("<h3>College located in: "+rs.getString(10)+"</h3>");
							    out.println("<h3>Previous Semester Percentage: "+rs.getString(11)+"</h3>");
							    out.println("<h3>You are Good at : "+rs.getString(12)+"</h3>");
							    out.println("<h3>Aim: "+rs.getString(13)+"</h3>");
						}
					}
				catch(Exception e)
				{
					System.out.println(e);
				}
			out.close();
			
		}
		

	}


