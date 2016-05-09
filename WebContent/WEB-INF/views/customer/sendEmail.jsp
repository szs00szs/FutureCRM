<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-2.1.4.js"></script>
<script type="text/javascript">
$(function() {
	$("#send").click(function(){
		var url = "${pageContext.request.contextPath}/customer/sendEmail";
		$("form").attr("action", url);
		//触发submit事件，提交表单 
		$("form").submit();
	});
})
</script>
</head>
<body>
<form action="#">
<%--
		用于绑定用户，既是邮件发送方
	 <input type="hidden" name="customer_email" value="${customer.email }"/>
 --%>
	<table>
		<caption>发送邮件</caption>
		<tbody>
			
			<tr>
				<td>发送人：</td>
				<td><input type="text" name="from" /></td>
			</tr>
			<tr>
				<td>授权密码：</td>
				<td><input type="text" name="password" /></td>
				<td><span>注：授权密码不是登陆密码</span></td>
			</tr>
			
			<tr>
			
				<td>接收人：</td>
				<td><input type="text" name="customer_email" value="${customer.email }"/></td>
			</tr>
			<tr>
				<td>标题</td>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<td>内容：</td>
				<td>
					<textarea name="content" rows="10" cols="20"></textarea>
				</td>
			</tr>
			<tr>
				<td>附件：</td>
				<td><input type="file" name="attached" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input id="send" type="submit" value="发送"/></td>
			</tr>
		</tbody>
	</table>
</form>
</body>
</html>