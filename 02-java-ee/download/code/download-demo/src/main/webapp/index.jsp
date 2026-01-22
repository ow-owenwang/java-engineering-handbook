<%--
  Created by IntelliJ IDEA.
  User: fzw-wangzy
  Date: 2021/10/8
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<%=request.getContextPath()%>/download1Servlet">下载</a>


<a href="${pageContext.request.contextPath}/img/2.jpg">图片</a><br>
<a href="<%=request.getContextPath()%>/img/1.avi">视频</a><br>

<br>

<a href="${pageContext.request.contextPath}/download1Servlet?filename=九尾.jpg">图片</a><br>
<a href="${pageContext.request.contextPath}/download1Servlet?filename=1.avi">视频</a><br>
</body>
</html>
