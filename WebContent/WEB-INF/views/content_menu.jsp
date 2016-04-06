<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fns" uri="/WEB-INF/views/tags/fns.tld" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>content_menu</title>
<head>
</head>
<body id="bg">
<div class="container">

<c:forEach items="${fns:getPrivilegeList()}" var="menu"></c:forEach>

	<div class="leftsidebar_box">
		<div class="line"></div>
		<c:forEach items="${fns:getPrivilegeList()}" var="menu">
		<c:if test="${menu.parent_id eq '1' }">
		       <dl class="system_log">
			      <dt onClick="changeImage()">${menu.name }<img src="images/select_xl01.png"></dt>
			        <c:forEach items="${fns:getPrivilegeList()}" var="son">
			          <c:if test="${son.parent_id eq menu.id }">
			            <dd class="first_dd" onclick="javascript:parent.document.getElementById('main').src='${son.href}' "><a href="#">${son.name }</a></dd>
			          </c:if>
			        </c:forEach>
		       </dl>
	    </c:if>
	  </c:forEach>
	</div>
</div>
</body>
</html>
