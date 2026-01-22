package org.example.oop.static_keyword;

public class Demo04 extends Base {
    static {
        System.out.println("Demo04 static");
    }

    public Demo04() {
        System.out.println("Demo04 constructor");
    }

    public static void main(String[] args) {
        new Demo04();
        /*
        运行结果：
            A static
            Demo04 static
            A constructor
            Demo04 constructor
         */
    }
}


class Base {
    static {
        System.out.println("A static");
    }

    public Base() {
        System.out.println("A constructor");
    }
}
