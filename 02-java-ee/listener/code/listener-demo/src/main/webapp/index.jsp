<%--
  Created by IntelliJ IDEA.
  User: fzw-wangzy
  Date: 2021/8/25
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" session="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    session="true" 默认服务器启动时就创建 session。

--%>
<%
    //HttpSession session = request.getSession();
    //session.setMaxInactiveInterval(20);
    //session.invalidate();
    //关闭浏览器，并不意味着 session 被销毁，还可以通过 sessionid 找到服务器中的 session 对象。
    //http://localhost:8989/app/session.jsp;jsessionid=F4119DE0FC93ED38E8EC83B24CFA3B81

%>

${session.id}
</body>
</html>
