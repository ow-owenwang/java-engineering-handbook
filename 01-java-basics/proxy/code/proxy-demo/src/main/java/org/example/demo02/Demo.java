package org.example.demo02;

import org.example.ManWaiter;
import org.example.Waiter;

public class Demo {
    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory();
        factory.setTargetObject(new ManWaiter());
        factory.setBeforeAdvice(new BeforeAdvice() {
            @Override
            public void before() {
                System.out.println("您好");
            }
        });
        factory.setAfterAdvice(new AfterAdvice() {
            @Override
            public void after() {
                System.out.println("再见");
            }
        });

        Waiter waiter = (Waiter) factory.createProxy();
        waiter.serve();
    }
}
