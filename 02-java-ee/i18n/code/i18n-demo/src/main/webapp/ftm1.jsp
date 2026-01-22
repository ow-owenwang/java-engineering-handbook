<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: fzw-wangzy
  Date: 2021/10/26
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    request.setAttribute("date", new Date());
    request.setAttribute("salary", 4000.20);
%>

<c:if test="${sessionScope.locale} ! = null">
    <fmt:setLocale value="${sessionScope.locale}"/>
</c:if>

<fmt:bundle basename="lang">
    <fmt:message key="date"/><br>
    <fmt:formatDate value="${date}"/><br>
    <fmt:message key="salary"/><br>
    <fmt:formatNumber value="${salary}"/>
</fmt:bundle>

</body>
</html>
