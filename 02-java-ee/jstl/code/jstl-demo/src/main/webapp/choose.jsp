<%--
  Created by IntelliJ IDEA.
  User: fzw-wangzy
  Date: 2021/7/7
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="score" value="90"/>

<c:choose>
    <c:when test="${score == 100}">满分</c:when>
    <c:when test="${score >= 90}">优秀</c:when>
    <c:when test="${score >= 60}">及格</c:when>
    <c:otherwise>不合格</c:otherwise>
</c:choose>
</body>
</html>
