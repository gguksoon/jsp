<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.apache.commons.dbcp2.BasicDataSource"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		long start = System.currentTimeMillis();
		for(int i = 0; i < 20; i++) {
			
			BasicDataSource ds = (BasicDataSource)application.getAttribute("ds");
		
			Connection conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from lprod");
			
			while(rs.next()) {
				out.print("lprod_id : " + rs.getInt(1) + "<br>");
				out.print("lprod_gu : " + rs.getString(2) + "<br>");
				out.print("lprod_nm : " + rs.getString(3) + "<br>");
				out.print("====================================<br>");
			}
			
			rs.close();
			stmt.close();
			conn.close();
		}
		long end = System.currentTimeMillis();
		out.println("경과시간: " + (end - start) + "ms");
	%>
</body>
</html>