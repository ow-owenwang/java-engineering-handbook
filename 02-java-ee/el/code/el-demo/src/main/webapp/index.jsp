<%--
  Created by IntelliJ IDEA.
  User: fzw-wangzy
  Date: 2021/8/24
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <a href="<%=request.getContextPath()%>/3.jsp?username=Doe">click</a><br>
    <a href="${pageContext.request.contextPath}/3.jsp?username=Doe&hobby=a&hobby=b">click</a><br>
</div>


</body>
</html>
