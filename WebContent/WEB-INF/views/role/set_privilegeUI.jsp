<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="javascript"
	src="${pageContext.request.contextPath}/script/jquery_treeview/jquery.treeview.js"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/script/jquery_treeview/jquery.treeview.css" />
</head>
<body>
<!-- 标题显示 -->
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				配置权限
			</div>
			<div id="Title_End"></div>
		</div>
	</div>
	<!--显示表单内容-->
	<div id=MainArea>
		<form:form action="${pageContext.request.contextPath}/role/set_privilege" method="post" modelAttribute="role">
			<form:hidden path="id"/>
			<div class="ItemBlock_Title1">
				<!-- 信息说明 -->
				<div class="ItemBlock_Title1">
					正在为【${role.name}】配置权限
				</div>
			</div>
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<table cellpadding="0" cellspacing="0" class="mainForm">
						<!--表头-->
						<thead>
							<tr align="LEFT" valign="MIDDLE" id="TableTitle">
								<td width="300px" style="padding-left: 7px;">
									<!-- 如果把全选元素的id指定为selectAll，并且有函数selectAll()，就会有错。因为有一种用法：可以直接用id引用元素 -->
									<input type="CHECKBOX" id="cbSelectAll"
									onClick="$('[name=privilegeIds]').attr('checked',this.checked)" />
									<label for="cbSelectAll">全选</label>
								</td>
							</tr>
						</thead>

						<!--显示数据列表-->
						<tbody id="TableData">
							<tr class="TableDetail1">
								<!-- 显示权限树 -->
								<td>

									<ul id="tree">
										<c:forEach items="${topPrivilegeList }" var="topPrivilege">
											<li><input type="checkbox" name="privilegeIds"
												value="${topPrivilege.id}" id="cb_${topPrivilege.id}" />
												<label for="cb_${id}"><span class="folder">${topPrivilege.name}</span></label>
												<ul>
													<s:iterator value="children">
														<li><input type="checkbox" name="privilegeIds"
															value="${id}" id="cb_${id}"
															<s:property value="%{id in privilegeIds ? 'checked' : ''}"/> />
															<label for="cb_${id}"><span class="folder">${name}</span></label>
															<ul>
																<s:iterator value="children">
																	<li><input type="checkbox" name="privilegeIds"
																		value="${id}" id="cb_${id}"
																		<s:property value="%{id in privilegeIds ? 'checked' : ''}"/> />
																		<label for="cb_${id}"><span class="folder">${name}</span></label>
																	</li>
																</s:iterator>
															</ul></li>
													</s:iterator>
												</ul></li>
										</c:forEach>
										<s:iterator value="#application.topPrivilegeList">
											<li><input type="checkbox" name="privilegeIds"
												value="${role.id}" id="cb_${id}"
												<s:property value="%{id in privilegeIds ? 'checked' : ''}"/> />
												<label for="cb_${id}"><span class="folder">${name}</span></label>
												<ul>
													<s:iterator value="children">
														<li><input type="checkbox" name="privilegeIds"
															value="${id}" id="cb_${id}"
															<s:property value="%{id in privilegeIds ? 'checked' : ''}"/> />
															<label for="cb_${id}"><span class="folder">${name}</span></label>
															<ul>
																<s:iterator value="children">
																	<li><input type="checkbox" name="privilegeIds"
																		value="${id}" id="cb_${id}"
																		<s:property value="%{id in privilegeIds ? 'checked' : ''}"/> />
																		<label for="cb_${id}"><span class="folder">${name}</span></label>
																	</li>
																</s:iterator>
															</ul></li>
													</s:iterator>
												</ul></li>
										</s:iterator>
									</ul>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</form:form>
		<s:form action="role_setPrivilege">

			<!-- 表单内容显示 -->
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<table cellpadding="0" cellspacing="0" class="mainForm">
						<!--表头-->
						<thead>
							<tr align="LEFT" valign="MIDDLE" id="TableTitle">
								<td width="300px" style="padding-left: 7px;">
									<!-- 如果把全选元素的id指定为selectAll，并且有函数selectAll()，就会有错。因为有一种用法：可以直接用id引用元素 -->
									<input type="CHECKBOX" id="cbSelectAll"
									onClick="$('[name=privilegeIds]').attr('checked',this.checked)" />
									<label for="cbSelectAll">全选</label>
								</td>
							</tr>
						</thead>

						<!--显示数据列表-->
						<tbody id="TableData">
							<tr class="TableDetail1">
								<!-- 显示权限树 -->
								<td>
									<%-- <s:checkboxlist name="privilegeIds" list="#privilegeList" listKey="id" listValue="name">
									</s:checkboxlist> --%> <%-- <s:iterator value="#privilegeList">
										<input type="checkbox" name="privilegeIds" value="${id}"
											id="cb_${id}"
											<s:property value="%{id in privilegeIds ? 'checked' : ''}"/>
										 />
										<label for="cb_${id }">${name}</label>
										<br>
									</s:iterator> --%>

									<ul id="tree">
										<s:iterator value="#application.topPrivilegeList">
											<li><input type="checkbox" name="privilegeIds"
												value="${id}" id="cb_${id}"
												<s:property value="%{id in privilegeIds ? 'checked' : ''}"/> />
												<label for="cb_${id}"><span class="folder">${name}</span></label>
												<ul>
													<s:iterator value="children">
														<li><input type="checkbox" name="privilegeIds"
															value="${id}" id="cb_${id}"
															<s:property value="%{id in privilegeIds ? 'checked' : ''}"/> />
															<label for="cb_${id}"><span class="folder">${name}</span></label>
															<ul>
																<s:iterator value="children">
																	<li><input type="checkbox" name="privilegeIds"
																		value="${id}" id="cb_${id}"
																		<s:property value="%{id in privilegeIds ? 'checked' : ''}"/> />
																		<label for="cb_${id}"><span class="folder">${name}</span></label>
																	</li>
																</s:iterator>
															</ul></li>
													</s:iterator>
												</ul></li>
										</s:iterator>
									</ul>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

			<script type="text/javascript">
				$("#tree").treeview();
			</script>
			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<input type="image"
					src="${pageContext.request.contextPath}/style/images/save.png" />
				<a href="javascript:history.go(-1);"><img
					src="${pageContext.request.contextPath}/style/images/goBack.png" /></a>
			</div>
		</s:form>
	</div>

	<div class="Description">
		说明：<br /> 1，选中一个权限时：<br /> &nbsp;&nbsp;&nbsp;&nbsp; a，应该选中 他的所有直系上级。<br />
		&nbsp;&nbsp;&nbsp;&nbsp; b，应该选中他的所有直系下级。<br /> 2，取消选择一个权限时：<br />
		&nbsp;&nbsp;&nbsp;&nbsp; a，应该取消选择 他的所有直系下级。<br />
		&nbsp;&nbsp;&nbsp;&nbsp; b，如果同级的权限都是未选择状态，就应该取消选中他的直接上级，并递归向上做这个操作。<br />

		3，全选/取消全选。<br /> 4，默认选中当前岗位已有的权限。<br />
	</div>
</body>
</html>