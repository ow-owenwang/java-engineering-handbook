<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: fzw-wangzy
  Date: 2021/8/25
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${3>4}
<br>
\${3>4}

<hr>

<%--算数运算符--%>
${3+4}<br>
${3/4}<br>
${3 div 4}<br>
${3%4}<br>
${3 mod 4}<br>

<hr>

<%--比较运算符--%>
${3==4}<br>

<hr>

<%--逻辑运算符--%>
${3>4 && 3<4}<br>
${3>4 and 3<4}<br>

<hr>

<%--empty--%>

<%
    String str = "";
    request.setAttribute("str", str);

    List<String> list = new ArrayList<>();
    request.setAttribute("list", list);
%>

${not empty str}<br>
${not empty list}

</body>
</html>
