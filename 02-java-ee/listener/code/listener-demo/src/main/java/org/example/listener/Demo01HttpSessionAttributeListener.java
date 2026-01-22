package org.example.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class Demo01HttpSessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        String name = event.getName();
        System.out.println("session 中添加了属性：" + name);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        String name = event.getName();
        System.out.println("session 中移除了属性：" + name);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {

    }
}
