<%--
  Created by IntelliJ IDEA.
  User: fzw-wangzy
  Date: 2021/10/8
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/upload2Servlet" method="post" enctype="multipart/form-data">
    <div>
        <label>
            用户名：<input type="text" name="username" id="username">
        </label>
    </div>
    <div>
        <label>
            文件：<input type="file" name="photo" id="photo">
        </label>
    </div>
    <div>
        <label>
            读书<input type="checkbox" name="hobby" value="Reading"/>
        </label>
        <label>
            运动<input type="checkbox" name="hobby" value="Sports"/>
        </label>
        <label>
            购物<input type="checkbox" name="hobby" value="Shopping"/>
        </label>
    </div>
    <input type="submit" value="提交">
</form>
</body>
</html>
