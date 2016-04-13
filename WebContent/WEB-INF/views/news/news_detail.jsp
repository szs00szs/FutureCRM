<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<h2>${news.title }</h2>
</div>
<div align="center">
	作者： ${news.issuer.getName() }
</div>
<div align="center">
	<table border="0" cellpadding="0" style="text-align: center;">
		<tr>
			<td>
				<c:if test="${news.content != null}">${news.content }<br>
				</c:if>
			</td>
		</tr>
		<tr>
			<td>
				<a href="${pageContext.request.contextPath }/news/news_updateUI/${news.id }">修改</a>
			</td>
		</tr>
	</table>
</div>


</body>
</html>