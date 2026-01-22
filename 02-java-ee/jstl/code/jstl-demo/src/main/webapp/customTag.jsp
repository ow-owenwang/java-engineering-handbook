<%@ taglib prefix="myTag" uri="http://www.example.org/mytag/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fzw-wangzy
  Date: 2021/10/21
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 导入标签库(描述文件) -->
<%@taglib uri="http://www.example.org/mytag/core" prefix="mytag" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<mytag:readerFile src="/WEB-INF/a.txt"/>

<br>

<mytag:max num1="10" num2="100"/>

<br>

<mytag:hello value="word" count="10"/>
</body>
</html>
