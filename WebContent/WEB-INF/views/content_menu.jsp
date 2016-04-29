<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>content_menu</title>
<base target="main">
</head>
<body id="bg">
<div class="container">

	 <c:forEach items="${menus}" var="m">
        <a href="${pageContext.request.contextPath}/${m.url}" target="right">${m.name}</a><br/>
    </c:forEach>
</div>
</body>
</html>
