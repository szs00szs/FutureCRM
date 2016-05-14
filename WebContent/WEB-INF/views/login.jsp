<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>登陆页面</h1>
<div class="error">${error}</div>
	<form action="workspace">
	<table>
		<tr>
			<td> name:</td>
			<td><input type="text" id="name" name="name" /></td>
		</tr>
		<tr>
			<td>password:</td>
			<td><input type="password" id="password" name = "password"></td>
		</tr>
		<tr>
			<td><input type="submit" id="login" value="login"></td>
		</tr>
	</table>
	</form>
</body>
</html>