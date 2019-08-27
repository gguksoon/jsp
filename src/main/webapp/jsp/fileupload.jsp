<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 
		form tag enctype 속성
		- application/x-www-form-urlencoded: 파라미터 전송 시 &파라미터명=파라미터값 형태로 전송
		- multipart/form-data: 데이터를 바이너리 형식으로 전송
	--%>
	<form action="${cp }/fileupload" method="post" enctype="multipart/form-data">
		<input type="text" name="userId" value="brown"/><br>
		
		<%-- 파일 속성의 경우는 보안상 스크립트 코드로 파일 선택할 수 없다. --%>
		<%-- 사용자의 인터페이스로 선택을 해야 한다. --%>
		<input type="file" name="file"/><br>
		
		<input type="submit" value="전송"/>
	</form>
</body>
</html>