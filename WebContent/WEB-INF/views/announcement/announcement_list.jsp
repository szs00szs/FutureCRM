<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<table>
			<tr>
			<form action="${pageContext.request.contextPath}/announcement/query" method="post">
				<td>请输入查询内容：<input type="text" name="selectContent" /></td>
				<td> 
					请选择查询方式：
					<select name="selectType">
						<option value="title">标题</option>
						<option value="issuer">发布人</option>
						<option value="department">所属部门</option>
					</select>
				</td>
				<td><input type="submit" value="查询"  /></td>
			</form>
				<td>
					<shiro:hasPermission name="announcement:save">
						<a href="${pageContext.request.contextPath}/announcement/announcement_save.action">添加公告</a>
					</shiro:hasPermission>
				</td>
			</tr>
		</table>			
		
	</div>
	<div align="center"> 
		<table border="1" cellspacing="0" style="font-size: 12px;table-layout: fixed;">
		<caption>公告列表</caption>
		<thead >
			<tr class="active">
				
				<th>id</th>
				<th>标题</th>
				<th>内容</th>
				<th>发布人</th>
				<th>发布时间</th>
				<th>所属部门</th>
				<th>编辑</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${!empty announcementList }">
					<c:forEach items="${announcementList }" var="announcement"
						varStatus="status">
						<tr>
							<td>${announcement.id}</td>
							<td>${announcement.title }</td>
							<td>${announcement.content }</td>
							<td>${announcement.issuer.getName() }</td>
							<td>
								<fmt:formatDate value="${announcement.issue_date }" pattern="yyyy-MM-dd HH:mm:ss" var="issue_date"/>
								<input name="issue_date" value="${issue_date }"/>
							</td>
							<td>${announcement.department.getName() }</td>
							<td >
								<shiro:hasPermission name="announcement:detail">
									<a href="${pageContext.request.contextPath }/announcement/announcement_detail/${announcement.id}">详情</a>
								</shiro:hasPermission>
								<shiro:hasPermission name="announcement:update">
									<a
										href="${pageContext.request.contextPath }/announcement/announcement_update/${announcement.id }"
										style="margin-right: 10%;"><img
											src="${pageContext.request.contextPath }/images/bian.png">&nbsp;&nbsp;编辑   </a>
								</shiro:hasPermission>
								<shiro:hasPermission name="announcement:delete">
								<a
								href="${pageContext.request.contextPath }/announcement/announcement_delete/${announcement.id }"><img
									src="${pageContext.request.contextPath }/images/shan.png">&nbsp;&nbsp;删除      </a>   
								</shiro:hasPermission>
							</td> 
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
						没有公告
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
					window.location.href = "${pageContext.request.contextPath}/announcement/announcement_list/" + pageNum;
					/* $(document.forms[0]).append("<input type='hidden' name='currentPage' value='" + pageNum +"'>");
					
					document.forms[0].submit(); */
				}
			</script>
		</div>
	</div>
</body>
</html>