<%--
  Created by IntelliJ IDEA.
  User: fzw-wangzy
  Date: 2021/8/24
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <div>${param.username}</div>
    <div>${paramValues.hobby}</div>
    <div>${paramValues.hobby[0]}</div>
</div>

<div>
    <div>获取请求头：${header["user-agent"]}</div>
    <div>获取初始化参数：${initParam.a}</div>
    <div>获取 Cookie：${cookie.JSESSIONID.value}</div>
    <div>获取 SessionId：${pageContext.session.id}</div>
</div>
</body>
</html>
