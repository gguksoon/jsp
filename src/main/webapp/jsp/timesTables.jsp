<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table { border-collapse: collapse; }
	td { width: 100px; height: 50px; text-align: center; }
</style>
</head>
<body>
	<table border="1">
		<%for(int i = 1; i <= 9; i++) { %>
			<tr>
				<%for(int j = 2; j <= 9; j++) { %>
					<td><%=j %> * <%=i %> = <%=j*i %></td>
				<%} %>
			</tr>
		<%} %>
	</table>
</body>
</html>