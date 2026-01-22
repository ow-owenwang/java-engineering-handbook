package org.example;

/**
 * 被代理类
 */
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("保存用户");
    }
}
