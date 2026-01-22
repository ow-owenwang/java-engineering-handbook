<%--
  Created by IntelliJ IDEA.
  User: fzw-wangzy
  Date: 2021/8/24
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("msg", "A");
    request.setAttribute("msg", "B");
    session.setAttribute("msg", "C");
    application.setAttribute("msg", "D");
%>

<ul>
    <li>${msg}</li>
    <li>${pageScope.msg}</li>
    <li>${requestScope.msg}</li>
    <li>${sessionScope.msg}</li>
    <li>${applicationScope.msg}</li>
</ul>
</body>
</html>
