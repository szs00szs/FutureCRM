<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品类别列表</title>
</head>
<body>
	<h3 align="center" style="font-family:华义彩云;"> 商品类别列表</h3>
	<h5 align="left" style="font-family:华义彩云;">
		<shiro:hasPermission name="category:addCategory">
			<a href="${pageContext.request.contextPath }/category/addCategory.action">添加商品类别</a>
		</shiro:hasPermission>
	</h5>
	<table width="100%" height="48" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#aaaaaa"  bordercolorlight="#FFFFFF">
	<tr>
	<td>类别名称</td>
	<td>描述</td>
	<td>操作</td>
	</tr>
	<c:forEach items="${categoryList }" var="category">
	<tr>
		<td>${category.name }</td>
		<td>${category.description }</td>
		<td>
		<shiro:hasPermission name="category:delete">
			<a href="${pageContext.request.contextPath }/category/deleteCategory.action?id=${category.id}">删除</a>
		</shiro:hasPermission>
		<shiro:hasPermission name="category:editCategory">
			<a href="${pageContext.request.contextPath }/category/editCategory.action?id=${category.id}">修改</a>
		</shiro:hasPermission>
		</td>		
	</tr>
	
	</c:forEach>
</table>
</body>
</html>