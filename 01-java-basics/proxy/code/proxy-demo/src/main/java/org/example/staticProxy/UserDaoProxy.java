package org.example.staticProxy;

import org.example.IUserDao;

/**
 * 静态代理类，需要实现 IUserDao 接口
 */
public class UserDaoProxy implements IUserDao {
    private IUserDao target;

    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("开启事务");
        target.save();
        System.out.println("提交事务");
    }
}
