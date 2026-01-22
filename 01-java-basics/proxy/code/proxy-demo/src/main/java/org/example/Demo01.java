package org.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Demo01 {
    public static void main(String[] args) {
        ClassLoader loader = Demo01.class.getClassLoader();
        Object o = Proxy.newProxyInstance(loader, new Class[]{A.class, B.class}, new InvocationHandler() {
            /**
             * 在调用代理对象所实现接口中的方法时执行。
             * @param proxy
             * @param method
             * @param args
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("动态代理");
                return null;
            }
        });

        A a = (A) o;
        B b = (B) o;

        a.a();
        a.aa();

        b.b();
        b.bb();

        System.out.println(o.getClass().getName());

        Object hello = a.aaa("Hello", 1000);
        System.out.println(hello);
    }
}

interface A {
    public void a();

    public void aa();

    public Object aaa(String str, int i);
}

interface B {
    public void b();

    public void bb();
}
