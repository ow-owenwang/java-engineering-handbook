package org.example.oop.static_keyword;

public class Demo01 {
    private static int num = 0;

    public Demo01() {
        num++;
    }

    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();
        Demo01 demo02 = new Demo01();

        //直接通过类名获取私有静态属性
        System.out.println(num);//2
    }
}
