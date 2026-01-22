<%--
  Created by IntelliJ IDEA.
  User: fzw-wangzy
  Date: 2021/8/24
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
向 session 中保存数据

<%
    session.setAttribute("msg", "session 数据");
%>



</body>
</html>
