<%@page import="kr.or.ddit.user.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
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
	
	.userTr:hover {
		background: #FFCA6C;
		cursor: pointer;
	}
</style>
<script>
	$(document).ready(function() {
		
		// 사용자 정보 클릭 시 이벤트 핸들러
		$(".userTr").on("click", function() {
			// 클릭된 tr태그의 자식태그(td)중 첫번째 자식의 텍스트 문자열
			var tdText = $(this).children().eq(1).text();
			console.log("tdText: " + tdText);
			
			// input 태그에 저장된 값 확인
			var inputValue = $(this).find("input").val();
			console.log("inputValue: " + inputValue);
			
			// data 속성으로 값(tr 태그에 저장된 값) 확인
			var dataValue = $(this).data("userid"); // 모두 소문자로 치환됨
			console.log("dataValue: " + dataValue);
			
			// input 태그에 값 설정
			$("#userId").val(dataValue);
			
			// form 태그 이용하여 전송
			console.log("serialize: " + $("#frm").serialize());
			
			$("#frm").submit();
		});
		
	});
</script>
</head>

<body>
	<!-- 개발자 입장에서 데이터를 전송하기 위하여 사용하는 form -->
	<form id="frm" action="${cp }/user" method="get">
		<input type="hidden" id="userId" name="userId"/>
	</form>
	
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
						<h2 class="sub-header">사용자 페이징 리스트</h2>
						<div class="table-responsive">
							<table class="table">
								<tr>
									<th>사용자 아이디</th>
									<th>사용자 이름</th>
									<th>사용자 별명</th>
									<th>등록일시</th>
								</tr>
								
								<c:forEach items="${userList}" var="user">
									<tr class="userTr" data-userId="${user.userId }">
										<input type="hidden" value="${user.userId }"/>
										<td>${user.userId}</td>
										<td>${user.userNm}</td>
										<td>${user.alias}</td>
										<td>${user.getReg_dt_fmt()}</td>
									</tr>
								</c:forEach>
								
							</table>
						</div>

						<a href="${cp }/userForm" class="btn btn-default pull-right">사용자 등록</a>

						<div class="text-center">
							<ul class="pagination">
								<c:choose>
									<c:when test="${pageVo.page == 1 }">
										<li class="disabled">
											<span aria-hidden="true">&laquo;</span>
										</li>
									</c:when>
									<c:otherwise>
										<li>
											<a href="${cp }/userPagingList?page=${pageVo.page - 1}" aria-label="Previous">
												<span aria-hidden="true">&laquo;</span>
											</a>
										</li>
									</c:otherwise>
								</c:choose>
								
								<c:forEach begin="1" end="${paginationSize }" var="idx">
									<c:choose>
										<c:when test="${idx == pageVo.page }">
											<%-- 현재 페이지를 클릭했을때도 재요청되므로 막아준다.
											<li class="active"><a href="${cp }/userPagingList?page=${idx }&pagesize=10">${idx }</a></li>
											--%>
											<li class="active"><span>${idx }</span></li>
											 
										</c:when>
										<c:otherwise>
											<li><a href="${cp }/userPagingList?page=${idx }">${idx }</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								
								<c:choose>
									<c:when test="${pageVo.page == paginationSize }">
										<li class="disabled">
											<span aria-hidden="true">&raquo;</span>
										</li>
									</c:when>
									<c:otherwise>
										<li>
											<a href="${cp }/userPagingList?page=${pageVo.page + 1}" aria-label="Previous">
												<span aria-hidden="true">&raquo;</span>
											</a>
										</li>
									</c:otherwise>
								</c:choose>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
