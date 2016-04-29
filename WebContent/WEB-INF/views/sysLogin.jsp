<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>login</title>
<script src="${pageContext.request.contextPath}/js/jquery-2.1.4.js"></script>
</head>
<body>

	<form action="" method="post">
    用户名：<input type="text" name="username" value="<shiro:principal/>" /><br/>
    密码：<input type="password" name="password" /><br/>
    自动登录：<input type="checkbox" name="rememberMe" value="true" /><br/>
    <input type="submit" value="登录" >
</form>

</body>
</html>