<%--
  Created by IntelliJ IDEA.
  User: zqm
  Date: 2021/1/3
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>登录验证demo</title>
</head>
<body>
    <form:form modelAttribute="account" action="/validator/login" method="post">
        用户名：<form:input path="username"/><form:errors path="username"/> <br/>
        密码：<form:input path="password"/><form:errors path="password"/><br/>
        <input type="submit" value="登录"/>
    </form:form>
</body>
</html>
