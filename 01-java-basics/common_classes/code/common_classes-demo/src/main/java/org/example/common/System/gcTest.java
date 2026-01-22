package org.example.common.System;

public class gcTest {
    public static void main(String[] args) {
        Person person = new Person();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        person = null;
        System.gc();
    }
}


class Person {
    public Person() {
        System.out.println("对象初始化了");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("对象被回收了");
    }
}
