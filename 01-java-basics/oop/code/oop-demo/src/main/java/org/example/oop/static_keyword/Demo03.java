package org.example.oop.static_keyword;

public class Demo03 {
    //静态变量
    public static String str = "str";
    private static int i = 1000;

    static {
        i = 100;
    }

    //静态方法
    static void method() {
        System.out.println(str + "------" + i);
    }

    public static void main(String[] args) {
        Demo03.method();
    }
}
