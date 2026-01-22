<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: fzw-wangzy
  Date: 2021/7/8
  Time: 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Date date = new Date();
    pageContext.setAttribute("date", date);

    Double d1 = 3.4;
    Double d2 = 5.5;
    pageContext.setAttribute("d1", d1);
    pageContext.setAttribute("d2", d2);
%>


<div>
    <%--格式化时间--%>
    <fmt:formatDate value="${date}" pattern="yyyy-MM-dd hh:mm:ss"/>
</div>

<div>
    <%--格式化数字--%>
    <fmt:formatNumber value="${d1}" pattern="0.000"/>
    <fmt:formatNumber value="${d2}" pattern="#.##"/>
</div>
</body>
</html>
