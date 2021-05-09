<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/signup" method="post" onsubmit="return check();">
		<input type="text" name="username" placeholder="아이디를 입력하세요"> 
		<input type="password" name="password">
		<input type="submit" value="회원가입">
	</form>
</body>
<script>
	
	function check() {
		var username = document.getElementsByName('username').value;
		var password = document.getElementsByName('password').value;
		
		if(username == "") {
			alert("아이디를 입력하세요");
			return false;
		}else if(password == ""){
			alert("비밀번호를 입력하세요.");
			return false;
		}else{
			return true;
		}
	}
</script>
</html>