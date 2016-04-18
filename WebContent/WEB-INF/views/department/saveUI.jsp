<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:if test="${department.id == null }">
<title>部门添加</title>
</c:if>
<c:if test="${department.id != null }">
<title>部门修改</title>
</c:if>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-2.1.4.js"></script>
<script type="text/javascript">
	$(function() {
		$("#updateInfo").click(function() {
			var url = "${pageContext.request.contextPath }/sysDepartment/department_update/" + ${currentPage};
				
			//更改form的action  
			$("#form").attr("action", url);
			//触发submit事件，提交表单 
			$("#form").submit();
		});
		$("#addInfo").click(function() {
			alert(0);
			var url = "${pageContext.request.contextPath }/sysDepartment/department_save";
			alert(url)
			//更改form的action  
			$("#form").attr("action", url);
			//触发submit事件，提交表单   
			$("#form").submit();
		});
	})
	
</script>
</head>
<body>
	<form:form action="#" id="form" method="POST"
		modelAttribute="department">
		<table border="1">
			<tr>
				<td>部门名称</td>
				<td>部门负责人</td>
				<td>部门职能</td>
				<td>部门备注</td>
			</tr>
			<c:if test="${department != null }">
				<form:hidden path="id" />
			</c:if>
			<tr>
				<td><input type="text" name="name" value="${department.name}" /></td>
				<td><input type="text" name="principal"
					value="${department.principal}" /></td>
				<td><input type="text" name="incumbent"
					value="${department.incumbent}" /></td>
				<td><input type="text" name="remark"
					value="${department.remark}" /></td>
			</tr>
		</table>
		<c:if test="${department != null }">
			<input type="button" value="修改" id="updateInfo" />
		</c:if>
		<c:if test="${department == null }">
			<input type="button" value="增加" id="addInfo" />
		</c:if>
	</form:form>
</body>
</html>