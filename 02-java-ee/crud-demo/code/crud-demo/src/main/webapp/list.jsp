<%--
  Created by IntelliJ IDEA.
  User: fzw-wangzy
  Date: 2021/8/25
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>籍贯</th>
        <th>QQ</th>
        <th>邮箱</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${users}" var="user" varStatus="s">
        <tr>
            <td>${s.count}</td>
            <td>${user.username}</td>
            <td>${user.gender}</td>
            <td>${user.age}</td>
            <td>${user.address}</td>
            <td>${user.qq}</td>
            <td>${user.email}</td>
            <td><a href="">修改</a> <a href="">删除</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="8"><a href="">添加联系人</a></td>
    </tr>
</table>
</body>
</html>
