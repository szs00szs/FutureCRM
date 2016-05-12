<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <div align="center">
	<table>
		<tr>
		<form action="${pageContext.request.contextPath}/customer/touchQuery" method="post">
			<td>请输入查询内容：<input type="text" name="selectContent" /></td>
			<td>
				请选择查询方式：
				<select name="selectType">
					<option >-- --</option>
					<option value="isTouched">是否联系</option>
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
				<a href="${pageContext.request.contextPath}/customer/customer_saveUI.action">添加客户</a>
			</td>
		</tr>
	</table>			
	
</div> --%>
<div>
	<table>
		<tr>
			<th>联系人</th>
			<th>客户编号</th>
			<th>客户名</th>
			<th>客户等级</th>
			<th>所属行业</th>
			<th>公司规模</th>
			<th>省份</th>
			<th>城市</th>
			<th>联系地址</th>
			<th>公司网址</th>
			<th>邮箱</th>
			<th>电话1</th>
			<th>电话2</th>
			<th>手机</th>
			<th>联系次数</th>
			<th>联系时间</th>
			<th>是否联系</th>
			<th>下次联系时间</th>
		</tr>
		<c:forEach items="${touchCustomerList}" var="customer" varStatus="status">
			<tr>
				<td>
					${customer.contacts.getName() }
				</td>
				<td>
					${customer.code }
				</td>
				<td>
					${customer.name }
				</td>
				<td>
					${customer.grade }
				</td>
				<td>
					${customer.trade }
				</td>
				<td>
					${customer.scale }
				</td>
				<td>
					${customer.province }
				</td>
				<td>
					${customer.city }
				</td>
				<td>
					${customer.address }
				</td>
				<td>
					<a href = "${customer.web }">${customer.web }</a>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/customer/toSendEmailPage/${customer.id}">${customer.email }</a>
				</td>
				<td>
					${customer.tel1 }
				</td>
				<td>
					${customer.tel2 }
				</td>
				<td>
					${customer.mobile }
				</td>
				<td>
					${customer.touchTimes }
				</td>
				<td>
					<c:if test="${customer.isTouched eq 0}">待联系</c:if>
					<c:if test="${customer.isTouched eq -1}">未联系</c:if>
				</td>
				<td>
					<fmt:formatDate value="${customer.touchDate }" pattern="yyyy-MM-dd HH:mm:ss" var="touchDate"/>
					${touchDate }
				</td>
				<td>
					<fmt:formatDate value="${customer.nextTouchDate }" pattern="yyyy-MM-dd HH:mm:ss" var="nextTouchDate"/>
					${nextTouchDate }
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
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
		<script type="text/javascript">
			function gotoPage( pageNum ){
				window.location.href = "${pageContext.request.contextPath}/customer/touchCustomer_list/" + pageNum;
				/* $(document.forms[0]).append("<input type='hidden' name='currentPage' value='" + pageNum +"'>");
				
				document.forms[0].submit(); */
			}
		</script>
		</div>
	</div>
</body>
</html>