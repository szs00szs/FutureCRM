<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-2.1.4.js"></script>
	<script type="text/javascript">
		$(function(){
		/* 	alert(1)
			var date = JSON.stringify("${contactsList}");
			alert(date)
			$("#export").click(function(){
				$.post("${pageContext.request.contextPath}/contacts/export",
					date,
				  function(data,status){
				    alert("Data: " + data + "\nStatus: " + status);
				  })
			}) */
		})
	</script>
</head>
 <body>
	<div align="center">
		<table>
			<tr>
			<form action="${pageContext.request.contextPath}/contacts/query" method="post">
				<td>请输入查询内容：<input type="text" name="selectContent" /></td>
				<td>
					请选择查询方式：
					<select name="selectType">
						<option value="name">姓名</option>
						<option value="QQ">QQ</option>
						<option value="departmentDuties">公司职务</option>
					</select>
				</td>
				<td><input type="submit" value="查询"  /></td>
			</form>
				<td>
<<<<<<< HEAD
					<shiro:hasPermission name="contacts:save">
						<a href="${pageContext.request.contextPath}/contacts/contacts_save.action">添加联系人</a>
					</shiro:hasPermission>
=======
					<a href="${pageContext.request.contextPath}/contacts/contacts_saveUI.action">添加联系人</a>
>>>>>>> branch 'dev' of ssh://wangshigen@10.1.24.239:29418/FutureCRM.git
				</td>
			</tr>
		</table>			
		
	</div>
	<div>
	<a href="${pageContext.request.contextPath }/contacts/export">导出</a>
	<%-- <a href="${pageContext.request.contextPath }/contacts/import">导入</a> --%>
	<form:form action="${pageContext.request.contextPath }/contacts/import">
		<input type="file" name="file" />
		<button>导入</button>
	</form:form>
	<a href="${pageContext.request.contextPath }/contacts/import/template">下载模板</a>
	</div>
	<div align="center">
		<table border="1" cellspacing="0" style="font-size: 12px;table-layout: fixed;">
		<caption>联系人列表</caption>
		<thead >
			<tr class="active">
				
				<th>id</th>
				<th>姓名</th>
				<th>性别</th>
				<th>生日</th>
				<th>部门职务</th>
				<th>办公室电话</th>
				<th>家庭电话</th>
				<th>手机</th>
				<th>邮箱</th>
				<th>邮编</th>
				<th>QQ</th>
				<th>联系地址</th>
				<th>爱好</th>
				<th>忌讳</th>
				<th>备注</th>
				<th>操作</th>
				
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${!empty contactsList }">
					<c:forEach items="${contactsList }" var="contacts"
						varStatus="status">
						<tr>
							<td>${contacts.id}</td>
							<td>${contacts.name}</td>
							<td>${contacts.sex}</td>
							<td>
								<fmt:formatDate value="${contacts.birthday}" pattern="yyyy-MM-dd HH:mm:ss" var="birthday"/>
								${birthday }
							</td>
							<td>${contacts.departmentDuties}</td>
							<td>${contacts.officeTelephone}</td>
							<td>${contacts.homePhone}</td>
							<td>${contacts.mobilePhone }</td>
							<td>${contacts.email}</td>
							<td>${contacts.postCode}</td>
							<td>${contacts.QQNumber}</td>
							<td>${contacts.contactAddress}</td>
							<td>${contacts.hobby}</td>
							<td>${contacts.taboo}</td>
							<td>${contacts.remark}</td>
							<td>
<<<<<<< HEAD
								<shiro:hasPermission name="contacts:detail">
									<a href="${pageContext.request.contextPath }/contacts/contacts_detail/${contacts.id}">详情</a>
								</shiro:hasPermission>
								<shiro:hasPermission name="contacts:update">
									<a href="${pageContext.request.contextPath }/contacts/contacts_update/${contacts.id }"style="margin-right: 10%;">
										<img src="${pageContext.request.contextPath }/images/bian.png">
										&nbsp;&nbsp;编辑 
									</a>
								</shiro:hasPermission>
								<shiro:hasPermission name="contacts:delete">
=======
								<a href="${pageContext.request.contextPath }/contacts/contacts_detail/${contacts.id}">详情</a>
								<a href="${pageContext.request.contextPath }/contacts/contacts_updateUI/${contacts.id }"style="margin-right: 10%;">
									<img src="${pageContext.request.contextPath }/images/bian.png">
									&nbsp;&nbsp;编辑 
								</a>
>>>>>>> branch 'dev' of ssh://wangshigen@10.1.24.239:29418/FutureCRM.git
									<a href="${pageContext.request.contextPath }/contacts/contacts_delete/${contacts.id }">
										<img src="${pageContext.request.contextPath }/images/shan.png">
										&nbsp;&nbsp;删除     
									</a>   
								</shiro:hasPermission>
							</td> 
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
						没有联系人
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
					window.location.href = "${pageContext.request.contextPath}/contacts/contacts_list/" + pageNum;
					/* $(document.forms[0]).append("<input type='hidden' name='currentPage' value='" + pageNum +"'>");
					
					document.forms[0].submit(); */
				}
			</script>
		</div>
	</div>
	
	<div>
		<span><a href="${pageContext.request.contextPath }/login">返回工作页面</a></span>
	</div>
</body>
</html>