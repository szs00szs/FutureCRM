<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:if test="${role.id == null }">
<title>角色添加</title>
</c:if>
<c:if test="${role.id != null }">
<title>角色修改</title>
</c:if>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-2.1.4.js"></script>
<script type="text/javascript">
	$(function() {
		$("#updateInfo").click(function() {
			var url = "${pageContext.request.contextPath }/sysRole/role_update/" + ${currentPage};
				
			//更改form的action  
			$("#roel_form").attr("action", url);
			//触发submit事件，提交表单 
			$("#roel_form").submit();
		});
		$("#addInfo").click(function() {
			var url = "${pageContext.request.contextPath }/sysRole/role_save";
			alert(url)
			//更改form的action  
			$("#roel_form").attr("action", url);
			//触发submit事件，提交表单   
			$("#roel_form").submit();
		});
	})
	
</script>
</head>
<body>
<form:form action="#" id="roel_form" method="POST"
		modelAttribute="role">
		<table border="1">
			<tr>
				<td>角色名称</td>
				<td>角色备注</td>
			</tr>
			<c:if test="${role.id != null }">
				<form:hidden path="id" />
			</c:if>
			<tr>
				<td><input type="text" name="name" value="${role.name}" /></td>
				<td><input type="text" name="remark"
					value="${role.remark}" /></td>
			</tr>
		</table>
		<c:if test="${role.id != null }">
			<input type="button" value="修改" id="updateInfo" />
		</c:if>
		<c:if test="${role.id == null }">
			<input type="button" value="增加" id="addInfo" />
		</c:if>
	</form:form>
</body>
</html>