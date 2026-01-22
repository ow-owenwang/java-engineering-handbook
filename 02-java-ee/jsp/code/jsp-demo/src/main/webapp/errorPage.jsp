<%--
  Created by IntelliJ IDEA.
  User: fzw-wangzy
  Date: 2021/8/24
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Error Page</title>
</head>
<body>

isErrorPage 决定了是否内置 exception 对象，值为 true 时才可以使用。

<%
    exception.printStackTrace(response.getWriter());
%>

<%
    String message = exception.getMessage();
    out.print(message);
%>
</body>
</html>
