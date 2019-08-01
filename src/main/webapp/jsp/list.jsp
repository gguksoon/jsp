<%@page import="kr.or.ddit.user.repository.IUserDao"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.repository.UserDao"%>
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
	<%--
		1. userdao 선언
		2. getUserList() 호출
		3. 호출 결과(List<UserVo>)를  for loop를 통해 tr태그를 반복 생성
	--%>

	<%
		IUserDao userdao = new UserDao();
		List<UserVo> userList = userdao.getUserList();
	%>
	<table border="1">
		<tr>
			<th>이름</th>
		</tr>
		<%for(UserVo user : userList) {%>
			<tr>
				<td><%=user.getUserName() %></td>
			</tr>
		<%} %>
		
	</table>
</body>
</html>