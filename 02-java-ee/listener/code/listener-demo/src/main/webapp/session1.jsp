<%@ page import="org.example.domain.Account" %><%--
  Created by IntelliJ IDEA.
  User: fzw-wangzy
  Date: 2021/10/21
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    HttpSession session = request.getSession();
    session.setAttribute("A", "A-Value");

    Account account = new Account();
    account.setId(1);
    account.setName("A");
    account.setMoney(3000.10);

    session.setAttribute("account", account);
%>

<%
    session.removeAttribute("account");
%>
</body>
</html>
