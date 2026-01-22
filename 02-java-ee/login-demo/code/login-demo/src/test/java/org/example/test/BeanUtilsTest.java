package org.example.test;

import org.apache.commons.beanutils.BeanUtils;
import org.example.login.domain.User;

import java.lang.reflect.InvocationTargetException;

public class BeanUtilsTest {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        User user = new User();
        BeanUtils.setProperty(user, "username", "Doe");
        System.out.println(user);


        String username = BeanUtils.getProperty(user, "username");
        System.out.println(username);
    }
}
