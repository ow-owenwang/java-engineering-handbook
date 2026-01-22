<%--
  Created by IntelliJ IDEA.
  User: fzw-wangzy
  Date: 2021/7/7
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="i" begin="1" end="10" step="2">
    ${i}<br>
</c:forEach>

<%
    String[] arr = {"one", "two"};
    pageContext.setAttribute("arr", arr);
%>

<c:forEach items="${arr}" var="item" varStatus="vs">
    ${item}, ${vs.first}, ${vs.last}, ${vs.count}, ${vs.current}, ${vs.index}<br>
</c:forEach>

<%--<c:forEach items="${map}" var="m">
    <c:out value="${m.key} : ${m.value}"/>
</c:forEach>--%>


</body>
</html>
