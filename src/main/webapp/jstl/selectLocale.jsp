<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/commonJsp/basicLib.jsp"%>
<script>
	$(function() {
		$("#selectLocale").on("change", function() {
			$("#frm").submit();
		});
	});
</script>
<style>
	body {
		padding: 50px;
	}
</style>
</head>
<body>
	<form id="frm" action="${cp }/selectLocale" method="get">
		<select id="selectLocale" name="locale" class="form-control input-lg" style="width: 150px;">
			<!-- 한국어 -->
			<c:choose>
				<c:when test="${locale == 'ko' }">
					<option value="ko" selected>한국어</option>
				</c:when>
				<c:otherwise>
					<option value="ko">한국어</option>
				</c:otherwise>
			</c:choose>
			
			<!-- 영어 -->
			<c:choose>
				<c:when test="${locale == 'en' }">
					<option value="en" selected>English</option>	
				</c:when>
				<c:otherwise>
					<option value="en">English</option>
				</c:otherwise>
			</c:choose>
			
			<!-- 중국어 -->
			<c:choose>
				<c:when test="${locale == 'zh' }">
					<option value="zh" selected>中国话</option>	
				</c:when>
				<c:otherwise>
					<option value="zh">中国话</option>
				</c:otherwise>
			</c:choose>
		</select>
	</form>
		
	<fmt:setLocale value="${locale }"/>	
	<fmt:setBundle basename="kr.or.ddit.msg.message" var="msg"/>
	<h1><fmt:message key="GREETING" bundle="${msg }"></fmt:message></h1>
</body>
</html>