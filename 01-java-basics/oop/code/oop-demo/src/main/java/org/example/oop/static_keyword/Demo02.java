package org.example.oop.static_keyword;

public class Demo02 {
    public static void main(String[] args) {
        System.out.println(A.str);
        //不能访问
        //System.out.println(A.i);
    }
}

class A {
    public static String str = "A";
    private static int i = 1000;
}
