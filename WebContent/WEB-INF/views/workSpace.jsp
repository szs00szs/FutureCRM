<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>future CRM</title>
</head>
<body>
	<h1>工作台页面</h1>
	<div>
		<h2>公司新闻版块</h2>
		<a href="news/news_list"">>>查看全部</a>
		<c:forEach  items="${newsList }" var="news">
		<ul>
			<li>
				<a href="${pageContext.request.contextPath }/news/news_detail/${news.title }" ><c:out value="${news.title }"></c:out></a>
			</li>
		</ul>
		</c:forEach>
		
	</div>
	<div>
		<h2>公告版块</h2>
		<a href="announcement/announcement_list">查看全部</a>
	</div>
	<div>
		<h2>客户相关版块</h2>
		<a href="${pageContext.request.contextPath }/customer/customer_list">查看客户列表</a>
	</div>
	<div>
		<h2>销售单审核版块</h2>
	</div>
	<div>
		<h2>收款单审核版块</h2>
	</div>
	<div>
		<h2>个人计划任务版块</h2>
	</div>
	<div>
		<h2>联系人版块</h2>
	</div>
	<div>
		<h2>联系记录版块</h2>
	</div>
</body>
</html>