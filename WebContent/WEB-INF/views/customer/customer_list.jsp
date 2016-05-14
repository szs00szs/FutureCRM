<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
					<shiro:hasPermission name="customer:save">
						<a href="${pageContext.request.contextPath}/customer/customer_save.action">添加客户</a>
					</shiro:hasPermission>
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
								<shiro:hasPermission name="customer:detail">
									<a href="${pageContext.request.contextPath }/customer/customer_detail/${customer.id}">详情</a>
								</shiro:hasPermission>
								<shiro:hasPermission name="customer:update">
									<a
										href="${pageContext.request.contextPath }/customer/customer_update/${customer.id }"
										style="margin-right: 10%;"><img
											src="${pageContext.request.contextPath }/images/bian.png">&nbsp;&nbsp;编辑   </a>
								</shiro:hasPermission>
								<shiro:hasRole name="customer:delete">
									<a
									href="${pageContext.request.contextPath }/customer/customer_delete/${customer.id }"><img
										src="${pageContext.request.contextPath }/images/shan.png">&nbsp;&nbsp;删除      </a>   
								</shiro:hasRole>
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
					window.location.href = "${pageContext.request.contextPath}/customer/customer_list/" + pageNum;
					/* $(document.forms[0]).append("<input type='hidden' name='currentPage' value='" + pageNum +"'>");
					
					document.forms[0].submit(); */
				}
			</script>
		</div>
	</div>
	<div>
		<span><a href="${pageContext.request.contextPath }/workspace">返回工作页面</a></span>
	</div>
</body>
</html>