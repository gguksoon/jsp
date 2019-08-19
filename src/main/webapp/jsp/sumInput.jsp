<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	* {
		font-size: 1.1em;
	}
	
	label {
		width: 400px;
		display: inline-block;
	}
	
	input[type="text"] {
		width: 200px;
		height: 30px;
	}
	
	input[type="radio"] {
		width: 30px;
		height: 30px;
	}
</style>

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
	<form class="form-signin" action="${cp }/sumCalculation" method="post">
		<label>숫자1: </label>
		<input type="text" name="num1" value="1"/> <br>
		
		<br>
		
		<label>숫자2: </label>
		<input type="text" name="num2" value="10"/> <br>
		
		<br>
		
		합
		<input type="radio" name="sign" id="sum" value="sum" checked/>
		곱
		<input type="radio" name="sign" id="mul" value="mul"/> <br>
		
		<br>
		
		<input type="submit" value="계산"/>
	</form>
</body>
</html>