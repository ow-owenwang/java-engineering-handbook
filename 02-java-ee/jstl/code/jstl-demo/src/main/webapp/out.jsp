<%--
  Created by IntelliJ IDEA.
  User: fzw-wangzy
  Date: 2021/7/7
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("code", "<script>alert(123);</script>");
%>

<c:out value="abc"/>


<c:out value="${code}" escapeXml="false"/>

<%--abc 不存在时就输出 def--%>
<c:out value="${abc}" default="def"/>


</body>
</html>
