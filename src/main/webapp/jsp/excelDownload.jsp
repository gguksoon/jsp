<%@page import="kr.or.ddit.user.service.UserService"%>
<%@page import="kr.or.ddit.user.service.IUserService"%>
<%@page import="kr.or.ddit.user.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="application/vnd.ms-excel; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	response.setHeader("Content-Disposition", "attahchement; filename=line.xls");
	IUserService userService = new UserService();
	List<User> userList = userService.getUserList();
%>
	<table>
		<tr>
			<th>이름</th>
			<th>아이디</th>
			<th>비밀번호</th>
		</tr>
		<%
			for(User userVo : userList){
		%>
			<tr>
				<td><%=userVo.getUserNm()%></td>
				<td><%=userVo.getUserId() %></td>
				<td><%=userVo.getPass() %></td>
			</tr>		
		<%} %>
	</table>
</body>
</html>