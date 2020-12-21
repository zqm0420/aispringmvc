<%--
  Created by IntelliJ IDEA.
  User: zqm
  Date: 2020/12/21
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
    <form action="/hello/save" method="post">
        用户ID：<input type="text" name="id"/><br/>
        用户名：<input type="text" name="name"/><br/>
        用户地址：<input type="text" name="address.value"/><br/>
        <input type="submit" value="注册"/>
    </form>
</body>
</html>
