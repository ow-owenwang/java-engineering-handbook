package org.example.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet(name = "ServletDemo02", value = "/ServletDemo02")
public class ServletDemo02 extends HttpServlet {
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
            method.invoke(this, req, resp);
        } catch (Exception e) {
            System.out.println("您调用的方法内部" + methodName + "抛出了异常");
            throw new RuntimeException(e);
        }
    }

    public void addUser(HttpServletRequest req, HttpServletResponse res) {
//        throw new IOException("测试……");
        System.out.println("addUser()...");
    }

    public void editUser(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("editUser()...");
    }

    public void deleteUser(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("deleteUser()...");
    }
}
