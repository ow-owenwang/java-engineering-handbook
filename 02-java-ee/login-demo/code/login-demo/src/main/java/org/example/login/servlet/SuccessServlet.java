package org.example.login.servlet;

import org.example.login.domain.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "successServlet", value = "/successServlet")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取 request 域中共享的 user 对象
        User user = (User) request.getAttribute("user");

        if (user != null) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("登录成功！" + user.getUsername() + ",欢迎您");
        }
    }
}
