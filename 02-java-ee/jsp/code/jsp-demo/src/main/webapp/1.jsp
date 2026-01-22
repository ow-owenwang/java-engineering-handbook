<%--
  Created by IntelliJ IDEA.
  User: fzw-wangzy
  Date: 2021/8/24
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int a = 100;
%>

<div>
    <%
        out.print(a++);
    %>
</div>

<div>
    <%=a%>
</div>

<%!
    int a = 10;

    public void method() {
        System.out.println(a);
    }
%>

<%
    out.print(this.a++);
    method();
%>
</body>
</html>
