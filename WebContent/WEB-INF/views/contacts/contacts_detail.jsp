<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
 	<table>
 	<caption>联系人详细信息</caption>
 	
 		<tr>
 			<td>联系人ID:</td>
 			<td>${contacts.id }</td>
 		</tr>
 		<tr>
 			<td>姓名:</td>
 			<td>${contacts.name }</td>
 		</tr>
 		<tr>
 			<td>性别:</td>
 			<td>${contacts.sex }</td>
 		</tr>
 		<tr>
 			<td>生日:</td>
 			<td>
 				<fmt:formatDate value="${contacts.birthday}" pattern="yyyy-MM-dd HH:mm:ss" var="birthday"/>
 				${birthday }
 			</td>
 		</tr>
 		<tr>
 			<td>部门职务:</td>
 			<td>${contacts.departmentDuties }</td>
 		</tr>
 		<tr>
 			<td>办公室电话:</td>
 			<td>${contacts.officeTelephone }</td>
 		</tr>
 		<tr>
 			<td>家庭电话:</td>
 			<td>${contacts.homePhone }</td>
 		</tr>
 		<tr>
 			<td>手机:</td>
 			<td>${contacts.mobilePhone }</td>
 		</tr>
 		<tr>
 			<td>邮箱:</td>
 			<td>${contacts.email }</td>
 		</tr>
 		<tr>
 			<td>邮编:</td>
 			<td>${contacts.postCode }</td>
 		</tr>
 		<tr>
 			<td>QQ:</td>
 			<td>${contacts.QQNumber }</td>
 		</tr>
 		<tr>
 			<td>联系地址:</td>
 			<td>${contacts.contactAddress }</td>
 		</tr>
 		<tr>
 			<td>爱好:</td>
 			<td>${contacts.hobby }</td>
 		</tr>
 		<tr>
 			<td>忌讳:</td>
 			<td>${contacts.taboo }</td>
 		</tr>
 		<tr>
 			<td>备注:</td>
 			<td>${contacts.remark }</td>
 		</tr>
 	</table>
 </div>
 <div align="right">
 	<a href="${pageContext.request.contextPath }/contacts/contacts_update/${contacts.id}/${currentPage}">编辑</a>
 	<br>
 	<a href="${pageContext.request.contextPath }/contacts/contacts_list/1">返回联系人列表</a>
 </div>
</body>
</html>