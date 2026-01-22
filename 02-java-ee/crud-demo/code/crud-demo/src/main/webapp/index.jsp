<%--
  Created by IntelliJ IDEA.
  User: fzw-wangzy
  Date: 2021/8/25
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div >${user.username}，欢迎您！</div>

<a href="<%=request.getContextPath()%>/userListServlet">查询所有用户信息</a>

</body>
</html>
