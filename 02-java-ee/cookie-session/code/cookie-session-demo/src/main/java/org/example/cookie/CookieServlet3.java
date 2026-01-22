package org.example.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CookieServlet3", value = "/CookieServlet3")
public class CookieServlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("cookie1", "v1");
        //设置 Cookie 的存活时间为30秒
        cookie.setMaxAge(30);
        //让当前服务器下部署的所有项目共享 Cookie 信息
        cookie.setPath("/");

        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
