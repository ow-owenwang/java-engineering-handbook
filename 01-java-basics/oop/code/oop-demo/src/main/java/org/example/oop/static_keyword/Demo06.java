package org.example.oop.static_keyword;

public class Demo06 {
    static {
        System.out.println("static 1");
    }

    public static void main(String[] args) {
        /*
            尽管 main 中没有内容，但是静态代码块还是会执行。

            运行结果：
                static 1
                static 2
         */
    }

    static {
        System.out.println("static 2");
    }
}
