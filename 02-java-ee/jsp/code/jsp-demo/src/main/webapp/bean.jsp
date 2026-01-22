<%@ page import="org.example.domain.Account" %><%--
  Created by IntelliJ IDEA.
  User: fzw-wangzy
  Date: 2021/10/21
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="account" class="org.example.domain.Account" scope="session"/>
<jsp:setProperty name="account" property="money" value="3000.0"/>

<%--若 property 的值为 *，省略 value 属性值，则将自动为所有属性赋值为对应的请求参数的值。--%>
<%--<jsp:setProperty name="account" property="*"/>--%>

money:
<%
    Account account1 = (Account) session.getAttribute("account");
    out.print(account1.getMoney());
%>

<br>

money:
<jsp:getProperty name="account" property="money"/>

<br>

<%
    account.setName("A");
%>

name:
<jsp:getProperty name="account" property="name"/>
</body>
</html>
