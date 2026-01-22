<%--
  Created by IntelliJ IDEA.
  User: fzw-wangzy
  Date: 2021/7/7
  Time: 15:50
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
    pageContext.setAttribute("msg", "pageContext");
    request.setAttribute("msg", "request");
    session.setAttribute("msg", "session");
    application.setAttribute("msg", "application");
%>

<%--<c:remove var="msg"/>--%>
<c:remove var="msg" scope="page"/>
<c:out value="${msg}" default="none"/>


</body>
</html>
