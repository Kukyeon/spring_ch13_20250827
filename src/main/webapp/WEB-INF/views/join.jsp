<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1>회원가입</h1>
	<hr>
	<form action="joinOk" method="get">
		아이디  <br><input type="text" name="mid"> <br>
		비밀번호 <br><input type="password" name="mpw"> <br>
		이름 <br><input type="text" name="mname"> <br>
		나이 <br><input type="text" name="mage"> <br>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>