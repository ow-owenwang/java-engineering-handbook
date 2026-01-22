package org.example.servlet;

import org.apache.commons.beanutils.BeanUtils;
import org.example.domain.User;
import org.example.service.IUserService;
import org.example.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "addUserServlet", value = "/addUserServlet")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        Map<String, String[]> params = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, params);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        IUserService userService = new UserServiceImpl();
        userService.addUser(user);

        response.sendRedirect(request.getContextPath() + "/userListServlet");
    }
}
