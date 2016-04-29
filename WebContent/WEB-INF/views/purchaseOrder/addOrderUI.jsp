<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link href="${pageContext.request.contextPath }/css/bootstrap-combined.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath }/css/bootstrap-datetimepicker.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.1.4.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap-datetimepicker.min.js"></script> 
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加订单页面</title>
<script type="text/javascript">
	$(function() {
		$('#datetimepicker1').datetimepicker({});

	});
</script>
<script type="text/javascript">
	jQuery(document).ready(function() {
		var sFeatures = "height=600, width=810, scrollbars=yes, resizable=yes";
		jQuery('a[rel="external"]').click(function() {
			window.open(jQuery(this).attr('href'), '3km', sFeatures);
			return false;
		});
	});

	jQuery(document).ready(function() {
		jQuery("a[rel=external]").attr('target', '_blank');
	});
</script>

<script type="text/javascript">
    $(function(){
        $("#submit").click(function(){
            var user = $("#user").val();
            if (user=='----请选择----'){
                alert("请选择 '业务员'");
                return false;
            }
            
            var commodity = $("#commodity").val();
            if (commodity=='----请选择----'){
                alert("请选择 '商品名称'");
                return false;
            }
            
            var commodityCount = $("#commodityCount").val();
            if (commodityCount==''){
                alert("请选择 '商品数量'");
                return false;
            }
            
            var supplier = $("#supplier").val();
            if (supplier=='----请选择----'){
                alert("请选择 '供应商'");
                return false;
            }
            
        })
    })
</script>
</head>
<body>

<h3 align="center" style="font-family:华义彩云;"> 进货单信息添加</h3>
			<form:form action="${pageContext.request.contextPath }/purchase/addOrder.action" method="POST" modelAttribute="purchaseOrder">
			
				<h4>基本信息：</h4>
			      <table width="100%" height="48" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#aaaaaa"  bordercolorlight="#FFFFFF">
				    <tr style="padding:5px;">
				      <td bgcolor="#eeeeee"> 进货单编号：</td>
				      <td>
				      <input type="text" name="purchaseNo"  value=${purchaseNo } readonly="readonly">
				      </td>
				       <td bgcolor="#eeeeee"> 业务员：</td>
				      <td>
				      	<select name="user.id" id="user" style="border: solid #ccc 1px;">
				      			<option selected="selected">----请选择----</option>
								<c:forEach items="${userList}" var="user">
									<option value="${user.id}">${user.name}</option>
								</c:forEach>
						</select> 
				      </td>
				    </tr>
				    
				     <tr style="padding:5px;">
				      <td bgcolor="#eeeeee"> 创建日期：</td>
				      <td>
				      	<div id="datetimepicker1" class="input-append date">
							<input name="createTime" id="datetimepicker1" data-format="yyyy-MM-dd hh:mm:ss" type="text" value=""/>
							<span class="add-on"> 
								<i data-time-icon="icon-time" data-date-icon="icon-calendar"> </i>
							</span>
						</div>
				      </td>
				       <td bgcolor="#eeeeee"> 备注：</td>
				      <td>
				      	<input type="text" id="remark" name="remark" value="无">
				      </td>
				    </tr>
		</table>
		<br>
		
		<h4>商品信息：</h4>
		 <table width="100%" height="48" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#aaaaaa"  bordercolorlight="#FFFFFF">
			  <tr style="padding:5px;">
					  <td bgcolor="#eeeeee"> 商品名称：</td>
					  <td>
				     <select name="commodity.id" id="commodity" style="border: solid #ccc 1px;" >
							<option selected="selected">----请选择----</option>
							<c:forEach items="${commodityList }" var="commodity">
								<option value="${commodity.id }">${commodity.name }</option>
							</c:forEach>
						</select>
						<a href="${pageContext.request.contextPath }/commodity/addCommodityUI.action" rel="external">新建</a>
						</td>
				      	  <td bgcolor="#eeeeee"> 数量：</td>
				      <td>
				      	<input type="text" id="commodityCount" name="commodityCount" >
				      </td>
			   </tr>
		</table>
		
		<h4>供应商信息：</h4>
		 <table width="100%" height="48" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#aaaaaa"  bordercolorlight="#FFFFFF">
			  <tr style="padding:5px;">
					  <td bgcolor="#eeeeee"> 供应商名称：</td>
					  <td>
				     <select name="supplier.id" id="supplier" style="border: solid #ccc 1px;" >
							<option selected="selected">----请选择----</option>
							<c:forEach items="${supplierList }" var="supplier">
								<option value="${supplier.id }">${supplier.name }</option>
							</c:forEach>
						</select>
						<a href="${pageContext.request.contextPath }/supplier/addSupplierUI.action" rel="external">新建</a>
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
