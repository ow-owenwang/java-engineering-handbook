<%--
  Created by IntelliJ IDEA.
  User: fzw-wangzy
  Date: 2021/10/26
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <a href="<%=request.getContextPath()%>/?lang=zh">中文</a><br>
    <a href="<%=request.getContextPath()%>/?lang=en">英文</a>
</div>

<form action="" method="post">
    <div>
        <label for="username">${map.username}</label>
        <input type="text" id="username" name="username">
    </div>
    <div>
        <label for="password">${map.password}</label>
        <input type="text" id="password" name="password">
    </div>
    <input type="submit" value="${map.submit}">
</form>


</body>
</html>
