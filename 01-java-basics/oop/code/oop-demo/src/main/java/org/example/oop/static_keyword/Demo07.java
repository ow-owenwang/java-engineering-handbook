package org.example.oop.static_keyword;

public class Demo07 {
    public static void main(String[] args) {
        new Demo07B();
        /*
            运行结果：
                Demo07A static
                Demo07B static
                Demo07A
                Demo07 constructor
                Demo07B
                Demo07B constructor
         */
    }
}

class Demo07A {
    {
        System.out.println("Demo07A");
    }

    static {
        System.out.println("Demo07A static");
    }

    public Demo07A() {
        System.out.println("Demo07 constructor");
    }
}

class Demo07B extends Demo07A {
    {
        System.out.println("Demo07B");
    }

    static {
        System.out.println("Demo07B static");
    }

    public Demo07B() {
        System.out.println("Demo07B constructor");
    }
}
