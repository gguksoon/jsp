<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
		// DB작업에 필요한 객체 변수 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		// start
		long start = System.currentTimeMillis();
		for(int i = 0; i < 20; i++) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// DB접속 ==> Connection객체 생성
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", // @뒤에는 오라클시스템에 따라 바꿔주면 됨(SQL Developer의 +를 클릭했을 때 나옴)
					"JMS", // 사용자 아이디
					"java"); // 비밀번호
			
			// Statement객체 생성 ==> Connection객체 이용
			String sql = "SELECT * FROM LPROD"; // 실행할 SQL문장
			stmt = conn.createStatement(); // Statement객체 생성
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				out.println("LPROD_ID: " + rs.getInt("LPROD_ID") + "<br>");
				out.println("LPROD_GU: " + rs.getString(2) + "<br>"); // 숫자는 컬럼 번호를 의미(1번부터 시작)
				out.println("LPROD_NM: " + rs.getString(3) + "<br>");
				out.println("------------------------------------<br>");
			}
			
			rs.close();
			stmt.close(); 
			conn.close();
		}
		long end = System.currentTimeMillis();
		out.println("경과시간: " + (end - start) + "ms");
		// end
	%>
</body>
</html>