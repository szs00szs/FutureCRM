<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		$('#datetimepicker1').datetimepicker({

		});
	});
</script>
</head>
<body>



<h1 align="center" style="font-family:华义彩云;"> 订单信息添加</h1>
			<form action="${pageContext.request.contextPath }/sales/addOrder.action" method="post" >
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

			<!-- <div class="container">

				<div class="well">
					<div id="datetimepicker1" class="input-append date">
						<input name="createTime" data-format="yyyy/MM/dd hh:mm:ss"
							type="text" /> <span class="add-on"> <i
							data-time-icon="icon-time" data-date-icon="icon-calendar"> </i>
						</span>
					</div>
				</div>
			</div> -->


		</table>
			      <p align="center">
			      <input type="submit" value="提交">
			      <input type="reset" value="重置">
			      </p>
			</form>

</body>
</html>
