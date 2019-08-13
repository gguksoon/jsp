<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/redirectServlet" method="post">
		<input type="text" name="userName" value="kim"/> <br>
		<input type="text" name="userAge" value="30"/> <br>
		<input type="text" name="userGender" value="남자"/> <br>
		
		<input type="submit" value="전송"/>
	
	</form>
</body>
</html>