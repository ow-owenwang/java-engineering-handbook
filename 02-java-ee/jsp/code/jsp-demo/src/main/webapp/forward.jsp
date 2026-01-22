<%--
  Created by IntelliJ IDEA.
  User: fzw-wangzy
  Date: 2021/8/24
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--转发到 success 页面--%>
<jsp:forward page="success.jsp">
    <jsp:param name="username" value="Doe"/>
</jsp:forward>

</body>
</html>
