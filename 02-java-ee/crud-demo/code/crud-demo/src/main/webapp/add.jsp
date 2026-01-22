<%--
  Created by IntelliJ IDEA.
  User: fzw-wangzy
  Date: 2021/8/26
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/addUserServlet" method="post">
    <fieldset>
        <legend>添加联系人</legend>
        <div>
            <label for="username">用户名：</label>
            <input type="text" id="username" name="username">
        </div>
        <div>
            <label for="password">密码：</label>
            <input type="password" id="password" name="password">
        </div>
        <div>
            <label for="male">男</label>
            <input type="radio" id="male" name="gender" value="男" checked>
            <label for="female">女</label>
            <input type="radio" id="female" name="gender" value="女">
        </div>
        <div>
            <label for="age">年龄：</label>
            <input type="text" id="age" name="age">
        </div>
        <div>
            <label for="address">籍贯：</label>
            <select name="address" id="address">
                <option value="陕西">陕西</option>
                <option value="北京">北京</option>
                <option value="上海">上海</option>
            </select>
        </div>
        <div>
            <label for="qq">QQ：</label>
            <input type="text" id="qq" name="qq">
        </div>
        <div>
            <label for="email">Email：</label>
            <input type="text" id="email" name="email">
        </div>
        <div>
            <input type="submit" value="提交">
        </div>
    </fieldset>
</form>

</body>
</html>
