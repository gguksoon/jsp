<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	request sign : <%=request.getParameter("sign") %><br>
	<%
		int number = Integer.parseInt(request.getParameter("number"));
		int number2 = Integer.parseInt(request.getParameter("number2"));
		int res;
		if(request.getParameter("sign").equals("sum"))
			res = 0;
		else 
			res = 1;
	%>
	
	<%
	for(int i = number; i <= number2; i++) {
		if(request.getParameter("sign").equals("sum"))
			res += i;
		else 
			res *= i;
	}%>
	<h1>결과: <%=res %></h1>
</body>
</html>