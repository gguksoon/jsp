<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp-basicLib</title>

<%@ include file="/commonJsp/basicLib.jsp" %>
<style>
	tr:nth-child(odd) {
		background: #FAFAFA;
	}
	
	.lprodTr:hover {
		background: #FFCA6C;
		cursor: pointer;
	}
</style>
</head>

<body>
	<!-- header -->
	<%@ include file="/commonJsp/header.jsp" %>

	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<!-- left -->
				<%@ include file="/commonJsp/left.jsp" %>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">제품  그룹 리스트</h2>
						<div class="table-responsive">
							<table class="table">
								<tr>
									<th>제품그룹명</th>
									<th>제품그룹번호</th>
									<th>바이어이름</th>
									<th>제품아이디</th>
									<th>제품명</th>
									<th>제품가격</th>
								</tr>
								
								<c:forEach items="${prodList}" var="map">
									<tr class="lprodTr">
										<td>${map.LPROD_NM}</td>
										<td>${map.LPROD_GU}</td>
										<td>${map.BUYER_NAME}</td>
										<td>${map.PROD_ID}</td>
										<td>${map.PROD_NAME}</td>
										<td>${map.PROD_PRICE}</td>
									</tr>
								</c:forEach>
								
							</table>
						</div>

						<a class="btn btn-default pull-right">제품 등록</a>

						<div class="text-center">
							<ul class="pagination">
								<li><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
