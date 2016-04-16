<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改订单信息</title>
</head>
<body>
	<h1>订单修改</h1>
	${salesOrder.id }
		<form action="${pageContext.request.contextPath }/sales/editOrder.action" method="post" >
			      <table width="100%" height="48" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#aaaaaa"  bordercolorlight="#FFFFFF">
				    <tr style="padding:5px;">
				      <td bgcolor="#eeeeee"> 订单编号：</td>
				      <td>
				      <input type="text" name="saleNumber"  value=""><font color="red">${requestScope.error }</font> 
				      </td>
				       <td bgcolor="#eeeeee"> 客户姓名：</td>
				      <td>
				      <input type="text" name="customer"  value=""><font color="red">${requestScope.error }</font> 
				      </td>
				     </tr>


					<tr style="padding:5px;">
					      <td bgcolor="#eeeeee"> 联系人电话：</td>
					      <td>
					      <input type="text" name="contactPhone"  value="">
					      </td>
					      <td bgcolor="#eeeeee"> 客户地址：</td>
					      <td>
					      <input type="text" name="deliveryAddress"  value="">
					      </td>
					  </tr>     
					     
					    <tr style="padding:5px;">
					      <td bgcolor="#eeeeee"> 备注：</td>
					      <td>
					      <input type="text" name="remark"  value="" >
					      </td>
					      <td bgcolor="#eeeeee"> 购买商品清单：</td>
					      <td>
					      <input type="text" name="goods"  value="">
					      </td>
					    </tr>

			<tr style="padding:5px;">
				<td bgcolor="#eeeeee">创建时间:</td>
				<td>
				<div id="datetimepicker1" class="input-append date">
					<input name="createTime" id="datetimepicker1" data-format="yyyy/MM/dd hh:mm:ss" type="text" />
					<span class="add-on"> 
						<i data-time-icon="icon-time" data-date-icon="icon-calendar"> </i>
					</span>
				</div>
				</td>
			</tr>
		</table>
			      <p align="center">
			      <input type="submit" value="提交">
			      <input type="reset" value="重置">
			      </p>
			</form>
</body>
</html>