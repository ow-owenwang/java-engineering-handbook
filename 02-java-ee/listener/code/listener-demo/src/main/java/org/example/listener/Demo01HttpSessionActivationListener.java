package org.example.listener;

import javax.servlet.http.*;

/**
 * 此种监听器不需要注册
 */
public class Demo01HttpSessionActivationListener implements HttpSessionActivationListener {
    //钝化之前此方法会调用
    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        //HttpSessionActivationListener.super.sessionWillPassivate(se);
        System.out.println("session 马上开始钝化");
    }

    //活化之后此方法会调用
    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        //HttpSessionActivationListener.super.sessionDidActivate(se);
        System.out.println("session 已经活化了");
    }
}
