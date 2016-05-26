<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-2.1.4.js"></script>
	<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script language="javascript">
$(function(){   
    //导航切换
    $(".imglist li").click(function(){
        $(".imglist li.selected").removeClass("selected")
        $(this).addClass("selected");
    })  
})  
</script>
<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>
</head>
<body>
		<%-- <a
		href="${pageContext.request.contextPath}/sysDepartment/department_save">增加部门</a>

	<br>
	<hr>
	<form action="${pageContext.request.contextPath}/sysDepartment/department_query" method="post">
		部门名称： <input type="text" name="name"/>
		<button id="search">搜索</button>
	</form>

	<br>
	<hr>
	<table border="1" style="font-size: 12px;">
		<caption>部门管理</caption>
		<thead>
			<tr class="active">
				<th>部门</th>
				<th>部门负责人</th>
				<th>部门职能</th>
				<th>备注</th>
				<th>编辑</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${!empty departmentList }">
					<c:forEach items="${departmentList }" var="department"
						varStatus="status">
						<tr>
							<td>${department.name }</td>
							<td>${department.principal }</td>
							<td>${department.incumbent }</td>
							<td>${department.remark }</td>
							<td><a
								href="${pageContext.request.contextPath }/sysDepartment/department_update/${department.id }/${currentPage }"
								style="margin-right: 10%;"><img
									src="${pageContext.request.contextPath }/images/bian.png">&nbsp;&nbsp;编辑</a>
								<a
								href="${pageContext.request.contextPath }/sysDepartment/department_delete/${department.id }"><img
									src="${pageContext.request.contextPath }/images/shan.png">&nbsp;&nbsp;删除</a>
							</td>
						</tr>
					</c:forEach>

				</c:when>
				<c:otherwise>
						目前本公司没有部门
				</c:otherwise>
			</c:choose>
		</tbody>

		<%@ include file="/WEB-INF/views/public/pageView.jspf" %>
		<!--分页信息-->
		<div id=PageSelectorBar>
			<div id=PageSelectorMemo>页次：${currentPage }/${pageParameter.totalPage }页
				&nbsp; 每页显示：${pageParameter.pageSize}条 &nbsp;
				总记录数：${pageParameter.totalCount}条</div>
			<div id=PageSelectorSelectorArea>

				<a href="javascript: gotoPage(1)" title="首页" style="cursor: hand;">
					<img
					src="${pageContext.request.contextPath}/images/pageSelector/firstPage.png" />
				</a>

				<c:forEach begin="${pageParameter.beginPageIndex}"
					end="${pageParameter.endPageIndex}" var="num">
					<c:if test="${num == currentPage}">
						<!-- 当前页 -->
						<span class="PageSelectorNum PageSelectorSelected"><font
							color="red">${num}</font></span>
					</c:if>
					<c:if test="${num != currentPage}">
						<!-- 非当前页 -->
						<span class="PageSelectorNum" style="cursor: hand;"
							onClick="gotoPage(${num});">${num}</span>
					</c:if>
				</c:forEach>

				<a href="javascript: gotoPage(${pageParameter.totalPage})"
					title="尾页" style="cursor: hand;"> <img
					src="${pageContext.request.contextPath}/images/pageSelector/lastPage.png" />
				</a> 转到： <select onchange="gotoPage(this.value)" id="_pn">
					<c:forEach begin="1" end="${pageParameter.totalPage}" var="num">
						<option value="${num}">${num}</option>
					</c:forEach>
				</select>
				<script type="text/javascript">
					$("#_pn").val("${pageParameter.currentPage}");
				</script>

			</div>
		</div>


<script type="text/javascript">
	function gotoPage( pageNum ){
		window.location.href = "${pageContext.request.contextPath}/sysDepartment/department_list/" + pageNum;
		/* $(document.forms[0]).append("<input type='hidden' name='currentPage' value='" + pageNum +"'>");
		
		document.forms[0].submit(); */
	}
</script>
	</table> --%>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">增加部门</a></li>
    </ul>
    </div>
    
    <div class="formbody">
        <div class="formtitle"><a href="${pageContext.request.contextPath}/sysDepartment/department_save"><span>增加部门</span></a>
        </div>
        <form class="forminfo" action="${pageContext.request.contextPath}/sysDepartment/department_query" method="post">
        <label>部门名称&nbsp;&nbsp;</label>
        <input type="text" name="name" class="dfinput"/>
        <input id="search" type="submit" class="dfinput" style="width:50px; margin-left:0.8%;" />
       </form>
    </div>
<div>
    
     <table class="imgtable">
        
        <thead>
        <tr>
        <th>部门</th>
        <th>部门负责人</th>
        <th>部门职能</th>
        <th>备注</th>
        <th>编辑</th>
        </tr>
        </thead>
 
        <tbody>   
        <c:choose>
				<c:when test="${!empty departmentList }">
					<c:forEach items="${departmentList }" var="department"
						varStatus="status">
						<tr>
							<td>${department.name }</td>
							<td>${department.principal }</td>
							<td>${department.incumbent }</td>
							<td>${department.remark }</td>
							<td>
							<shiro:hasPermission name="department:update">
								<a
								href="${pageContext.request.contextPath }/sysDepartment/department_update/${department.id }/${currentPage }"
								style="margin-right: 10%;"><img
									src="${pageContext.request.contextPath }/images/bian.png">&nbsp;&nbsp;编辑</a>
							</shiro:hasPermission>
							<shiro:hasPermission name="department:delete">
								<a
								href="${pageContext.request.contextPath }/sysDepartment/department_delete/${department.id }"><img
									src="${pageContext.request.contextPath }/images/shan.png">&nbsp;&nbsp;删除</a>
							</shiro:hasPermission>
							</td>
						</tr>
					</c:forEach>

				</c:when>
				<c:otherwise>
						目前本公司没有部门
				</c:otherwise>
			</c:choose>
        <tr>
        </tbody>
        </table>

</div>
    <div class="pagin">
        <div class="message">共<i class="blue">${pageParameter.totalCount}</i>条记录，页次：&nbsp;<i class="blue"> ${currentPage }/${pageParameter.totalPage }&nbsp;</i>页</div>
        <ul class="paginList">
       <!--  <a href="javascript:;"><span class="pagepre"></span></a> -->
        <li class="paginItem"><a href="javascript: gotoPage(1)" title="首页" style="cursor: hand;">
					<span class="pagepre"></span>
		</a></li>
				
        <c:forEach begin="${pageParameter.beginPageIndex}"
					end="${pageParameter.endPageIndex}" var="num">
					<c:if test="${num == currentPage}">
						<!-- 当前页 -->
						<li class="paginItem current"><a href="javascript:;"><font
							color="red">${num}</font></a></li>
					</c:if>
					<c:if test="${num != currentPage}">
						<!-- 非当前页 -->
						<li class="paginItem"><a href="javascript:;"><span class="PageSelectorNum" style="cursor: hand;"
							onClick="gotoPage(${num});">${num}</span></a></li>
					</c:if>
		</c:forEach>
		<li class="paginItem"><a href="javascript: gotoPage(${pageParameter.totalPage})"
					title="尾页" style="cursor: hand;"><span class="pagenxt"></span>
		</a></li>
        </ul>
    </div>
    
<script type="text/javascript">
    $('.imgtable tbody tr:odd').addClass('odd');
    </script>
<script type="text/javascript">
	function gotoPage( pageNum ){
		window.location.href = "${pageContext.request.contextPath}/sysDepartment/department_list/" + pageNum;
	}
</script>
</body>
</html>