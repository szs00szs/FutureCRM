<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath }/css/bootstrap-combined.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath }/css/bootstrap-datetimepicker.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.1.4.js"></script>
<script type="text/javascript">
    $(function(){
        $("#submit").click(function(){
            var name = $("#name").val();
            if (name==''){
                alert("请输入 '类别名称'");
                return false;
            }
            
            var description = $("#description").val();
            if (description==''){
                alert("请输入 '描述信息'");
                return false;
            }
        })
    })
</script>
<title>商品类别添加</title>
</head>
<body>
<h3 align="center" style="font-family:华义彩云;"> 商品类别添加</h3>
			<form:form action="${pageContext.request.contextPath }/category/addCategory.action" method="POST" modelAttribute="commodityCategory">
			   <table  width="100%" height="48" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#aaaaaa"  bordercolorlight="#FFFFFF">
				    <tr style="padding:5px;">
				      <td bgcolor="#eeeeee"> 类别名称：</td>
				      <td>
				      <input type="text" name="name" id="name">
				      </td>
				      </tr>
			      <tr style="padding:5px;">
				       <td bgcolor="#eeeeee"> 描述信息：</td>
				      <td>
				      <input type="text" name="description" id="description">
				       </td>
				     </tr>			
			
		</table>
			      <p align="center">
			      <input type="submit" id="submit" value="提交">
			      <input type="reset" value="重置">
			      </p>
		</form:form>
</body>
</html>