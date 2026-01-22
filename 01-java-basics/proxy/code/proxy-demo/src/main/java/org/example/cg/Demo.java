package org.example.cg;

public class Demo {
    public static void main(String[] args) {
        UserDao1 userDao = new UserDao1();
        UserDao1 proxy = (UserDao1) new ProxyFactory1(userDao).getProxyInstance();
        proxy.save();
    }
}
