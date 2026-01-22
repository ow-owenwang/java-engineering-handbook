<%--
  Created by IntelliJ IDEA.
  User: fzw-wangzy
  Date: 2021/7/7
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="msg" value="hello"/>
<c:set var="msg1" value="world" scope="session"/>

<c:out value="${msg}"/>
<c:out value="${msg1}"/>
</body>
</html>
