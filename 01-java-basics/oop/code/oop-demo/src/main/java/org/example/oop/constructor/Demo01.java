package org.example.oop.constructor;

public class Demo01 {
    public Demo01() {
        this("hello");//调用有参构造方法
        System.out.println("无参构造方法");
    }

    public Demo01(String msg) {
        System.out.println(msg + "有参构造方法");
    }

    public static void main(String[] args) {
        new Demo01();
        System.out.println("==================");

        new Demo01("hh");
    }
}
