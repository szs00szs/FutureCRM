<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.4.js"></script>
</head>
<body>
	<a
		href="${pageContext.request.contextPath}/sysDepartment/department_saveUI">增加部门</a>
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
								href="${pageContext.request.contextPath }/sysDepartment/department_updateUI/${department.id }/${currentPage }"
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
		<%-- <%@ include file="/WEB-INF/views/public/pageView.jspf" %> --%>
		<!--分页信息-->
<div id=PageSelectorBar>
	<div id=PageSelectorMemo>页次：${currentPage }/${pageParameter.totalPage }页 &nbsp;
		每页显示：${pageParameter.pageSize}条 &nbsp; 总记录数：${pageParameter.totalCount}条</div>
	<div id=PageSelectorSelectorArea>

		<a href="javascript: gotoPage(1)" title="首页" style="cursor: hand;">
			<img src="${pageContext.request.contextPath}/images/pageSelector/firstPage.png"/>
		</a>
		
		<c:forEach begin="${pageParameter.beginPageIndex}" end="${pageParameter.endPageIndex}" var="num">
			<c:if test="${num == currentPage}"> <%-- 当前页 --%>
				<span class="PageSelectorNum PageSelectorSelected" ><font color="red">${num}</font></span>
			</c:if>
			<c:if test="${num != currentPage}"> <%-- 非当前页 --%>
				<span class="PageSelectorNum" style="cursor: hand;" onClick="gotoPage(${num});">${num}</span>
			</c:if>
		</c:forEach>
		
		<a href="javascript: gotoPage(${pageParameter.totalPage})" title="尾页" style="cursor: hand;">
			<img src="${pageContext.request.contextPath}/images/pageSelector/lastPage.png"/>
		</a>
		
		转到：
		<select onchange="gotoPage(this.value)" id="_pn">
			<c:forEach begin="1" end="${pageParameter.totalPage}" var="num">
				<option value="${num}">${num}</option>
			</c:forEach>
		</select>
		<script type="text/javascript">
			$("#_pn").val("${pageParameter.currentPage}");
		</script>
		
	</div>
</div>


<script type="text/javascript">
	function gotoPage( pageNum ){
		window.location.href = "${pageContext.request.contextPath}/sysDepartment/department_list/" + pageNum;
		/* $(document.forms[0]).append("<input type='hidden' name='currentPage' value='" + pageNum +"'>");
		
		document.forms[0].submit(); */
	}
</script>
	</table>
</body>
=======
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
>>>>>>> branch 'dev' of ssh://wangshigen@10.1.24.239:29418/FutureCRM.git
</html>