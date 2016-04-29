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
<title>订单详情</title>
</head>
<body>
	<h3 align="center" style="font-family:华义彩云;"> 订单详细信息</h3>
	
	<h4>基本订单信息：</h4>
	      <table width="100%" height="48" border="1" cellpadding="0" cellspacing="0">
			 <tr style="padding:5px;">
				      <td bgcolor="#eeeeee"> 订单编号：</td>
				      <td>
				    	  <input type="text"   value="${salesOrder.saleNumber}" readonly="readonly"/>
				      </td>
				      
				      <td bgcolor="#eeeeee"> 业务员：</td>
				      <td>
				      	<input type="text"   value="${salesOrder.salesman.name}" readonly="readonly"/>
				      </td>
				</tr>
				
				 <tr style="padding:5px;">
					  
					      
					      <td bgcolor="#eeeeee">创建时间:</td>
				<td>
						<input   type="text" value="<fmt:formatDate value="${salesOrder.createTime}" pattern="yyyy-MM-dd hh:mm:ss"/>" readonly="readonly"/>
				</td>
				   	 <td bgcolor="#eeeeee">备注：</td>
				<td>
					<input type="text"  value="${salesOrder.remark}" readonly="readonly">
				</td>
			</tr>
			</table>
			
			<br>
			<h4>商品信息：</h4>
			 <table width="100%" height="48" border="1" cellpadding="0" cellspacing="0">
			 	<tr style="padding:5px;">
				 <td bgcolor="#eeeeee"> 商品名称：</td>
				     <td>
					      <input type="text"  value="${salesOrder.commodity.name}" readonly="readonly">
					 </td>
				 <td bgcolor="#eeeeee"> 商品类别：</td>
				     <td>
					      <input type="text"  value="${salesOrder.commodity.commodityCategory.name}" readonly="readonly">
					 </td>
				</tr>
				<tr style="padding:5px;">
				 <td bgcolor="#eeeeee"> 商品售价：</td>
				     <td>
					      <input type="text"  value="${salesOrder.commodity.price}" readonly="readonly">
					 </td>
		
					 <td bgcolor="#eeeeee"> 商品数量：</td>
				     <td>
					      <input type="text"  value="${salesOrder.commodityCount}" readonly="readonly">
					 </td>
				</tr>
				<tr style="padding:5px;">
						 <td bgcolor="#eeeeee"> 商品总价：</td>
				   	  <td>
					      <input type="text"  value="${salesOrder.commodity.price*salesOrder.commodityCount}" readonly="readonly">
					 </td>
				 
				 <td bgcolor="#eeeeee"> 商品描述：</td>
				     <td>
					      <input type="text"  value="${salesOrder.commodity.description}" readonly="readonly">
					 </td>
				</tr>
			 </table>
			
			<br>
			<h4>业务员：</h4>
			 <table width="100%" height="48" border="1" cellpadding="0" cellspacing="0">
				<tr style="padding:5px;">
				    <td bgcolor="#eeeeee"> 姓名：</td>
				     <td>
					      <input type="text"  value="${salesOrder.salesman.name}" readonly="readonly">
					 </td>
					 
					 <td bgcolor="#eeeeee"> 性别：</td>
				     <td>
					      <input type="text"  value="${salesOrder.salesman.sex}" readonly="readonly">
					 </td>
				</tr>
					<tr style="padding:5px;">
				    <td bgcolor="#eeeeee"> 出生日期：</td>
				     <td>
					      <input type="text"  value="<fmt:formatDate value="${salesOrder.salesman.birthday}" pattern="yyyy-MM-dd"/>"  readonly="readonly">
					 </td>
					 
					 <td bgcolor="#eeeeee"> 电话：</td>
				     <td>
					      <input type="text"  value="${salesOrder.salesman.moveTelephone}" readonly="readonly">
					 </td>
				</tr>
			</table>
			
			
			<br>
			<h4>客户：</h4>
			
			  <table width="100%" height="48" border="1" cellpadding="0" cellspacing="0">

					 <tr style="padding:5px;">
					          <td bgcolor="#eeeeee"> 客户编号：</td>
				    	  <td>
				     		 <input type="text"   value="${salesOrder.customer.code}" readonly="readonly"> 
					      </td>
					      <td bgcolor="#eeeeee"> 客户姓名：</td>
					      <td>
					    	  <input type="text"  value="${salesOrder.customer.name}" readonly="readonly">
					      </td>
					  </tr>
					  
					  	 <tr style="padding:5px;">
					          <td bgcolor="#eeeeee"> 客户等级：</td>
				    	  <td>
				     		 <input type="text"   value="${salesOrder.customer.grade}" readonly="readonly"> 
					      </td>
					      <td bgcolor="#eeeeee"> 客户地区：</td>
					      <td>
					    	  <input type="text"  value="${salesOrder.customer.regionName}" readonly="readonly">
					      </td>
					  </tr>
					  
				  	  	 <tr style="padding:5px;">
				          <td bgcolor="#eeeeee"> 客户开源：</td>
				    	  <td>
				     		 <input type="text"  value="${salesOrder.customer.source}" readonly="readonly"> 
					      </td>
					      <td bgcolor="#eeeeee"> 所属行业：</td>
					      <td>
					    	  <input type="text"  value="${salesOrder.customer.trade}" readonly="readonly">
					      </td>
					  </tr>
					  
					   <tr style="padding:5px;">
				          <td bgcolor="#eeeeee"> 公司规模：</td>
				    	  <td>
				     		 <input type="text"   value="${salesOrder.customer.scale}" readonly="readonly"> 
					      </td>
					      <td bgcolor="#eeeeee"> 省份：</td>
					      <td>
					    	  <input type="text"   value="${salesOrder.customer.province}" readonly="readonly">
					      </td>
					  </tr>
					  
					     <tr style="padding:5px;">
				          <td bgcolor="#eeeeee"> 联系地址：</td>
				    	  <td>
				     		 <input type="text"   value="${salesOrder.customer.address}" readonly="readonly"> 
					      </td>
					      <td bgcolor="#eeeeee"> email：</td>
					      <td>
					    	  <input type="text"  value="${salesOrder.customer.email}" readonly="readonly">
					      </td>
					  </tr>
					  
					     <tr style="padding:5px;">
				          <td bgcolor="#eeeeee"> 公司网址：</td>
				    	  <td>
				     		 <input type="text"  value="${salesOrder.customer.web}" readonly="readonly"> 
					      </td>
					      <td bgcolor="#eeeeee">电话：</td>
					      <td>
					    	  <input type="text"   value="${salesOrder.customer.tel1}" readonly="readonly">
					      </td>
					  </tr> 
					  
					    <tr style="padding:5px;">
				          <td bgcolor="#eeeeee"> 客户性质：</td>
				    	  <td>
				     		 <input type="text"  value="${salesOrder.customer.quality}" readonly="readonly"> 
					      </td>
					      <td bgcolor="#eeeeee">经营范围：</td>
					      <td>
					    	  <input type="text"  value="${salesOrder.customer.dealin}" readonly="readonly">
					      </td>
					  </tr>
				</table>   
		
		<br>
			<h4>联系人信息：</h4>
			  <table width="100%" height="48" border="1" cellpadding="0" cellspacing="0">
					<tr style="padding:5px;">
					     <td bgcolor="#eeeeee"> 联系人姓名：</td>
					      <td>
					   		   <input type="text"   value="${salesOrder.contacts.name}" readonly="readonly">
					      </td>
					      <td bgcolor="#eeeeee"> 性别：</td>
					      <td>
					    	  <input type="text"   value="${salesOrder.contacts.sex}" readonly="readonly">
					      </td>
					  </tr> 
					  
					  <tr style="padding:5px;">
					     <td bgcolor="#eeeeee"> 生日：</td>
					      <td>
					   		   <input type="text"   value="<fmt:formatDate value="${salesOrder.contacts.birthday}" pattern="yyyy-MM-dd"/> " readonly="readonly">
					      </td>
					      <td bgcolor="#eeeeee"> 部门职务：</td>
					      <td>
					      <input type="text"  value="${salesOrder.contacts.departmentDuties}" readonly="readonly">
					      </td>
					  </tr>
					  
					    <tr style="padding:5px;">
					     <td bgcolor="#eeeeee"> 电话：</td>
					      <td>
					   		   <input type="text"  value="${salesOrder.contacts.homePhone}" readonly="readonly">
					      </td>
					      <td bgcolor="#eeeeee"> 手机：</td>
					      <td>
					      <input type="text"  value="${salesOrder.contacts.mobilePhone}" readonly="readonly">
					      </td>
					  </tr>
					  
					      <tr style="padding:5px;">
					     <td bgcolor="#eeeeee"> QQ：</td>
					      <td>
					   		   <input type="text"   value="${salesOrder.contacts.QQNumber}" readonly="readonly">
					      </td>
					      <td bgcolor="#eeeeee"> email：</td>
					      <td>
					      <input type="text"  value="${salesOrder.contacts.email}" readonly="readonly">
					      </td>
					  </tr>
					  
				        <tr style="padding:5px;">
					     <td bgcolor="#eeeeee"> 爱好：</td>
					      <td>
					   		   <input type="text"   value="${salesOrder.contacts.hobby}" readonly="readonly">
					      </td>
					      <td bgcolor="#eeeeee"> 忌讳：</td>
					      <td>
					      <input type="text"  value="${salesOrder.contacts.taboo}" readonly="readonly">
					      </td>
					  </tr>
					       
					</table>  
					     
				 <table width="100%" height="48" border="1" cellpadding="0" cellspacing="0">     
					  
		    </tr>
		    </table>

	
</body>
</html>