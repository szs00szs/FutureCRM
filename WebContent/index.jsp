<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.1.4.js"></script>
</head>
<body>

<!-- shishuai -->
<a href="${pageContext.request.contextPath}/sales/queryOrders.action">查询销售订单</a>
<br>
<a href="${pageContext.request.contextPath}/sales/addOrderUI.action">添加订单</a>
<br>
<a href="${pageContext.request.contextPath}/purchase/queryOrders.action">查询进货单</a>
<br>
<a href="${pageContext.request.contextPath}/purchase/addOrderUI.action">添加进货单</a>
<br>
<br>

<!-- wangshigen -->
<a href="${pageContext.request.contextPath}/sysDepartment/department_list/2">部门列表</a>
<br>
<a href="${pageContext.request.contextPath}/sysUser/user_list/1">用户列表</a>
<br>
<a href="${pageContext.request.contextPath}/sysRole/role_list/1">角色列表</a>
<br>

<%-- <jsp:forward page="/WEB-INF/views/login.jsp"></jsp:forward> --%>
</body>
</html>