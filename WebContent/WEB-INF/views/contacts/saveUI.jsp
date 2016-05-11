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
<link
	href="${pageContext.request.contextPath }/css/bootstrap-combined.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath }/css/bootstrap-datetimepicker.min.css">
<script type="text/javascript">
	$(function() {
		$('#datetimepicker').datetimepicker({
			  format: 'yyyy-MM-dd hh:MM:ss'
		});
	});
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-2.1.4.js"></script>
<script type="text/javascript">
	$(function() {
		$("#updateInfo").click(function() {
			var url = "${pageContext.request.contextPath}/contacts/contacts_update/${currentPage}";
			//更改form的action  
			$("#form").attr("action", url);
			//触发submit事件，提交表单   
			$("#form").submit();
		});
		$("#addInfo").click(function() {
			var url = "${pageContext.request.contextPath }/contacts/contacts_save";
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
		modelAttribute="contacts">
	<table>
 		<caption>联系人详细信息</caption>
 		<c:if test="${contacts != null }">
				<form:hidden path="id" />
		</c:if>
		
 		<tr>
 			<td>姓名</td>
 			<td><input name="name" value="${contacts.name }" /></td>
 		</tr>
 		<tr>
 			<td>性别</td>
 			<td><input name="sex" value="${contacts.sex }" /></td>
 		</tr>
 		<tr>
 			<td>生日</td>
 			<td>
 				<fmt:formatDate value="${contacts.birthday}" pattern="yyyy-MM-dd HH:mm:ss" var="birthday"/>
 				<div id="datetimepicker" class="input-append date">
					<input name="birthday" id="datetimepicker" value="${birthday}" data-format="yyyy-MM-dd hh:mm:ss"
						type="text" /> 
					<span class="add-on"> 
						<i data-time-icon="icon-time" data-date-icon="icon-calendar"> </i>
					</span>
				</div>
 			</td>
 		</tr>
 		<tr>
 			<td>部门职务</td>
 			<td><input name="departmentDuties" value="${contacts.departmentDuties }" /></td>
 		</tr>
 		<tr>
 			<td>办公室电话</td>
 			<td><input name="officeTelephone" value="${contacts.officeTelephone }" /></td>
 		</tr>
 		<tr>
 			<td>家庭电话</td>
 			<td><input name="homePhone" value="${contacts.homePhone }" /></td>
 		</tr>
 		<tr>
 			<td>手机</td>
 			<td><input name="mobilePhone" value="${contacts.mobilePhone }" /></td>
 		</tr>
 		<tr>
 			<td>邮箱</td>
 			<td><input name="email" value="${contacts.email }" /></td>
 		</tr>
 		<tr>
 			<td>邮编</td>
 			<td><input name="postCode" value="${contacts.postCode }" /></td>
 		</tr>
 		<tr>
 			<td>QQ</td>
 			<td><input name="QQNumber" value="${contacts.QQNumber }" /></td>
 		</tr>
 		<tr>
 			<td>联系地址</td>
 			<td><input name="contactAddress" value="${contacts.contactAddress }" /></td>
 		</tr>
 		<tr>
 			<td>爱好</td>
 			<td><input name="hobby" value="${contacts.hobby }" /></td>
 		</tr>
 		<tr>
 			<td>忌讳</td>
 			<td><input name="taboo" value="${contacts.taboo }" /></td>
 		</tr>
 		<tr>
 			<td>备注</td>
 			<td><input name="remark" value="${contacts.remark }" /></td>
 		</tr>
 	</table>
 	
		<c:if test="${contacts != null }">
			<input type="button" value="修改" id="updateInfo" />
		</c:if>
		<c:if test="${contacts == null }">
			<input type="button" value="增加" id="addInfo" />
		</c:if>
	</form:form>
</div>
<div align="right">
<a href="${pageContext.request.contextPath }/contacts/contacts_list/1">返回用户列表</a>
</div>
<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/jquery-2.1.4.js"></script>
	<script type="text/javascript" 
		src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#datetimepicker").datetimepicker({
				
			});
		});
</script>
</body>
</html>