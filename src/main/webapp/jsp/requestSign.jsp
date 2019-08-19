<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${cp }/js/jquery-3.4.1.min.js"></script>
<script>
	$(function() {
		$("#sum, #mul").click(function() {
			$("form").attr("sign", $(this).attr("id"));
		})
	})
</script>
</head>
<body>
	<form action="${cp }/jsp/signResult.jsp" method="get">
		작은 숫자: <input type="text" name="number" value="1"/> <br>
		큰 숫자: <input type="text" name="number2" value="10"/> <br>
		합 <input type="radio" name="sign" id="sum" value="sum" checked/>
		곱 <input type="radio" name="sign" id="mul" value="mul"/> <br>
		
		<input type="submit" value="계산"/>
	</form>
</body>
</html>