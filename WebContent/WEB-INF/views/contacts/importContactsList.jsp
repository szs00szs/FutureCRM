<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-2.1.4.js"></script>
	<script type="text/javascript">
		$(function(){
		/* 	alert(1)
			var date = JSON.stringify("${contactsList}");
			alert(date)
			$("#export").click(function(){
				$.post("${pageContext.request.contextPath}/contacts/export",
					date,
				  function(data,status){
				    alert("Data: " + data + "\nStatus: " + status);
				  })
			}) */
		})
	</script>
</head>
 <body>
	<div align="center">
		<table border="1" cellspacing="0" style="font-size: 12px;table-layout: fixed;">
		<caption>联系人列表</caption>
		<thead >
			<tr class="active">
				
				<th>id</th>
				<th>姓名</th>
				<th>性别</th>
				<th>生日</th>
				<th>部门职务</th>
				<th>办公室电话</th>
				<th>家庭电话</th>
				<th>手机</th>
				<th>邮箱</th>
				<th>邮编</th>
				<th>QQ</th>
				<th>联系地址</th>
				<th>爱好</th>
				<th>忌讳</th>
				<th>备注</th>
				
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${!empty contactsList }">
					<c:forEach items="${contactsList }" var="contacts"
						varStatus="status">
						<tr>
							<td>${contacts.id}</td>
							<td>${contacts.name}</td>
							<td>${contacts.sex}</td>
							<td>
								<fmt:formatDate value="${contacts.birthday}" pattern="yyyy-MM-dd HH:mm:ss" var="birthday"/>
								${birthday }
							</td>
							<td>${contacts.departmentDuties}</td>
							<td>${contacts.officeTelephone}</td>
							<td>${contacts.homePhone}</td>
							<td>${contacts.mobilePhone }</td>
							<td>${contacts.email}</td>
							<td>${contacts.postCode}</td>
							<td>${contacts.QQNumber}</td>
							<td>${contacts.contactAddress}</td>
							<td>${contacts.hobby}</td>
							<td>${contacts.taboo}</td>
							<td>${contacts.remark}</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
						没有联系人
				</c:otherwise>
			</c:choose>

		</tbody>
	</table>
	</div>
	<div>
		<span><a href="${pageContext.request.contextPath }/contacts/contacts_list/1">返回联系人列表</a></span>
		<span><a href="${pageContext.request.contextPath }/workspace">返回工作页面</a></span>
	</div>
</body>
</html>