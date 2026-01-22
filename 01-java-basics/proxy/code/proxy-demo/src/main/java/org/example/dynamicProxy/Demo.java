package org.example.dynamicProxy;

import org.example.IUserDao;
import org.example.UserDao;

/**
 * 利用反射机制在运行时创建代理类。
 */
public class Demo {
    public static void main(String[] args) {
        IUserDao userDao = new UserDao();

        IUserDao proxy = (IUserDao)new ProxyFactory(userDao).getProxyInstance();
        //执行代理方法
        proxy.save();

    }
}
