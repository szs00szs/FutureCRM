<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/WEB-INF/";
%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>CRM客户关系管理系统首页</title>
	<frameset rows="9%,*" noresize framespacing="0" border="0">
		<frame src="heading"noresize scrolling="no">
		<frameset cols="13%,*">
                    <frame src="content_menu" name = "content_menu" noresize scrolling="no" >
            <frameset rows="*,4%">
                    <frame name="right" id ="main" src=""  frameborder="no" scrolling="auto"  marginwidth="0" marginheight="0" />
                    <frame src="footing"  marginwidth="100%"  scrolling="no" >
            </frameset>
	    </frameset>
    </frameset>
    <noframes></noframes>
   
</body>
 
</head>
<body>
</body>
</html>