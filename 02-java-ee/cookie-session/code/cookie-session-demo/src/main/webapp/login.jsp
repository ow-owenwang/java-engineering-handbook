<%--
  Created by IntelliJ IDEA.
  User: fzw-wangzy
  Date: 2021/8/20
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/LoginServlet" method="post">
    <div>
        用户名：<input type="text" name="username">
    </div>
    <div>
        密码：<input type="password" name="password">
    </div>
    <div>
        验证码：<input type="text" name="checkCode"> <img src="<%=request.getContextPath()%>/CheckCodeServlet" alt="">
    </div>
    <div>
        <input type="submit" value="提交">
    </div>
</form>

<div>
    <div><%=request.getAttribute("cc_error") == null ? "" : request.getAttribute("cc_error")%>
    </div>
    <div><%=request.getAttribute("login_error") == null ? "" : request.getAttribute("login_error")%>
    </div>
</div>

<script>
    window.onload = function () {
        document.getElementById("img").onclick = function () {
            this.src = "<%=request.getContextPath()%>/CheckCodeServlet?time=" + new Date().getTime();
        }
    }
</script>


</body>
</html>
