package org.example.test;

import org.example.login.dao.UserDao;
import org.example.login.domain.User;

public class UserDaoTest {
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("Doe");
        user.setPassword("123");

        UserDao userDao = new UserDao();
        User u = userDao.login(user);
        System.out.println(u);
    }
}
