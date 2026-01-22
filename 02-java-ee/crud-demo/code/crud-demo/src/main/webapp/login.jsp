<%--
  Created by IntelliJ IDEA.
  User: fzw-wangzy
  Date: 2021/8/26
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script>
        //刷新验证码
        function refreshCode(){
            //1.获取验证码图片对象
            let code = document.getElementById("code");
            //2.设置其src属性，加时间戳
            code.src = "${pageContext.request.contextPath}/checkCodeServlet?time="+new Date().getTime();
        }
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/loginServlet" method="post">
    <fieldset>
        <legend>登录</legend>
        <div>
            <label for="username">用户名：</label>
            <input type="text" id="username" name="username">
        </div>
        <div>
            <label for="password">密码：</label>
            <input type="password" id="password" name="password">
        </div>
        <div>
            <label for="verifyCode">验证码：</label>
            <input type="text" id="verifyCode" name="verifyCode">
            <a href="javascript:refreshCode();">
                <img id="code" src="${pageContext.request.contextPath}/checkCodeServlet" title="看不清点击刷新" alt=""/>
            </a>
        </div>
        <div>
            <input type="submit" value="登录">
        </div>
    </fieldset>
</form>

<div style="color: #f00;">
    ${login_msg}
</div>
</body>
</html>
