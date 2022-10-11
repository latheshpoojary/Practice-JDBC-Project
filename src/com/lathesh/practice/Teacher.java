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


@WebServlet("/Teacher")
public class Teacher extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usn=request.getParameter("student-usn");
		int mark=Integer.parseInt(request.getParameter("student-mark"));
		int attendence=Integer.parseInt(request.getParameter("student-attendence"));
		try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","root");
        	PreparedStatement pstmt=con.prepareStatement("update student set mark=?,attendence=? where usn=?");
        	pstmt.setInt(1, mark);
        	pstmt.setInt(2, attendence);
        	pstmt.setString(3, usn);
        	int count=pstmt.executeUpdate();
        	if(count>0)
        	{
        		PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Inserted Successfully ');");
				out.println("location='teacher.html';");
				out.println("</script>");
        	}
        }catch(Exception e)
        {
        	e.printStackTrace();
        }
		}

}
