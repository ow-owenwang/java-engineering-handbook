package org.example.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet(name = "ServletBase", value = "/ServletBase")
public class ServletBase extends HttpServlet {

    //为了复用性，把 ServletDemo02 中的反射部分代码进行提取。
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String methodName = req.getParameter("method");

        if (methodName == null || methodName.trim().isEmpty()) {
            throw new RuntimeException("您没有传递method参数！无法确定您要调用的方法！");
        }

        Class c = this.getClass();
        Method method = null;
        try {
            method = c.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("您要调用的方法" + methodName + "不存在");
        }

        try {
            String result = (String) method.invoke(this, req, resp);

            if (result == null || result.trim().isEmpty()) {
                return;
            }

            if (result.contains(":")) {
                int i = result.indexOf(":");
                String s = result.substring(0, i);
                String path = result.substring(i + 1);
                if (s.equalsIgnoreCase("redirect")) {
                    resp.sendRedirect(req.getContextPath() + path);
                } else if (s.equalsIgnoreCase("forward")) {
                    req.getRequestDispatcher(path).forward(req, resp);
                } else {
                    throw new RuntimeException("你指定的操作：" + s + "，当前版本还不支持！");
                }
            } else {
                req.getRequestDispatcher(result).forward(req, resp);
            }
        } catch (Exception e) {
            System.out.println("您调用的方法内部" + methodName + "抛出了异常");
            throw new RuntimeException(e);
        }
    }
}
