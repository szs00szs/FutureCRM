<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单清单</title>
</head>
<body>
	<h2 align="center">订单清单</h2>
	<table width="100%" height="48" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#aaaaaa"  bordercolorlight="#FFFFFF">
	<tr>
	<td>选择</td>
	<td>订单编号</td>
	<td>创建时间</td>
	<td>业务员</td>
	<td>客户</td>
	<td>联系人</td>
	<td>商品</td>
	<td>数量</td>
	<td>总价</td>
	<td>备注</td>
	<td>操作</td>
	</tr>
	<c:forEach items="${ordersList }" var="order">
	<tr>
		<td><input type="checkbox" name="delete_id" value="${order.id}"></td>
		<td>${order.saleNumber }</td>
		<td><fmt:formatDate value="${order.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		
		<td>${order.salesman.name }</td>
		<td>${order.customer.name }</td>
		<td>${order.contacts.name }</td>
		<td>${order.commodity.name }</td>
		<td>${order.commodityCount }</td>
		<td>${order.commodityCount*order.commodity.price }</td>
		<td>${order.remark }</td>
		<td><a href="${pageContext.request.contextPath }/sales/deleteOrderById.action?id=${order.id}">删除</a>
			<a href="${pageContext.request.contextPath }/sales/orderDetails.action?id=${order.id}">查看</a>
		</td>		
	</tr>
	
	</c:forEach>
</table>
</body>
</html>