<%--
  Created by IntelliJ IDEA.
  User: zqm
  Date: 2020/12/22
  Time: 7:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        $(function(){
           var user = {
               "id":1,
               "name":"张三"
           };
           $.ajax({
               url:"/data/json",
               data:JSON.stringify(user),
               type:"POST",
               contentType:"application/json;charset=UTF-8",
               dataType:"JSON",
               success:function (data) {
                    alert(data.id+"---"+data.name);
               }
           })
        });
    </script>
</body>
</html>
