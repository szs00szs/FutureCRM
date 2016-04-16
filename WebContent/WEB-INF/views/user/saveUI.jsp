<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人员添加</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-2.1.4.js"></script>
<script type="text/javascript">
	$(function() {
		$("#updateInfo").click(function() {
			var url = "${pageContext.request.contextPath }/sysUser/user_update";
				
			//更改form的action
			$("#user_form").attr("action", url);
			//触发submit事件，提交表单 
			$("#user_form").submit();
		});
		$("#addInfo").click(function() {
			var url = "${pageContext.request.contextPath }/sysUser/user_save";
			alert(url)
			//更改form的action  
			$("#user_form").attr("action", url);
			//触发submit事件，提交表单   
			$("#user_form").submit();
		});
	})
	
</script>
</head>
<body>
<form:form name="user_form" method="POST" action="#" modelAttribute="user">
	<h3>基本信息</h3>
	<table border="1">
		<c:if test="${user != null }">
			<form:hidden path="id" />
		</c:if>
		<tr>
			<td>用户名</td>
			<td><input type="text" name="loginName" value="${user.loginName}"/></td>
			<td>中文名</td>
			<td><input type="text" name="name" value="${user.name}"/></td>
		</tr>
		<tr>
			<c:if test="${user.id == null }">
				<td>密码</td>
				<td><input type="password" name="password"/></td>
			</c:if>
			<td>推荐人</td>
			<td><input type="text" name="commendMan" value="${user.commendMan}"/></td>
		</tr>
		<tr>
			<td>移动电话</td>
			<td><input type="text" name="moveTelephone" value="${user.moveTelephone}"/></td>
			<td>电子邮件</td>
			<td>
				<%-- <input type="text" name="email" value="${user.email}"/> --%>
				<form:input path="email"/>
				<form:errors path="email"></form:errors>
			</td>
		</tr>
		<tr>
			<td>家庭地址</td>
			<td><input type="text" name="address" value="${user.address}"/></td>
			<td>家庭电话</td>
			<td><input type="text" name="telephone" value="${user.telephone}"/></td>
		</tr>
		<tr>
			<td>现住宅地址</td>
			<td><input type="text" name="nowAddress" value="${user.nowAddress}"/></td>
			<td>现住宅电话</td>
			<td><input type="text" name="nowTelephone" value="${user.nowTelephone}"/></td>
		</tr>
		<tr>
			<td>身份证号码</td>
			<td><input type="text" name="identityCode" value="${user.identityCode}"/></td>
			<td>社会保险号</td>
			<td><input type="text" name="insuranceCode" value="${user.insuranceCode}"/></td>
		</tr>
		
		<tr>
			<td>紧急联系人</td>
			<td><input type="text" name="instancyLinkman" value="${user.instancyLinkman}"/></td>
			<td>紧急联系电话</td>
			<td><input type="text" name="instancyTelephone" value="${user.instancyTelephone}"/></td>
		</tr>
		<tr>
			<td>起始有效日期</td>
			<td>
				<fmt:formatDate value="${beginDate}" pattern="yyyy-MM-dd HH:mm:ss" var="beginDate"/>
				<input type="text" name="beginDate" value="${user.beginDate}"/>
			</td>
			<td>终止有效日期</td>
			<td>
				<fmt:formatDate value="${endDate}" pattern="yyyy-MM-dd HH:mm:ss" var="endDate"/>
				<input type="text" name="endDate" value="${user.endDate}"/>
			</td>
		</tr>
		<tr>
			<td>所属部门</td>
			<td>
				<select name="department" id="department" style="border:solid #ccc 1px;">
				    <c:forEach items="${departmentList}" var="dp">
				    	<option value="${dp.id}">${dp.name}</option>
				    </c:forEach>
				 </select>
				 
			</td>
			<td>状态</td>
			<td>
				<input type="radio" name="${user.status}" value="1"/>启用
				<input type="radio" name="${user.status}" value="0"/>停用
			</td>
		</tr>
	</table>
	<h3>详细信息</h3>
	<table border="1">
		<tr>
			<td>性别</td>
			<td>
				<input type="radio" name="${user.sex}" value="男"/>男
				<input type="radio" name="${user.sex}" value="女"/>女
			</td>
			<td>出生日期</td>
			<td>
				<fmt:formatDate value="${birthday}" pattern="yyyy-MM-dd HH:mm:ss" var="birthday"/>
				<input type="text" name="birthday" value="${user.birthday}"/>
			</td>
		</tr>
		<tr>
			<td>职务类别</td>
			<td>
				<input type="radio" name="${user.personnelType }" value="全职"/>全职
				<input type="radio" name="${user.personnelType }" value="兼职"/>兼职
			</td>
			<td>职务</td>
			<td>
				<input type="text" name="duty" value="${user.duty}"/>
			</td>
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