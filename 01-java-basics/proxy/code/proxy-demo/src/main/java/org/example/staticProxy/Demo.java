package org.example.staticProxy;

import org.example.IUserDao;
import org.example.UserDao;

/**
 * 调用代理类
 * <p>
 * 由于代理只能为一个类服务，如果需要代理的类很多，那么就需要编写大量的代理类，比较繁琐。
 */
public class Demo {
    public static void main(String[] args) {
        IUserDao target = new UserDao();
        UserDaoProxy proxy = new UserDaoProxy(target);
        proxy.save();
    }
}
