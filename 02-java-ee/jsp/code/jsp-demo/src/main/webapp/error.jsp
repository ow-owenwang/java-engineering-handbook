<%--
  Created by IntelliJ IDEA.
  User: fzw-wangzy
  Date: 2021/8/24
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="errorPage.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
页面有错误时，转发到 errorPAge.jsp。
<%
    throw new Exception("Error");
%>
</body>
</html>
