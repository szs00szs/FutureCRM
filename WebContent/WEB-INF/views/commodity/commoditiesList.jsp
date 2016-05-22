<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.1.4.js"></script>
</head>
<body>
	<h3 align="center" style="font-family:华义彩云;"> 商品列表</h3>
	<h5 align="left" style="font-family:华义彩云;">
	</h5>
	<table width="100%" height="48" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#aaaaaa"  bordercolorlight="#FFFFFF">
	<tr>
	<td>商品编号</td>
	<td>商品名称</td>
	<td>商品类型</td>
	<td>描述信息</td>
	<td>进价</td>
	<td>售价</td>
	<td>进货数量</td>
	<td>库存数量</td>
	<td>对应操作</td>
	
	</tr>
	<c:forEach items="${commodityList }" var="commodity">
	<tr>
		<td>${commodity.commodityNumber }</td>
		<td>${commodity.name }</td>
		<td>${commodity.commodityCategory.name }</td>
		<td>${commodity.description }</td>
		<td>${commodity.bid }</td>
		<td>${commodity.price }</td>
		<td>${commodity.purchaseQuantity }</td>
		<td>${commodity.commodityQuantity }</td>
		
		<td>
		<shiro:hasPermission name="commodity:delete">
			<a href="${pageContext.request.contextPath }/commodity/deleteCommodity.action?id=${commodity.id}">删除</a>
		</shiro:hasPermission>
		<shiro:hasPermission name="commodity:editCommodity">
			&nbsp;
			<a href="${pageContext.request.contextPath }/commodity/editCommodity.action?id=${commodity.id}">修改</a>
		</shiro:hasPermission>
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
			window.location.href = "${pageContext.request.contextPath}/commodity/queryCommodities/" + pageNum;
	}
</script>
</table>
</body>
</html>