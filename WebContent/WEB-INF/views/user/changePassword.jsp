<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改密码</title>
</head>
<body>

    <form:form action="${pageContext.request.contextPath}/sysUser/changePassword" method="post" modelAttribute="userPwd">
        <div class="form-group">
        	<input type="hidden" name="user_id" value="${user_id }"/>
            <label for="newPassword">新密码：</label>
            <input type="text" id="newPassword" name="newPassword"/>
        </div>
        <input type="submit" value="修改密码">
    </form:form>

</body>
</html>