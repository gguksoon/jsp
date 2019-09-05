<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>uri 통계자료</h2>
	<table border="1">
		<thead>
			<tr>
				<th>uri</th>
				<th>method</th>
				<th>횟수</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${requestCountMap }" var="rc">
				<c:forEach items="${rc.value }" var="rc2">
					<tr>
						<td>${rc.key }</td>
						<td>${rc2.key }</td>
						<td>${rc2.value }</td>
				</tr>
				</c:forEach>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>