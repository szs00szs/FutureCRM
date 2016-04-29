<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link href="${pageContext.request.contextPath }/css/bootstrap-combined.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath }/css/bootstrap-datetimepicker.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>进货单详情</title>
</head>
<body>
	<h3 align="center" style="font-family:华义彩云;"> 进货单详细信息</h3>
	
	<h4>基本进货单信息：</h4>
	      <table width="100%" height="48" border="1" cellpadding="0" cellspacing="0">
			 <tr style="padding:5px;">
				      <td bgcolor="#eeeeee"> 进货单编号：</td>
				      <td>
				    	  <input type="text"   value="${purchaseOrder.purchaseNo}" readonly="readonly"/>
				      </td>
				      
				      <td bgcolor="#eeeeee"> 业务员：</td>
				      <td>
				      	<input type="text"   value="${purchaseOrder.user.name}" readonly="readonly"/>
				      </td>
				</tr>
				
				 <tr style="padding:5px;">
					  
					      
					      <td bgcolor="#eeeeee">创建时间:</td>
				<td>
						<input   type="text" value="<fmt:formatDate value="${purchaseOrder.createTime}" pattern="yyyy-MM-dd hh:mm:ss"/>" readonly="readonly"/>
				</td>
				   	 <td bgcolor="#eeeeee">备注：</td>
				<td>
					<input type="text"  value="${purchaseOrder.remark}" readonly="readonly">
				</td>
			</tr>
			</table>
			
			<br>
			<h4>商品信息：</h4>
			 <table width="100%" height="48" border="1" cellpadding="0" cellspacing="0">
			 	<tr style="padding:5px;">
				 <td bgcolor="#eeeeee"> 商品名称：</td>
				     <td>
					      <input type="text"  value="${purchaseOrder.commodity.name}" readonly="readonly">
					 </td>
				 <td bgcolor="#eeeeee"> 商品类别：</td>
				     <td>
					      <input type="text"  value="${purchaseOrder.commodity.commodityCategory.name}" readonly="readonly">
					 </td>
				</tr>
				<tr style="padding:5px;">
				 <td bgcolor="#eeeeee"> 商品进价：</td>
				     <td>
					      <input type="text"  value="${purchaseOrder.commodity.bid}" readonly="readonly">
					 </td>
		
					 <td bgcolor="#eeeeee"> 商品数量：</td>
				     <td>
					      <input type="text"  value="${purchaseOrder.commodityCount}" readonly="readonly">
					 </td>
				</tr>
				<tr style="padding:5px;">
						 <td bgcolor="#eeeeee"> 商品总价：</td>
				   	  <td>
					      <input type="text"  value="${purchaseOrder.commodity.bid*purchaseOrder.commodityCount}" readonly="readonly">
					 </td>
				 
				 <td bgcolor="#eeeeee"> 商品描述：</td>
				     <td>
					      <input type="text"  value="${purchaseOrder.commodity.description}" readonly="readonly">
					 </td>
				</tr>
			 </table>
			
			<br>
			<h4>业务员：</h4>
			 <table width="100%" height="48" border="1" cellpadding="0" cellspacing="0">
				<tr style="padding:5px;">
				    <td bgcolor="#eeeeee"> 姓名：</td>
				     <td>
					      <input type="text"  value="${purchaseOrder.user.name}" readonly="readonly">
					 </td>
					 
					 <td bgcolor="#eeeeee"> 性别：</td>
				     <td>
					      <input type="text"  value="${purchaseOrder.user.sex}" readonly="readonly">
					 </td>
				</tr>
					<tr style="padding:5px;">
				    <td bgcolor="#eeeeee"> 出生日期：</td>
				     <td>
					      <input type="text"  value="<fmt:formatDate value="${purchaseOrder.user.birthday}" pattern="yyyy-MM-dd"/>"  readonly="readonly">
					 </td>
					 
					 <td bgcolor="#eeeeee"> 电话：</td>
				     <td>
					      <input type="text"  value="${purchaseOrder.user.moveTelephone}" readonly="readonly">
					 </td>
				</tr>
			</table>
			
			
			<br>
			<h4>供应商：</h4>
			
			  <table width="100%" height="48" border="1" cellpadding="0" cellspacing="0">

					 <tr style="padding:5px;">
					          <td bgcolor="#eeeeee"> 供应商名称：</td>
				    	  <td>
				     		 <input type="text"   value="${purchaseOrder.supplier.name}" readonly="readonly"> 
					      </td>
					      <td bgcolor="#eeeeee"> 联系电话：</td>
					      <td>
					    	  <input type="text"  value="${purchaseOrder.supplier.phone}" readonly="readonly">
					      </td>
					  </tr>
					  
				</table>  
				<br> 
		
</body>
</html>