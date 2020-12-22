<%--
  Created by IntelliJ IDEA.
  User: zqm
  Date: 2020/12/22
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${requestScope.user}<br/>
    ${sessionScope.user}<br/>
    ${applicationScope.user}<br/>
</body>
</html>
