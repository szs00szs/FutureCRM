<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>供应商列表</title>
</head>
<body>
	<h3 align="center" style="font-family:华义彩云;"> 供应商列表</h3>
	<table width="100%" height="48" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#aaaaaa"  bordercolorlight="#FFFFFF">
	<tr>
	<td>供应商名称</td>
	<td>联系电话</td>
	<td>操作</td>
	</tr>
	<c:forEach items="${supplierList }" var="supplier">
	<tr>
		<td>${supplier.name }</td>
		<td>${supplier.phone }</td>
		<td><a href="${pageContext.request.contextPath }/supplier/deleteSupplier.action?id=${supplier.id}">删除</a>
			<a href="${pageContext.request.contextPath }/supplier/editSupplierUI.action?id=${supplier.id}">修改</a>
		</td>		
	</tr>
	
	</c:forEach>
</table>
</body>
</html>