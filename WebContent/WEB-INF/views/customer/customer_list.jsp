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
	<a
		href="${pageContext.request.contextPath}/customer/customer_saveUI.action">添加客户</a>
	<table border="1" cellspacing="0" style="font-size: 12px;">
		<caption>客户列表</caption>
		<thead>
			<tr class="active">
				<th>id</th>
				<th>姓名</th>
				<th>编辑</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${!empty customerList }">
					<c:forEach items="${customerList }" var="customer"
						varStatus="status">
						<tr>
							<td>${customer.id}</td>
							<td>${customer.name }</td>
							<td>
								<a href="${pageContext.request.contextPath }/customer/customer_detail/${customer.id}">查看详细信息</a>
							<a
								href="${pageContext.request.contextPath }/customer/customer_updateUI/${customer.id }"
								style="margin-right: 10%;"><img
									src="${pageContext.request.contextPath }/images/bian.png">&nbsp;&nbsp;编辑</a>
								<a
								href="${pageContext.request.contextPath }/customer/customer_delete/${customer.id }"><img
									src="${pageContext.request.contextPath }/images/shan.png">&nbsp;&nbsp;删除</a>
							</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
						没有新闻
				</c:otherwise>
			</c:choose>

		</tbody>
	</table>
</body>
</html>