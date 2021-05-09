<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>로그인 페이지</h1>
	<form action="/login" method="post">
		<input type="text" name="username" placeholder="아이디를 입력하세요"> 
		<input type="password" name="password">
		<input type="submit" value = "로그인">
	</form>
	<input type="button" value="회원가입" onclick="location.href='/signup'">
</body>
</html>