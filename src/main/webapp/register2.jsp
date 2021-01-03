<%--
  Created by IntelliJ IDEA.
  User: zqm
  Date: 2021/1/3
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>JSR-303数据校验demo</title>
</head>
<body>
    <form:form modelAttribute="person" action="/validator/register" method="post">
        用户名：<form:input path="username"/><form:errors path="username"/><br/>
        密码：<form:password path="password"/><form:errors path="password"/><br/>
        邮箱：<form:input path="email"/><form:errors path="email"/><br/>
        手机号码：<form:input path="phoneNumber"/><form:errors path="phoneNumber"/><br/>
        <input type="submit" value="注册"/>
    </form:form>
</body>
</html>
