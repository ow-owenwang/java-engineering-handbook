package org.example.domain;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.io.Serializable;

/**
 * HttpSessionBindingListener 监听了实现此接口的类的对象绑定到 session 和从 session 中解除绑定时触发的事件。
 */
public class Account implements Serializable, HttpSessionBindingListener {
    private int id;
    private String name;
    private double money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

    /**
     * //当前对象被绑定到 session 时该方法会调用
     * @param event
     */
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        String name = event.getName();
        Object value = event.getValue();
        System.out.println("session 中绑定对象 " + name + ": " + value);
    }

    /**
     * 当前对象从 session 中解除绑定时该方法会调用
     * @param event
     */
    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("session 中解除了对象绑定");
    }
}
