package org.example.servlet.param;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "ParamServlet", value = "/ParamServlet")
public class ParamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        // /ParamServlet?username=张三
        //高版本 Tomcat 会以 UTF8 编码解析参数，中文不会产生乱码
        //比较老的版本需要手动转换：
        //方法一：username.getBytes(StandardCharsets.ISO_8859_1);
        //方法二：request.setCharacterEncoding("UTF-8");
        byte[] bytes = username.getBytes(StandardCharsets.UTF_8);
        String string = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(string);//以上都是以 UTF8 进行处理的，输出正常，说明 Tomcat 确实以 UTF8 编码对参数进行处理的
        System.out.println(username);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
