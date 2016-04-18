<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
 	<table>
 	<caption>客户详细信息</caption>
 	
 		<tr>
 			<td>客户ID</td>
 			<td><input name="id" value="${customer.id }"></td>
 		</tr>
 		<tr>
 			<td>客户编码</td>
 			<td><input name="code" value="${customer.code }"></td>
 		</tr>
 		<tr>
 			<td>姓名</td>
 			<td><input name="name" value="${customer.name }"></td>
 		</tr>
 		<tr>
 			<td>客户等级</td>
 			<td><input name="grade" value="${customer.grade }"></td>
 		</tr>
 		<tr>
 			<td>联系人</td>
 			<td><input name="contacts.name" value="${customer.contacts.getName() }" /></td>
 		</tr>
 		<tr>
 			<td>区域名称</td>
 			<td><input name="regionName" value="${customer.regionName }"></td>
 		</tr>
 		<tr>
 			<td>客户来源</td>
 			<td><input name="source" value="${customer.source }"></td>
 		</tr>
 		<tr>
 			<td>所属行业</td>
 			<td><input name="trade" value="${customer.trade }"></td>
 		</tr>
 		<tr>
 			<td>公司规模</td>
 			<td><input name="scale" value="${customer.scale }"></td>
 		</tr>
 		<tr>
 			<td>省份</td>
 			<td><input name="province" value="${customer.province }"></td>
 		</tr>
 		<tr>
 			<td>城市</td>
 			<td><input name="city" value="${customer.city }"></td>
 		</tr>
 		<tr>
 			<td>邮编</td>
 			<td><input name="postCode" value="${customer.postCode }"></td>
 		</tr>
 		<tr>
 			<td>联系地址</td>
 			<td><input name="address" value="${customer.address }"></td>
 		</tr>
 		<tr>
 			<td>邮箱</td>
 			<td><input name="email" value="${customer.email }"></td>
 		</tr>
 		<tr>
 			<td>公司网站</td>
 			<td><input name="web" value="${customer.web }"></td>
 		</tr>
 		<tr>
 			<td>电话一</td>
 			<td><input name="tel1" value="${customer.tel1 }"></td>
 		</tr>
 		<tr>
 			<td>手机</td>
 			<td><input name="mobile" value="${customer.mobile }"></td>
 		</tr>
 		<tr>
 			<td>电话二</td>
 			<td><input name="tel2" value="${customer.tel2 }"></td>
 		</tr>
 		<tr>
 			<td>下次联系时间</td>
 			<td>
				<fmt:formatDate value="${customer.nextTouchDate }" pattern="yyyy-MM-dd HH:mm:ss" var="nextTouchDate"/> 			
 				<input name="nextTouchDate" value="${nextTouchDate }">
 			</td>
 		</tr>
 		<tr>
 			<td>客户性质</td>
 			<td><input name="quality" value="${customer.quality }"></td>
 		</tr>
 		<tr>
 			<td>标注</td>
 			<td><input name="remark" value="${customer.remark }"></td>
 		</tr>
 		<tr>
 			<td>经营范围</td>
 			<td><input name="dealin" value="${customer.dealin }"></td>
 		</tr>
 		<tr>
 			<td>企业性质</td>
 			<td><input name="kind" value="${customer.kind }"></td>
 		</tr>
 		<tr>
 			<td>法人代表</td>
 			<td><input name="artificialPerson" value="${customer.artificialPerson }"></td>
 		</tr>
 		<tr>
 			<td>注册资金</td>
 			<td><input name="registeMoney" value="${customer.registeMoney }"></td>
 		</tr>
 		<tr>
 			<td>开户银行</td>
 			<td><input name="bank" value="${customer.bank }"></td>
 		</tr>
 		<tr>
 			<td>银行账号</td>
 			<td><input name="account" value="${customer.account }"></td>
 		</tr>
 		<tr>
 			<td>公司税号</td>
 			<td><input name="taxCode" value="${customer.taxCode }"></td>
 		</tr>
 		<tr>
 			<td>创建人</td>
 			<td><input name="creator" value="${customer.creator }"></td>
 		</tr>
 		<tr>
 			<td>创建时间</td>
 			<td>
 				<fmt:formatDate value="${customer.createTime }" pattern="yyyy-MM-dd HH:mm:ss" var="createTime"/>
 				<input name="createTime" value="${createTime }">
 			</td>
 		</tr>
 		<tr>
 			<td>修改人</td>
 			<td><input name="updater" value="${customer.updater }"></td>
 		</tr>
 		<tr>
 			<td>修改时间</td>
 			<td>
 				<fmt:formatDate value="${customer.updateTime }" pattern="yyyy-MM-dd HH:mm:ss" var="updateTime"/>
 				<input name="updateTime" value="${updateTime }">
 			</td>
 		</tr>
 		<tr>
 			<td>对应用户</td>
 			<td>
 				<input name="user.id" value="${customer.user.getId() }">
 			</td>
 		</tr>
 		<tr>
 			<td>所属人</td>
 			<td>
 				<input name="dispensePerson" value="${customer.dispensePerson }">
 			</td>
 		</tr>
 		<tr>
 			<td>分配日期</td>
 			<td>
 				<fmt:formatDate value="${customer.dispenseDate }" pattern="yyyy-MM-dd HH:mm:ss" var="dispenseDate"/>
 				<input name="dispenseDate" value="${dispenseDate }">
 			</td>
 		</tr>
 		<tr>
 			<td>是否共享</td>
 			<td>
 				<input name="shareFlag" value="${customer.shareFlag }">
 			</td>
 		</tr>
 		<tr>
 			<td>共享ID</td>
 			<td>
 				<input name="shareIds" value="${customer.shareIds }">
 			</td>
 		</tr>
 	</table>
 </div>
 <div align="right">
 	<a href="${pageContext.request.contextPath }/customer/customer_updateUI/${customer.id}">编辑</a>
 	<br>
 	<a href="${pageContext.request.contextPath }/customer/customer_list">返回客户列表</a>
 </div>
</body>
</html>