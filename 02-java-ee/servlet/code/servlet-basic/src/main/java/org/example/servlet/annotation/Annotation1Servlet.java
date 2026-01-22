package org.example.servlet.annotation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "annotation1Servlet", value = "/annotation1Servlet", initParams = {
        @WebInitParam(name = "p1", value = "v1"),
        @WebInitParam(name = "p2", value = "v2")})
public class Annotation1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String v1 = getInitParameter("p1");
        System.out.println(v1);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
