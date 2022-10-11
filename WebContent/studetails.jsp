<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table
{
	border:1px solid balck;
	margin:20px;
	border-collapse:collapse;
}
th,tr,td
{
	color:red;
	padding:20px;
	border:3px solid black;
	background-color:green;

}
tr,td
{
	border:1px solid black;
	color:yellow;
	background-color:pink;

}


</style>
</head>
<body>
	<form action="">
		<input type="text" placeholder="Enter Student Usn" name="student-usn">
		<input type="submit" value="submit">


	</form>
	<%
	String usn=request.getParameter("student-usn");
	if(usn!=null)
	{
	%>
	<table>
		<tr>
			<th>Name</th>
			<th>USN</th>
			<th>SECTION</th>
			<th>BRANCH</th>
			<th>MARK</th>
			<th>ATTENDENCE</th>
		</tr>
		<%
		try{
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","root");
		PreparedStatement ps = con.prepareStatement("select name,usn,section,branch,mark,attendence from student where usn=?");
		ps.setString(1, usn);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){ %>
		<tr>
		<td><%=rs.getString("name")%></td>
		<td><%=rs.getString("usn")%></td>
		<td><%=rs.getString("section")%></td>
		<td><%=rs.getString("branch")%></td>
		<td><%=rs.getString("mark")%></td>
		<td><%=rs.getString("attendence")%></td>
		</tr>
		<%} 
		
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
		
		
		%>
	
		</table>
</body>
</html>