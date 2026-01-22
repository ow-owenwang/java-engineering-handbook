package org.example.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletDemo03", value = "/ServletDemo03")
public class ServletDemo03 extends ServletBase {


    public String fun1(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("fun1()...");
        return "forward:/index.jsp";
    }

    public String fun2(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("fun2()...");
        return "redirect:/index.jsp";
    }

    public String fun3(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("fun3()...");
//        return "download:/WEB-INF/files/a.jpg";
        return null;
    }
}
