<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品信息修改</title>
<link href="${pageContext.request.contextPath }/css/bootstrap-combined.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath }/css/bootstrap-datetimepicker.min.css">
 <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.1.4.js"></script>
<script type="text/javascript">
    $(function(){
        $("#submit").click(function(){
            var name = $("#name").val();
            if (name==''){
                alert("请输入 '商品名称'");
                return false;
            }
            
            var commodityCategory = $("#commodityCategory").val();
            if (commodityCategory=='----请选择----'){
                alert("请选择 '商品类型'");
                return false;
            }
            
            var description = $("#description").val();
            if (description==''){
                alert("请输入 '商品描述信息'");
                return false;
            }
            
            var bid = $("#bid").val();
            if (bid==''){
                alert("请输入 '商品进价'");
                return false;
            }
            
            var price = $("#price").val();
            if (price==''){
                alert("请输入 '商品售价'");
                return false;
            }
            
            var purchaseQuantity = $("#purchaseQuantity").val();
            if (purchaseQuantity==''){
                alert("请输入 '商品进货数量'");
                return false;
            }
            
            var commodityQuantity = $("#commodityQuantity").val();
            if (commodityQuantity==''){
                alert("请输入 '商品库存数量'");
                return false;
            }
            
            
            
        })
    })
</script>
</head>
<body>
<h3 align="center" style="font-family:华义彩云;"> 商品信息修改</h3>
			<form:form action="${pageContext.request.contextPath }/commodity/editCommodity.action" method="POST" modelAttribute="commodity">
			<input type="hidden" name="id" value="${commodity.id }">
			   <table  width="100%" height="48" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#aaaaaa"  bordercolorlight="#FFFFFF">
				    <tr style="padding:5px;">
				      <td bgcolor="#eeeeee"> 商品编号：</td>
				      <td>
				      <input type="text" name="commodityNumber"  value=${ commodity.commodityNumber } readonly="readonly">
				      </td>
				       <td bgcolor="#eeeeee"> 商品名称：</td>
				      <td>
				       <input type="text" name="name" id="name" value=${ commodity.name }>
				      </td>
				     </tr>
				     
			       <tr style="padding:5px;">
				      <td bgcolor="#eeeeee">商品类型：</td>
				      <td>
				      <select name="commodityCategory.id" id="commodityCategory" style="border: solid #ccc 1px;" id="select">
						<c:forEach items="${categoryList}" var="category">
							<c:choose>
								<c:when test="${category.id==commodity.commodityCategory.id}">
									<option selected="selected" value="${category.id}">${category.name}</option>
								</c:when>
								<c:otherwise>
									<option  value="${category.id}">${category.name}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select> 
					
				      </td>
				       <td bgcolor="#eeeeee"> 描述信息：</td>
				      <td>
				       <input type="text" name="description" id="description" value=${ commodity.description} >
				      </td>
				     </tr>	
				     
		          <tr style="padding:5px;">
				      <td bgcolor="#eeeeee">商品进价：</td>
				      <td>
				      <input type="text" name="bid" id="bid" value=${ commodity.bid}>
				      </td>
				       <td bgcolor="#eeeeee"> 商品售价：</td>
				      <td>
				       <input type="text" name="price"  id="price" value=${ commodity.price} >
				      </td>
				     </tr>
				     
				    <tr style="padding:5px;">
				    
				       <td bgcolor="#eeeeee"> 进货量：</td>
				      <td>
				       <input type="text" name="purchaseQuantity" id="purchaseQuantity" value=${ commodity.purchaseQuantity} >
				      </td>
				        <td bgcolor="#eeeeee">库存数量：</td>
				      <td>
				      <input type="text" name="commodityQuantity"  id="commodityQuantity" value=${ commodity.commodityQuantity}>
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