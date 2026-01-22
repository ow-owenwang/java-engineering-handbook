package org.example.oop.structure;

/**
 * 局部内部类
 *
 * new 出来的对象在堆内存当中。
 * 局部变量是跟着方法走的，在栈内存当中。
 * 方法运行结束之后，立刻出栈，局部变量就会立刻消失。
 * 但是 new 出来的对象会在堆当中持续存在，直到垃圾回收消失。
 */
public class InnerClass {
    public void method() {
        int num = 10;
        class Inner {
            public void method() {
                System.out.println(num);
            }
        }
    }
}
