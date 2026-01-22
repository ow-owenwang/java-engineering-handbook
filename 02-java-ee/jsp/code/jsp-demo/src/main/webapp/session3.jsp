<%--
  Created by IntelliJ IDEA.
  User: fzw-wangzy
  Date: 2021/8/25
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="<%=request.getContextPath()%>/session1.jsp?JSESSIONID=<%=session.getId()%>">连接</a>

<br>

<%
    out.print(response.encodeURL("/demo01/SessionServlet"));
%>
</body>
</html>
