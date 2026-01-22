package org.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 继承：
 * 被增强对象不能变
 * 增强内容不能变
 * <p>
 * 装饰者模式：
 * 被增强对象可变
 * 但增强内容不可变
 * <p>
 * 动态代理：
 * 被增强对象可变
 * 增强内容可变
 */
public class Demo02 {
    public static void main(String[] args) {
        Waiter waiter = new ManWaiter();
        waiter.serve();

        ClassLoader loader = Demo02.class.getClassLoader();
        Class[] interfaces = {Waiter.class};
        InvocationHandler h = new WaiterInvocationHandler(waiter);
        Waiter waiterProxy = (Waiter) Proxy.newProxyInstance(loader, interfaces, h);

        waiterProxy.serve();

    }
}

class WaiterInvocationHandler implements InvocationHandler {
    private Waiter waiter;

    public WaiterInvocationHandler(Waiter waiter) {
        this.waiter = waiter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("您好");
        this.waiter.serve();
        System.out.println("再见");

        return null;
    }
}
