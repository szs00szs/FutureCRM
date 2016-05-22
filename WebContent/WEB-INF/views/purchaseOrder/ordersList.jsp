<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>进货清单</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.1.4.js"></script>
</head>
<body>
	<h2 align="center" style="font-family:华义彩云;">进货清单</h2>
	<table width="100%" height="48" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#aaaaaa"  bordercolorlight="#FFFFFF">
	<tr>
	<td>订单编号</td>
	<td>创建时间</td>
	<td>业务员</td>
	<td>商品</td>
	<td>数量</td>
	<td>供应商</td>
	<td>备注</td>
	<td>操作</td>
	</tr>
	<c:forEach items="${ordersList }" var="order">
	<tr>
		<td>${order.purchaseNo }</td>
		<td><fmt:formatDate value="${order.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		
		<td>${order.user.name }</td>
		<td>${order.commodity.name }</td>
		<td>${order.commodityCount }</td>
		<td>${order.supplier.name }</td>
		<td>${order.remark }</td>
		<td>
			<shiro:hasPermission name="purchase:deleteOrder">
				<a href="${pageContext.request.contextPath }/purchase/deleteOrderById.action?id=${order.id}">删除</a>
			</shiro:hasPermission>
			<shiro:hasPermission name="purchase:orderDetails">
				<a href="${pageContext.request.contextPath }/purchase/orderDetails.action?id=${order.id}">查看</a>
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
			window.location.href = "${pageContext.request.contextPath}/sales/queryOrders/" + pageNum;
	}
</script>
</table>
</body>
</html>