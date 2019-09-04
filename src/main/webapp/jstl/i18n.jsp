<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>jstl fmt</h2>
	<c:set var="userId" value="brown"/>
	
	<fmt:bundle basename="kr.or.ddit.msg.message">
		GREETING: <fmt:message key="GREETING"/> <br>
		VISITOR: <fmt:message key="VISITOR">
					 <fmt:param value="${userId }"/>
				 </fmt:message>
	</fmt:bundle>
	
	<br><br>
	
	<fmt:setLocale value="en"/>
	<fmt:bundle basename="kr.or.ddit.msg.message">
		GREETING: <fmt:message key="GREETING"/> <br>
		VISITOR: <fmt:message key="VISITOR">
					 <fmt:param value="${userId }"/>
				 </fmt:message>
	</fmt:bundle>
	
	<br><br>
	
	<fmt:setLocale value="zh"/>
	<fmt:bundle basename="kr.or.ddit.msg.message">
		GREETING: <fmt:message key="GREETING"/> <br>
		VISITOR: <fmt:message key="VISITOR">
					 <fmt:param value="${userId }"/>
				 </fmt:message>
	</fmt:bundle>
	
	<!-- ------------------------------------------------------- -->
	
	<h2>fmt setBundle</h2>
	<fmt:setBundle basename="kr.or.ddit.msg.message" var="msg"/>
	GREETING: <fmt:message key="GREETING" bundle="${msg }"/> <br>
	VISITOR: <fmt:message key="VISITOR" bundle="${msg }">
				 <fmt:param value="${userId }"/>
			 </fmt:message>
	
	<!-- ------------------------------------------------------- -->
	
	<h2>fmt number</h2>
	<c:set var="num" value="1000000.123456"/>
	
	<fmt:setLocale value="ko"/>
	한국: <fmt:formatNumber value="${num }"/> <br>
	
	<fmt:setLocale value="de"/> <!-- 독일 -->
	독일: <fmt:formatNumber value="${num }"/> <br>
	독일: <fmt:formatNumber value="${num }" var="deNum"/> <br> <!-- deNum에 저장(출력이 안됨) -->
	독일: <fmt:formatNumber value="${num }" var="deNum"/>${deNum } <br> <!-- deNum에 저장후 출력 -->
	
	<!-- ------------------------------------------------------- -->
	
	<h2>fmt parseNumber</h2>
	<fmt:setLocale value="ko"/>
	<!-- 문자열을 숫자로 변환 -->
	<fmt:parseNumber value="1,000,000" var="koNum"></fmt:parseNumber>
	no pattern parseNumber: ${koNum }
	
	<!-- ------------------------------------------------------- -->
	
	<h2>fmt formatDate</h2>
	<!-- Date객체를 포매팅된 문자열로 변환 -->
	formatDate: <fmt:formatDate value="${dt }" pattern="yyyy-MM-dd"/> <br>
	formatDate: <fmt:formatDate value="${dt }" pattern="yyyy-MM-dd HH:mm:ss"/> <br>
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>