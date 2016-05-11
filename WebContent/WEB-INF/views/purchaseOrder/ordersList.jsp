<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>进货清单</title>
</head>
<body>
	<h2 align="center" style="font-family:华义彩云;">进货清单</h2>
	<table width="100%" height="48" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#aaaaaa"  bordercolorlight="#FFFFFF">
	<tr>
	<td>选择</td>
	<td>订单编号</td>
	<td>创建时间</td>
	<td>业务员</td>
	<td>商品</td>
	<td>数量</td>
	<td>供应商</td>
	<td>备注</td>
	<td>操作</td>
	</tr>
	<c:forEach items="${ordersList }" var="order">
	<tr>
		<td><input type="checkbox" name="delete_id" value="${order.id}"></td>
		<td>${order.purchaseNo }</td>
		<td><fmt:formatDate value="${order.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		
		<td>${order.user.name }</td>
		<td>${order.commodity.name }</td>
		<td>${order.commodityCount }</td>
		<td>${order.supplier.name }</td>
		<td>${order.remark }</td>
		<td>
			<shiro:hasPermission name="purchase:deleteOrder">
				<a href="${pageContext.request.contextPath }/purchase/deleteOrderById.action?id=${order.id}">删除</a>
			</shiro:hasPermission>
			<shiro:hasPermission name="purchase:orderDetails">
				<a href="${pageContext.request.contextPath }/purchase/orderDetails.action?id=${order.id}">查看</a>
			</shiro:hasPermission>
		</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>