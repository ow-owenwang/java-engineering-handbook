package org.example.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletDemo01", value = "/ServletDemo01")
public class ServletDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
        String methodName = req.getParameter("method");



        /*
        * 无法复用，并且扩展性不足。可以用反射解决。
        * */
        if (methodName.equals("addUser")) {
            addUser(req, resp);
        } else if (methodName.equals("editUser")) {
            editUser(req, resp);
        } else if (methodName.equals("deleteUser")) {
            deleteUser(req, resp);
        }
    }

    public void addUser(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("addUser()...");
    }

    public void editUser(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("editUser()...");
    }

    public void deleteUser(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("deleteUser()...");
    }
}
