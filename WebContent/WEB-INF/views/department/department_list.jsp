<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a
		href="${pageContext.request.contextPath}/sysDepartment/department_saveUI.action">增加部门</a>
	<table border="1" style="font-size: 12px;">
		<caption>部门管理</caption>
		<thead>
			<tr class="active">
				<th>部门</th>
				<th>部门负责人</th>
				<th>部门职能</th>
				<th>备注</th>
				<th>编辑</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${!empty departmentList }">
					<c:forEach items="${departmentList }" var="department"
						varStatus="status">
						<tr>
							<td>${department.name }</td>
							<td>${department.principal }</td>
							<td>${department.incumbent }</td>
							<td>${department.remark }</td>
							<td><a
								href="${pageContext.request.contextPath }/sysDepartment/department_updateUI/${department.id }"
								style="margin-right: 10%;"><img
									src="${pageContext.request.contextPath }/images/bian.png">&nbsp;&nbsp;编辑</a>
								<a
								href="${pageContext.request.contextPath }/sysDepartment/department_delete/${department.id }"><img
									src="${pageContext.request.contextPath }/images/shan.png">&nbsp;&nbsp;删除</a>
							</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
						目前本公司没有部门
				</c:otherwise>
			</c:choose>
			
		</tbody>
	</table>
</body>
</html>