<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>heading</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<!-- basic styles -->

		<link href="${pageContext.request.contextPath}/css/top.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/top_er.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.4.js"></script>
        
 </head>
<body>  
<nav class="navbar navbar-fixed-top" role="navigation" style="background:url(images/bg.png) repeat-y;">
    <div class="navbar navbar-inverse">
    <div class="navbar-header">
      <!-- 自适应隐藏导航展开按钮 -->
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <!-- 导航条LOGO -->
      <div class="navbar-header">
         <a class="navbar-brand" href="#">CRM客户管理系统</a>
      </div>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav" id="daohang">
                <li><a href="#"><img src="images/work.png" title="工作台" /><h5>工作台</h5></a></li>
                <li><a href="#"><img src="images/return.png" title="客户回访" /><h5>客户回访</h5></a></li>
                <li><a href="#"><img src="images/speciality.png" title="客户特质" /><h5>客户特质</h5></a></li>
                <li><a href="#"><img src="images/send.png" title="产品推送"/><h5>产品推送</h5></a></li>
            </ul>
            
        <ul class="nav navbar-nav pull-right">
                <li><a href="#"><font size="-1">帮助</font></a></li>
                <li><a href="#"><font size="-1">关于</font></a></li>
                <li><a href="${pageContext.request.contextPath}/sysLogout"><font size="-1">退出</font></a></li>
            </ul>
    </div>
</div>
</nav>
<script src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</body>
</html>

