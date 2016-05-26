<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fns" uri="/WEB-INF/views/tags/fns.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>content_menu</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){   
    //导航切换
    $(".menuson li").click(function(){
        $(".menuson li.active").removeClass("active")
        $(this).addClass("active");
    });
    
    $('.title').click(function(){
        var $ul = $(this).next('ul');
        $('dd').find('ul').slideUp();
        if($ul.is(':visible')){
            $(this).next('ul').slideUp();
        }else{
            $(this).next('ul').slideDown();
        }
    });
})  
</script>
<!-- <base target="main"> -->
</head>
<body style="background:#f3f3f3;">

	<dl class="leftmenu">
    <dd>
    <c:forEach items="${parentMenu}" var="menu">
		<c:if test="${menu.parent_id eq '' || menu.parent_id ==null }">
			<dd>
			    <div class="title">
			   		<span><img src="images/leftico01.png"/></span>${menu.name }
			    </div>
		        <ul class="menuson">
		        <c:forEach items="${sonMenu}" var="son">
			          <c:if test="${son.parent_id eq menu.id }">
			          	<li><cite></cite><a href="${son.url}" target="right">${son.name }</a><i></i></li>
			          </c:if>
			        </c:forEach>
		        </ul>    
		    </dd>
	    </c:if>
	  </c:forEach>
    <dd>
    </dl>

</body>
</html>
