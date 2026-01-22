package org.example.oop.static_keyword;

public class Demo05 {
    Demo05A demo05A = new Demo05A();

    static {
        System.out.println("Demo05 static");
    }

    public Demo05() {
        System.out.println("Demo05 constructor");
    }

    public static void main(String[] args) {
        new Demo05B();
        /*
            运行结果：
                Demo05 static
                Demo05B static
                Demo05A static
                Demo05A constructor
                Demo05 constructor
                Demo05A constructor
                Demo05B constructor
         */
    }
}


class Demo05A {
    static {
        System.out.println("Demo05A static");
    }

    public Demo05A() {
        System.out.println("Demo05A constructor");
    }
}

class Demo05B extends Demo05 {
    Demo05A demo05A = new Demo05A();

    static {
        System.out.println("Demo05B static");
    }

    public Demo05B() {
        System.out.println("Demo05B constructor");
    }
}
