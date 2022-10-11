package com.lathesh.practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Student
 */
@WebServlet("/InsertStudent")
public class InsertStudent extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
	        try{
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	        	java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","root");
	        	String name=request.getParameter("student-name");
	        	String usn=request.getParameter("student-usn");
	        	String section=request.getParameter("student-section");
	        	String branch=request.getParameter("student-branch");
	        	PreparedStatement pstmt=con.prepareStatement("insert into student(name,usn,section,branch) values(?,?,?,?)");
	        	pstmt.setString(1, name);
	        	pstmt.setString(2, usn);
	        	pstmt.setString(3, section);
	        	pstmt.setString(4, branch);
	        	int count=pstmt.executeUpdate();
	        	System.out.println(count);
	        	if(count>0)
	        	{
	        		PrintWriter out = response.getWriter();
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Register Successfully ');");
					out.println("location='index.html';");
					out.println("</script>");
	        	}
	        }catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
	        
	        
	}
	}


