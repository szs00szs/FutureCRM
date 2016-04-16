<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/news/news_saveUI.action">添加新闻</a>
	<table border="1" cellspacing="0" style=" font-size: 12px;">
		<caption>新闻管理</caption>
		<thead>
			<tr class="active">
				<th>标题</th>
				<th>内容</th>
				<th>发布人</th>
				<th>发布日期</th>
				<th>新闻类型</th>
				<th>编辑</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${!empty newsList }">
					<c:forEach items="${newsList }" var="news"
						varStatus="status">
						<tr>
							<td>${news.title }</td>
							<td>${news.content }</td>
							<td>${news.issuer.name }</td>
							<td><fmt:formatDate value="${news.issur_date }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<%-- <td>${news.issur_date }</td> --%>
							<td>${news.newsType }</td>
							<td><a
								href="${pageContext.request.contextPath }/news/news_updateUI/${news.id }"
								style="margin-right: 10%;"><img
									src="${pageContext.request.contextPath }/images/bian.png">&nbsp;&nbsp;编辑</a>
								<a
								href="${pageContext.request.contextPath }/news/news_delete/${news.id }"><img
									src="${pageContext.request.contextPath }/images/shan.png">&nbsp;&nbsp;删除</a>
							</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
						目前本公司没有新闻
				</c:otherwise>
			</c:choose>
			
		</tbody>
	</table>
</body>
</html>