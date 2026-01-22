<%@ page import="org.example.domain.Emp" %>
<%@ page import="org.example.domain.Address" %><%--
  Created by IntelliJ IDEA.
  User: fzw-wangzy
  Date: 2021/8/24
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    Address address = new Address();
    address.setCity("北京市");
    address.setStreet("A大道");

    Emp emp = new Emp();
    emp.setName("Doe");
    emp.setAge(20);
    emp.setAddress(address);

    request.setAttribute("emp", emp);

%>

<div>${requestScope.emp.address.city}</div>
</body>
</html>
