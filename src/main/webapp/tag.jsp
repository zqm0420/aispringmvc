<%--
  Created by IntelliJ IDEA.
  User: zqm
  Date: 2020/12/23
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>演示表单标签库</title>
</head>
<body>
    <h1>学生信息</h1>
    <form:form modelAttribute="student">
        <form:input path="id"/><br/>
        <form:input path="name"/><br/>
        <form:input path="age"/><br/>
        <input type="submit" value="提交"/>
    </form:form>
</body>
</html>
