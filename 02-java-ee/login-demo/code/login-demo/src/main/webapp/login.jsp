<%--
  Created by IntelliJ IDEA.
  User: fzw-wangzy
  Date: 2021/7/16
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/loginServlet" method="post">
    用户名:<input type="text" name="username"> <br>
    密码:<input type="password" name="password"><br>

    <input type="submit" value="登录">
</form>
</body>
</html>
