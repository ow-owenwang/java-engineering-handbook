package org.example.login.servlet;

import org.apache.commons.beanutils.BeanUtils;
import org.example.login.dao.UserDao;
import org.example.login.domain.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("UTF-8");
        /*//获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //封装 User 对象
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);*/

        Map<String, String[]> map = request.getParameterMap();
        User loginUser = new User();
        try {
            BeanUtils.populate(loginUser, map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);

        if (user == null) {
            //失败
            request.getRequestDispatcher("/failServlet").forward(request, response);
        } else {
            //成功
            request.setAttribute("user", user);
            request.getRequestDispatcher("/successServlet").forward(request, response);
        }


    }
}
