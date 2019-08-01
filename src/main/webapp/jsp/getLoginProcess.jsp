<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		파라미터를 받는다.
		input tag의 name속성이 파라미터 이름 
		userId, password
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		String userId = request.getParameter(userId); <-- 변수인 userId이다.. 주의
	-->
	
	
	<%
		String userId = request.getParameter("userId"); // 유저아이디 1개
		String password = request.getParameter("password"); // 패스워드 1개
	%>
	<h2>request.getParameter() --> 파라미터 가져오기(해당 name중 한개) </h2>
	parameter userId: <%=userId %> <br>
	parameter password: <%=password %> <br>
	
	<!------------------------------------------------------------------------->
	
	<%
		String[] userIds = request.getParameterValues("userId"); // 유저아이디들
	%>
	<h2>request.getParameterValues() --> 파라미터 가져오기(해당 name이 여러개) </h2>
	<%for(String str : userIds) { %>
		parameter userId : <%=str %> <br>
	<%} %>
	
	<!------------------------------------------------------------------------->
	
	<%
		Map<String, String[]> requestMap = request.getParameterMap();
	%>
	<h2>request.getParameterMap() --> 파라미터 전체 가져오기(모든 name 전체)</h2>
	<%for(String key : requestMap.keySet()) {%>
		<%=key %> : <%=Arrays.toString(requestMap.get(key)) %><br>
	<%} %>
	
	<!------------------------------------------------------------------------->
	
	<%
		Enumeration<String> parameterNames = request.getParameterNames();
	%>
	<h2>request.getParameterNames() --> 파라미터 name만 가져오기</h2>
	<%while(parameterNames.hasMoreElements()) {
		String parameterName = parameterNames.nextElement();
	%>
		<%=parameterName %> <br>
	<%} %>
</body>
</html>