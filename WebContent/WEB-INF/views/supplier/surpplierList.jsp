<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>供应商列表</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.1.4.js"></script>
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
			<a href="${pageContext.request.contextPath }/supplier/editSupplier.action?id=${supplier.id}">修改</a>
		</td>		
	</tr>
	
	</c:forEach>
	
<!--分页信息-->
		<div id=PageSelectorBar>
			<div id=PageSelectorMemo>页次：${currentPage }/${pageParameter.totalPage }页
				&nbsp; 每页显示：${pageParameter.pageSize}条 &nbsp;
				总记录数：${pageParameter.totalCount}条</div>
			<div id=PageSelectorSelectorArea>

				<a href="javascript: gotoPage(1)" title="首页" style="cursor: hand;">
					<img
					src="${pageContext.request.contextPath}/images/pageSelector/firstPage.png" />
				</a>

				<c:forEach begin="${pageParameter.beginPageIndex}"
					end="${pageParameter.endPageIndex}" var="num">
					<c:if test="${num == currentPage}">
						<%-- 当前页 --%>
						<span class="PageSelectorNum PageSelectorSelected"><font
							color="red">${num}</font></span>
					</c:if>
					<c:if test="${num != currentPage}">
						<%-- 非当前页 --%>
						<span class="PageSelectorNum" style="cursor: hand;"
							onClick="gotoPage(${num});">${num}</span>
					</c:if>
				</c:forEach>

				<a href="javascript: gotoPage(${pageParameter.totalPage})"
					title="尾页" style="cursor: hand;"> <img
					src="${pageContext.request.contextPath}/images/pageSelector/lastPage.png" />
				</a> 转到： <select onchange="gotoPage(this.value)" id="_pn">
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
			window.location.href = "${pageContext.request.contextPath}/supplier/querySuppliers/" + pageNum;
	}
</script>
</table>
</body>
</html>