<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
</div>
<div align="center">
</div>
<div align="center">
	<table border="0" cellpadding="0" style="text-align: center; width:900px;">
		<tr>
			<td>
				<h2>${news.title }</h2>
				作者： ${news.issuer.getName() }
				<fmt:formatDate value="${news.issur_date }" var="issur_date" pattern="yyyy-MM-dd HH:mm:ss"/>
				时间：${issur_date}
			</td>
		</tr>
		<tr>
			<td>
				<a style="float: right;" href="${pageContext.request.contextPath}/news/news_updateUI/${news.id }">修改</a>
			</td>
		</tr>
		<tr>
			<td>
						<hr>
				<c:if test="${news.content != null}">${news.content }<br>
				</c:if>
			</td>
		</tr>
		<tr>
			<td>
				
			</td>
		</tr>
	</table>
</div>
<div>
	<span><a href="${pageContext.request.contextPath }/login">返回工作页面</a></span>
</div>

</body>
</html>