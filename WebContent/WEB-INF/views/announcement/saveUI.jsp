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
			var url = "${pageContext.request.contextPath}/announcement/announcement_update";
			//更改form的action  
			$("#form").attr("action", url);
			//触发submit事件，提交表单   
			$("#form").submit();
		});
		$("#addInfo").click(function() {
			var url = "${pageContext.request.contextPath }/announcement/announcement_save";
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
		modelAttribute="announcement">
		<table>
 	<caption>公告详细信息</caption>
 		<c:if test="${announcement != null }">
				<form:hidden path="id" />
		</c:if>
 		<tr>
 			<td>公告标题</td>
 			<td><input name="title" value="${announcement.title }"></td>
 		</tr>
 		<tr>
 			<td>公告内容</td>
 			<td><input name="content" value="${announcement.content }"></td>
 		</tr>
 		<tr>
 			<td>发布人</td>
 			<td><input name="issuer.name" value="${announcement.issuer.getName()}"></td>
 		</tr>
 		<tr>
 			<td>发布日期</td>
 			<td>
				<fmt:formatDate value="${announcement.issue_date }" pattern="yyyy-MM-dd HH:mm:ss" var="issue_date"/>
				<input name="issue_date" value="${issue_date }"/>
			</td>
 		</tr>
 		<tr>
 			<td>所属部门</td>
 			<td><input name="department.name" value="${announcement.department.getName()}"></td>
 		</tr>
 	</table>
 	
		<c:if test="${announcement != null }">
			<input type="button" value="修改" id="updateInfo" />
		</c:if>
		<c:if test="${announcement == null }">
			<input type="button" value="增加" id="addInfo" />
		</c:if>
	</form:form>
</div>
<div align="right">
<a href="${pageContext.request.contextPath }/announcement/announcement_list">返回公告列表</a>
</div>
</body>
</html>