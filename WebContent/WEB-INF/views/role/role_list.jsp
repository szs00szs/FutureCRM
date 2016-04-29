<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限列表</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/sysRole/role_save">增加角色</a>
<br>
<table border="1" style="font-size: 12px;">
		<caption>角色管理</caption>
		<thead>
			<tr class="active">
				<th>角色名称</th>
				<th>角色备注</th>
				<th>编辑</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${!empty roleList }">
					<c:forEach items="${roleList }" var="role"
						varStatus="status">
						<tr>
							<td>${role.name }</td>
							<td>${role.remark }</td>
							<td><a
								href="${pageContext.request.contextPath }/sysRole/role_update/${role.id }/${currentPage }"
								style="margin-right: 10%;"><img
									src="${pageContext.request.contextPath }/images/bian.png">&nbsp;&nbsp;编辑</a>
									<a
								href="${pageContext.request.contextPath }/sysRole/update_privilege/${role.id }"
								style="margin-right: 10%;"><img
									src="${pageContext.request.contextPath }/images/bian.png">&nbsp;&nbsp;修改权限</a>
								<a
								href="${pageContext.request.contextPath }/sysRole/role_delete/${role.id }"><img
									src="${pageContext.request.contextPath }/images/shan.png">&nbsp;&nbsp;删除</a>
							</td>
						</tr>
					</c:forEach>
					
				</c:when>
				<c:otherwise>
						目前本公司没有角色
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
		window.location.href = "${pageContext.request.contextPath}/sysRole/role_list/" + pageNum;
	}
</script>
	</table>
</body>
</html>