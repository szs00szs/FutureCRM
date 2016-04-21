<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-2.1.4.js"></script>
<script type="text/javascript">
	$(function() {
		$("#updateInfo").click(function() {
			var url = "${pageContext.request.contextPath}/news/news_update";
			//更改form的action  
			$("#form").attr("action", url);
			//触发submit事件，提交表单   
			$("#form").submit();
		});
		$("#addInfo").click(function() {
			var url = "${pageContext.request.contextPath }/news/news_save";
			//更改form的action  
			$("#form").attr("action", url);
			//触发submit事件，提交表单   
			$("#form").submit();
		});
	})
	
</script>
</head>
<body>
<div align="center">
	<form:form action="#" id="form" method="POST"
		modelAttribute="news">
		<table border="1" cellspacing="0">
			<tr>
				<td>标题</td>
				<td>内容</td>
				<td>发布人</td>
				<td>发布日期</td>
				<td>新闻类型</td>
			</tr>
			<c:if test="${news != null }">
				<form:hidden path="id" />
			</c:if>
				<tr>
					<td><input type="text" name="title" value="${news.title}" /></td>
					<td><input type="text" name="content" value="${news.content}" /></td>
					<td>
						<select name="issuer.id" style="border:solid #ccc 1px;" id = "select">
						    <c:forEach items="${userList}" var="issuer">
						    	<c:if test="${issuer.id == news.issuer.getId() }">
						    		<option value="${issuer.id}" selected="selected">${issuer.name}</option>
						    	</c:if>
						    	<c:if test="${issuer.id != news.issuer.getId() }">
						    		<option value="${issuer.id}">${issuer.name}</option>
						    	</c:if>
						    	<option>1</option>
						    </c:forEach>
						 </select>
						<%-- <input type="text" name="issuer.name" value="${news.issuer.getName()}" /> --%>
					</td>
					<td>
						<input type="hidden"  name="issuer.id" value="${news.issuer.getId()}" />
						<fmt:formatDate value="${news.issur_date}" pattern="yyyy-MM-dd HH:mm:ss" var="issur_date"/>
						<input type="text" name="issur_date" value="${issur_date}"/> 
					</td>
					<td><input type="text" name="newsType" value="${news.newsType }" /></td>
				</tr>
		</table>
		<c:if test="${news != null }">
			<input type="button" value="修改" id="updateInfo" />
		</c:if>
		<c:if test="${news == null }">
			<input type="button" value="增加" id="addInfo" />
		</c:if>
	</form:form>
</div>
</body>
</html>