package org.example.oop.final_keyword;

/**
 * 关键字 abstract 和 final 不能同时使用，他们两个是矛盾的
 */
public abstract class FinalDemo02A {
    public final void method01() {

    }

    public abstract /*final*/ void method02();
}
