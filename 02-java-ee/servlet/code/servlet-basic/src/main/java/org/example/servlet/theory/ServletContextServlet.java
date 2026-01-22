package org.example.servlet.theory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletContextServlet", value = "/ServletContextServlet")
public class ServletContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = request.getServletContext();
        Integer count = (Integer) sc.getAttribute("count");
        if (count == null) {
            count = 1;
        } else {
            count++;
        }
        sc.setAttribute("count", count);

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print("<h1>本页面一共被访问了" + count + "次！</h1>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
