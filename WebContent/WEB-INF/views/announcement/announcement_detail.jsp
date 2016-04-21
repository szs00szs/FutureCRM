<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
	 <div>
	 	<center>${announcement.title }</center>
	 	<div>
	 		<fmt:formatDate value="${announcement.issue_date }" pattern="yyyy-MM-dd HH:mm:ss" var="issue_date"/>
	 		${issue_date} &nbsp;
	 		${announcement.issuer.name }&nbsp;
	 		${announcement.department.getName() }&nbsp;
	 	</div>
	 	<hr>
	 	<div>
	 		<center>
	 			<p>${announcement.content}</p>
	 		</center>
	 	</div>
	 </div>
 	<table>
 	<caption>公告详细信息</caption>
 	
 		<tr>
 			<td>公告ID</td>
 			<td><input name="id" value="${announcement.id }"></td>
 		</tr>
 		<tr>
 			<td>公告标题</td>
 			<td><input name="code" value="${announcement.title }"></td>
 		</tr>
 		<tr>
 			<td>公告内容</td>
 			<td><input name="name" value="${announcement.content }"></td>
 		</tr>
 		<tr>
 			<td>发布日期</td>
 			<td>
				<fmt:formatDate value="${announcement.issue_date }" pattern="yyyy-MM-dd HH:mm:ss" var="issue_date"/>
				<input name="issue_date" value="${issue_date }"/>
			</td>
 		</tr>
 		<tr>
 			<td>发布人</td>
 			<td><input name="contacts.name" value="${announcement.issuer.getName() }" /></td>
 		</tr>
 		<tr>
 			<td>所属部门</td>
 			<td><input name="regionName" value="${announcement.department.getName() }"></td>
 		</tr>
 	</table>
 </div>
 <div align="right">
 	<a href="${pageContext.request.contextPath }/announcement/announcement_updateUI/${announcement.id}">编辑</a>
 	<br>
 	<a href="${pageContext.request.contextPath }/announcement/announcement_list">返回公告列表</a>
 </div>
</body>
</html>