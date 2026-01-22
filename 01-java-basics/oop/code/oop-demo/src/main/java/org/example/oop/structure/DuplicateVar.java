package org.example.oop.structure;

/**
 * 当外部类的成员变量和内部类的成员变量重名
 */
public class DuplicateVar {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
        inner.method();
    }
}

class Outer {
    int num = 1;

    public class Inner {
        int num = 2;

        public void method() {
            int num = 3;

            System.out.println(num);//局部变量
            System.out.println(this.num);//内部类成员变量
            System.out.println(Outer.this.num);//外部类成员变量
        }
    }
}
