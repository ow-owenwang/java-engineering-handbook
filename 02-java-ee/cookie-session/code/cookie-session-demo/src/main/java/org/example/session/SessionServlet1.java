package org.example.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SessionServlet1", value = "/SessionServlet1")
public class SessionServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        //获取最大时效
        int maxInactiveInterval = session.getMaxInactiveInterval();
        System.out.println(maxInactiveInterval);//
        //设置最大时效
        //session.setMaxInactiveInterval(30 * 60);

        //向 session 中存储数据
        session.setAttribute("msg", "hello");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
