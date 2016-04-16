<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>查询成功</h3>
	订单列表：
	<table width="100%" height="48" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#aaaaaa"  bordercolorlight="#FFFFFF">
	<tr>
	<td>选择</td>
	<td>订单编号</td>
	<td>创建时间</td>
	<td>业务员</td>
	<td>客户</td>
	<td>联系人</td>
	<td>联系人电话</td>
	<td>收件地址</td>
	<td>备注</td>
	<td>清单</td>
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
		<td>${order.contactPhone }</td>
		<td>${order.deliveryAddress }</td>
		<td>${order.remark }</td>
		<td>${order.goods }</td>
		<td><a href="${pageContext.request.contextPath }/sales/deleteOrderById.action?id=${order.id}">删除</a>
			<a href="${pageContext.request.contextPath }/sales/editOrderById.action?id=${order.id}">修改</a>
		</td>		
	</tr>
	
	</c:forEach>
</table>
</body>
</html>