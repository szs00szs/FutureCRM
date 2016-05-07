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
</head>
<body>
	<div align="center">
		<table>
			<tr>
			<form action="${pageContext.request.contextPath}/customer/query" method="post">
				<td>请输入查询内容：<input type="text" name="selectContent" /></td>
				<td>
					请选择查询方式：
					<select name="selectType">
						<option >-- --</option>
						<option value="name">客户姓名</option>
						<option value="code">客户编号</option>
						<option value="source">客户来源</option>
						<option value="kind">客户性质</option>
						<option value="contacts_name">联系人</option>
						<option value="user_name">所属用户</option>
					</select>
				</td>
				<td><input type="submit" value="查询"  /></td>
			</form>
				<td>
					<a href="${pageContext.request.contextPath}/customer/customer_save.action">添加客户</a>
				</td>
			</tr>
		</table>			
		
	</div>
	<div align="center">
		<table border="1" cellspacing="0" style="font-size: 12px;table-layout: fixed;">
		<caption>客户列表</caption>
		<thead >
			<tr class="active">
				
				<th>公司名</th>
				<th>公司编号</th>
				<th>客户等级</th>
				<th>联系人</th>
				<th>联系人职位</th>
				<th>来源</th>
				<th>所属员工</th>
				<th>客户性质</th>
				<th>电话</th>
				<th>属性</th>
				<th>邮箱</th>		
				<th>编辑</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${!empty customerList }">
					<c:forEach items="${customerList }" var="customer"
						varStatus="status">
						<tr>
							<td>${customer.name}</td>
							<td>${customer.code }</td>
							<td>${customer.grade }</td>
							<td>${customer.contacts.getName() }</td>
							<td>${customer.contacts.getDepartmentDuties() }</td>
							<td>${customer.source }</td>
							<th>${customer.user.getName() }</th>
							<td>${customer.quality }</td>
							<td>${customer.tel1 }</td>
							<td>${customer.kind }</td>
							<td>${customer.email }</td>
							<td >
								<a href="${pageContext.request.contextPath }/customer/customer_detail/${customer.id}">详情</a>
							<a
								href="${pageContext.request.contextPath }/customer/customer_update/${customer.id }"
								style="margin-right: 10%;"><img
									src="${pageContext.request.contextPath }/images/bian.png">&nbsp;&nbsp;编辑   </a>
								<a
								href="${pageContext.request.contextPath }/customer/customer_delete/${customer.id }"><img
									src="${pageContext.request.contextPath }/images/shan.png">&nbsp;&nbsp;删除      </a>   
							</td> 
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
						没有客户
				</c:otherwise>
			</c:choose>

		</tbody>
	</table>
	</div>
</body>
</html>