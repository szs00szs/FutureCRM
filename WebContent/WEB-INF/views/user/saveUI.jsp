<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:if test="${user.id == null }">
	<title>人员添加</title>
</c:if>
<c:if test="${user.id != null }">
	<title>人员修改</title>
</c:if>
<link
	href="${pageContext.request.contextPath }/css/bootstrap-combined.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath }/css/bootstrap-datetimepicker.min.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#datetimepicker1').datetimepicker({
	
		});
		$('#datetimepicker2').datetimepicker({
	
		});
		$('#datetimepicker3').datetimepicker({
	
		});
	});
</script>
<script type="text/javascript">
	$(function() {
		$("#updateInfo")
				.click(
						function() {
							var url = "${pageContext.request.contextPath }/sysUser/user_update/"
									+ $
							{
								currentPage
							}
							;
							//更改form的action
							$("#user_form").attr("action", url);
							//触发submit事件，提交表单 
							$("#user_form").submit();
						});
		$("#addInfo").click(function() {
			var url = "${pageContext.request.contextPath }/sysUser/user_save";
			//	alert(url);
			//更改form的action  
			$("#user_form").attr("action", url);
			//	alert($("#user_form").attr("action"));
			//alert("11");
			//触发submit事件，提交表单   
			$("#user_form").submit();
			//	alert("22");
		});
	})
</script>
</head>
<body>
	<form:form id="user_form" name="user_form" method="post" action="#"
		modelAttribute="user">
		<h3>基本信息</h3>
		<table border="1">
			<c:if test="${user.id != null }">
				<form:hidden path="id" />
			</c:if>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="loginName"
					value="${user.loginName}" /></td>
				<td>中文名</td>
				<td><input type="text" name="name" value="${user.name}" /></td>
			</tr>
			<tr>
				<c:if test="${user.id == null }">
					<td>密码</td>
					<td><input type="password" name="password" /></td>
				</c:if>
				<td>推荐人</td>
				<td><input type="text" name="commendMan"
					value="${user.commendMan}" /></td>
			</tr>
			<tr>
				<td>移动电话</td>
				<td><input type="text" name="moveTelephone"
					value="${user.moveTelephone}" /></td>
				<td>电子邮件</td>
				<td>
					<%-- <input type="text" name="email" value="${user.email}"/> --%> <form:input
						path="email" /> <form:errors path="email"></form:errors>
				</td>
			</tr>
			<tr>
				<td>家庭地址</td>
				<td><input type="text" name="address" value="${user.address}" /></td>
				<td>家庭电话</td>
				<td><input type="text" name="telephone"
					value="${user.telephone}" /></td>
			</tr>
			<tr>
				<td>现住宅地址</td>
				<td><input type="text" name="nowAddress"
					value="${user.nowAddress}" /></td>
				<td>现住宅电话</td>
				<td><input type="text" name="nowTelephone"
					value="${user.nowTelephone}" /></td>
			</tr>
			<tr>
				<td>身份证号码</td>
				<td><input type="text" name="identityCode"
					value="${user.identityCode}" /></td>
				<td>社会保险号</td>
				<td><input type="text" name="insuranceCode"
					value="${user.insuranceCode}" /></td>
			</tr>

			<tr>
				<td>紧急联系人</td>
				<td><input type="text" name="instancyLinkman"
					value="${user.instancyLinkman}" /></td>
				<td>紧急联系电话</td>
				<td><input type="text" name="instancyTelephone"
					value="${user.instancyTelephone}" /></td>
			</tr>
			<tr>
				<td>起始有效日期</td>
				<td>
						<%-- <fmt:formatDate value="${user.beginDate}" pattern="yyyy-MM-dd HH:mm:ss" var="beginDate"/>
				<input type="text" name="beginDate" value="${beginDate}"/> --%>
					<div id="datetimepicker1" class="input-append date">
						<fmt:formatDate value="${user.beginDate}" pattern="yyyy-MM-dd HH:mm:ss" var="beginDate"/>
						<input name="beginDate" id="datetimepicker1" value="${beginDate}" data-format="yyyy-MM-dd hh:mm:ss"
							type="text" /> 
						<span class="add-on"> 
							<i data-time-icon="icon-time" data-date-icon="icon-calendar"> </i>
						</span>
					</div>
				</td>
				<td>终止有效日期</td>
				<td>
				<%-- <fmt:formatDate value="${user.endDate}"
						pattern="yyyy-MM-dd HH:mm:ss" var="endDate" /> <input type="text"
					name="endDate" value="${endDate}" /> --%>
					<div id="datetimepicker2" class="input-append date">
						<fmt:formatDate value="${user.endDate}"
							pattern="yyyy-MM-dd HH:mm:ss" var="endDate" />
						<input name="endDate" id="datetimepicker2" value="${endDate}" data-format="yyyy-MM-dd hh:mm:ss"
							type="text" /> 
						<span class="add-on"> 
							<i data-time-icon="icon-time" data-date-icon="icon-calendar"> </i>
						</span>
					</div>
				</td>
			</tr>
			<tr>
				<td>所属部门</td>
				<td><select name="department.id" id="department"
					style="border: solid #ccc 1px;" id="select">
						<c:forEach items="${departmentList}" var="dp">
							<c:if test="${dp.id == user.department.getId() }">
								<option value="${dp.id}" selected="selected">${dp.name}</option>
							</c:if>
							<c:if test="${dp.id != user.department.getId() }">
								<option value="${dp.id}">${dp.name}</option>
							</c:if>
						</c:forEach>
				</select></td>
				<td>状态</td>
				<td><input type="radio" name="status" value="Y"
					<c:if test="${user.status== 'Y'}">checked="checked"</c:if> />启用 <input
					type="radio" name="status" value="N"
					<c:if test="${user.status== 'N'}">checked="checked"</c:if> />停用</td>
			</tr>
		</table>
		<h3>详细信息</h3>
		<table border="1">
			<tr>
				<td>性别</td>
				<td><input type="radio" name="sex" value="男"
					<c:if test="${user.sex== '男'}">checked="checked"</c:if> />男 <input
					type="radio" name="sex" value="女"
					<c:if test="${user.sex== '女'}">checked="checked"</c:if> />女</td>
				<td>出生日期</td>
				<td>
					<%-- <fmt:formatDate value="${user.birthday}"
							pattern="yyyy-MM-dd HH:mm:ss" var="birthday" /> <input type="text"
						name="birthday" value="${birthday}" /> --%>
					<div id="datetimepicker3" class="input-append date">
						<fmt:formatDate value="${user.birthday}"
							pattern="yyyy-MM-dd HH:mm:ss" var="birthday" />
						<input name="birthday" id="datetimepicker3" value="${birthday}" data-format="yyyy-MM-dd hh:mm:ss"
							type="text" /> 
						<span class="add-on"> 
							<i data-time-icon="icon-time" data-date-icon="icon-calendar"> </i>
						</span>
					</div>
				</td>
			</tr>
			<tr>
				<td>职务类别</td>
				<td><input type="radio" name="personnelType" value="全职"
					<c:if test="${user.personnelType== '全职'}">checked="checked"</c:if> />全职
					<input type="radio" name="personnelType" value="兼职"
					<c:if test="${user.personnelType== '兼职'}">checked="checked"</c:if> />兼职
				</td>
				<td>职务</td>
				<td><input type="text" name="duty" value="${user.duty}" /></td>
			</tr>
		</table>
		<c:if test="${user.id != null }">
			<input type="button" value="修改" id="updateInfo" />
		</c:if>
		<c:if test="${user.id == null }">
			<input type="submit" value="增加" id="addInfo" />
		</c:if>
	</form:form>
</body>
</html>