<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap-datetimepicker.min.js"></script> 
<link
	href="${pageContext.request.contextPath }/css/bootstrap-combined.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath }/css/bootstrap-datetimepicker.min.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#datetimepicker1').datetimepicker({
	
		});
		$('#datetimepicker2').datetimepicker({
	
		});
		$('#datetimepicker3').datetimepicker({
	
		});
	});
</script>
</head>
<body>
	<shiro:hasPermission name="user:save">
		<a href="${pageContext.request.contextPath}/sysUser/user_save.action">增加用户</a>
	</shiro:hasPermission>
	<hr>
	<br>
	<form:form action="${pageContext.request.contextPath}/sysUser/user_query" method="post" modelAttribute="user">
		
		<h3>基本信息</h3>
		<table border="1">
			<c:if test="${user.id != null }">
				<form:hidden path="id" />
			</c:if>
			<tr>
				<td>登录名</td>
				<td><input type="text" name="loginName"
					value="${user.loginName}" /></td>
				<td>中文名</td>
				<td><input type="text" name="name" value="${user.name}" />必填</td>
			</tr>
			<tr>
				<c:if test="${user.id == null }">
					<td>密码</td>
					<td><input type="password" name="password" /></td>
				</c:if>
				<td>推荐人</td>
				<td><input type="text" name="commendMan"
					value="${user.commendMan}" /></td>
			</tr>
			<tr>
				<td>移动电话</td>
				<td><input type="text" name="moveTelephone"
					value="${user.moveTelephone}" /></td>
				<td>电子邮件</td>
				<td>
					<%-- <input type="text" name="email" value="${user.email}"/> --%> 
					<%-- <form:input	path="email" /> 
					<form:errors path="email"></form:errors> --%>
				</td>
			</tr>
			<tr>
				<td>家庭地址</td>
				<td><input type="text" name="address" value="${user.address}" /></td>
				<td>家庭电话</td>
				<td><input type="text" name="telephone"
					value="${user.telephone}" /></td>
			</tr>
			<tr>
				<td>现住宅地址</td>
				<td><input type="text" name="nowAddress"
					value="${user.nowAddress}" /></td>
				<td>现住宅电话</td>
				<td><input type="text" name="nowTelephone"
					value="${user.nowTelephone}" /></td>
			</tr>
			<tr>
				<td>身份证号码</td>
				<td><input type="text" name="identityCode"
					value="${user.identityCode}" /></td>
				<td>社会保险号</td>
				<td><input type="text" name="insuranceCode"
					value="${user.insuranceCode}" /></td>
			</tr>

			<tr>
				<td>紧急联系人</td>
				<td><input type="text" name="instancyLinkman"
					value="${user.instancyLinkman}" /></td>
				<td>紧急联系电话</td>
				<td><input type="text" name="instancyTelephone"
					value="${user.instancyTelephone}" /></td>
			</tr>
			<tr>
				<td>起始有效日期</td>
				<td>
						<%-- <fmt:formatDate value="${user.beginDate}" pattern="yyyy-MM-dd HH:mm:ss" var="beginDate"/>
				<input type="text" name="beginDate" value="${beginDate}"/> --%>
					<div id="datetimepicker1" class="input-append date">
						<fmt:formatDate value="${user.beginDate}" pattern="yyyy-MM-dd HH:mm:ss" var="beginDate"/>
						<input name="beginDate" id="datetimepicker1" value="${beginDate}" data-format="yyyy-MM-dd hh:mm:ss"
							type="text" /> 
						<span class="add-on"> 
							<i data-time-icon="icon-time" data-date-icon="icon-calendar"> </i>
						</span>
					</div>
				</td>
				<td>终止有效日期</td>
				<td>
				<%-- <fmt:formatDate value="${user.endDate}"
						pattern="yyyy-MM-dd HH:mm:ss" var="endDate" /> <input type="text"
					name="endDate" value="${endDate}" /> --%>
					<div id="datetimepicker2" class="input-append date">
						<fmt:formatDate value="${user.endDate}"
							pattern="yyyy-MM-dd HH:mm:ss" var="endDate" />
						<input name="endDate" id="datetimepicker2" value="${endDate}" data-format="yyyy-MM-dd hh:mm:ss"
							type="text" /> 
						<span class="add-on"> 
							<i data-time-icon="icon-time" data-date-icon="icon-calendar"> </i>
						</span>
					</div>
				</td>
			</tr>
			<tr>
				<td>所属部门</td>
				<td><select name="department.id" id="department"
					style="border: solid #ccc 1px;" id="select">
						<c:forEach items="${departmentList}" var="dp">
							<c:if test="${dp.id == user.department.getId() }">
								<option value="${dp.id}" selected="selected">${dp.name}</option>
							</c:if>
							<c:if test="${dp.id != user.department.getId() }">
								<option value="${dp.id}">${dp.name}</option>
							</c:if>
						</c:forEach>
				</select></td>
				<td>状态</td>
				<td><input type="radio" name="status" value="Y"
					<c:if test="${user.status== 'Y'}">checked="checked"</c:if> />启用 <input
					type="radio" name="status" value="N"
					<c:if test="${user.status== 'N'}">checked="checked"</c:if> />停用</td>
			</tr>
		</table>
		<h3>详细信息</h3>
		<table border="1">
			<tr>
				<td>性别</td>
				<td><input type="radio" name="sex" value="男"
					<c:if test="${user.sex== '男'}">checked="checked"</c:if> />男 <input
					type="radio" name="sex" value="女"
					<c:if test="${user.sex== '女'}">checked="checked"</c:if> />女</td>
				<td>出生日期</td>
				<td>
					<%-- <fmt:formatDate value="${user.birthday}"
							pattern="yyyy-MM-dd HH:mm:ss" var="birthday" /> <input type="text"
						name="birthday" value="${birthday}" /> --%>
					<div id="datetimepicker3" class="input-append date">
						<fmt:formatDate value="${user.birthday}"
							pattern="yyyy-MM-dd HH:mm:ss" var="birthday" />
						<input name="birthday" id="datetimepicker3" value="${birthday}" data-format="yyyy-MM-dd hh:mm:ss"
							type="text" /> 
						<span class="add-on"> 
							<i data-time-icon="icon-time" data-date-icon="icon-calendar"> </i>
						</span>
					</div>
				</td>
			</tr>
			<tr>
				<td>职务类别</td>
				<td><input type="radio" name="personnelType" value="全职"
					<c:if test="${user.personnelType== '全职'}">checked="checked"</c:if> />全职
					<input type="radio" name="personnelType" value="兼职"
					<c:if test="${user.personnelType== '兼职'}">checked="checked"</c:if> />兼职
				</td>
				<td>职务</td>
				<td><input type="text" name="duty" value="${user.duty}" /></td>
			</tr>
		</table>
		<input type="submit" value="查询"/>
	</form:form>
	<hr>
	<br>
	<table border="1">
		<tr>
			<td>id</td>
			<td>登录名</td>
			<td>中文名</td>
			<td>家庭住址</td>
			<td>部门名称</td>
			<td>备注</td>
			<td>编辑</td>
		</tr>
		<c:choose>
				<c:when test="${!empty userList }">
					<c:forEach items="${userList }" var="user"
						varStatus="status">
						<tr>
							<td>${user.id }</td>
							<td>${user.loginName }</td>
							<td>${user.name }</td>
							<td>${user.address }</td>
							<td>${user.department.getName() }</td>
							<td>${user.remark }</td>
							<td>
								<shiro:hasPermission name="user:update">
									<a
									href="${pageContext.request.contextPath }/sysUser/user_update/${user.id }/${currentPage }"
									style="margin-right: 10%;"><img
										src="${pageContext.request.contextPath }/images/bian.png">&nbsp;&nbsp;编辑</a>
								</shiro:hasPermission>
								<shiro:hasPermission name="user:delete">
									<a
									href="${pageContext.request.contextPath }/sysUser/user_delete/${user.id }"><img
										src="${pageContext.request.contextPath }/images/shan.png">&nbsp;&nbsp;删除</a>
								</shiro:hasPermission>
							</td>
						</tr>
					</c:forEach>
					
				</c:when>
				<c:otherwise>
						目前本公司没有用户
				</c:otherwise>
			</c:choose>
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
		window.location.href = "${pageContext.request.contextPath}/sysUser/user_list/" + pageNum;
		/* $(document.forms[0]).append("<input type='hidden' name='currentPage' value='" + pageNum +"'>");
		
		document.forms[0].submit(); */
	}
</script>
	</table>

</body>
</html>