<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<title>登录</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/cloud.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-2.1.4.js" language="JavaScript" type="text/javascript"></script>
<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script>
<meta charset="UTF-8">
<style>
.error {
	color: red;
}
</style>
<script src="${pageContext.request.contextPath}/js/jquery-2.1.4.js"></script>
</head>
<body style="background-color:#1c77ac; background-image:url(${pageContext.request.contextPath}/images/login/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
		<%-- <h1 class="lean">登录</h1>
		<div class="error">${error}</div>
		<form action="#" method="post">
			用户名：<input type="text" name="username" value="<shiro:principal/>" /><br />
			密码：<input type="password" name="password" /><br /> 自动登录：<input
				type="checkbox" name="rememberMe" value="true" /><br /> <input
				type="submit" value="登录">
		</form> --%>
		
		<div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎登录后台管理界面平台</span>    
    <ul>
    <li><a href="#">回首页</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span>
       
    <div class="loginbox">
	    <form action="#" method="post">
	    	<%-- <div id="tishi" class="error">${error}</div> --%>
	    	<div id="tishi"><!-- <input type="text" style="border:1px solid red;"/> -->${error}</div>
	    	<ul>
			    <li>
			    	<!-- <input name="" type="text" class="loginuser" value="admin" onclick="JavaScript:this.value=''"/> -->
			    	<input type="text" class="loginuser" name="username" id="user" placeholder="用户名" required/>
			    </li>
			    <li>
			    	<!-- <input name="" type="text" class="loginpwd" value="密码" onclick="JavaScript:this.value=''"/> -->
			    	<input type="password" name="password" class="loginpwd" placeholder="密码" required/>
			    </li>
			    <li><input type="submit" class="loginbtn" value="登录"/><label><input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="#">忘记密码？</a></label></li>
		    </ul>
	    </form>
    </div>
    </div>
    <div class="loginbm">版权所有  2016  <a href="http://www.uimaker.com">uimaker.com</a>  CRM系统</div>
</body>
</html>