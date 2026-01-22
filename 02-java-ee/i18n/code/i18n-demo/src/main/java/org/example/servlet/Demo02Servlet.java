package org.example.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "demo02Servlet", value = "/")
public class Demo02Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lang = request.getParameter("lang");
        Locale locale = null;
        //第一次访问
        if (lang == null) {
            locale = request.getLocale();
        } else if (lang.equals("en")) {
            locale = Locale.US;
        } else if (lang.equals("zh")) {
            locale = Locale.CHINA;
        } else {
            locale = request.getLocale();
        }

        ResourceBundle rb = ResourceBundle.getBundle("lang", locale);
        Enumeration<String> keys = rb.getKeys();
        HashMap<String, Object> map = new HashMap<>();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            map.put(key, rb.getString(key));
        }
        request.setAttribute("map", map);
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
