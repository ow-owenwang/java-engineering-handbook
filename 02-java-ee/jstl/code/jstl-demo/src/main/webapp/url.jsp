<%--
  Created by IntelliJ IDEA.
  User: fzw-wangzy
  Date: 2021/7/7
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:url value="/"/>
<br>
<c:url value="/" var="msg" scope="request"/>
<c:out value="msg"/>
<br>
<c:url value="/ServletDemo"/>
<br>
<%--/jstl_demo_war_exploded/ServletDemo?username=root&password=123--%>
<c:url value="/ServletDemo">
    <c:param name="username" value="root"/>
    <c:param name="password" value="123"/>
</c:url>

<a href="<c:url value='/index.jsp'/>">回到首页</a>

</body>
</html>
