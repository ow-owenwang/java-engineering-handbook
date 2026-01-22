package org.example.exception;


/*
 * 继承过程中的异常处理
 *
 *
 * */
public class Demo03 {
    public static void main(String[] args) {

    }
}


class A {
    public void fn1() throws NullPointerException, ClassCastException {
    }

    public void fn2() throws IndexOutOfBoundsException {
    }

    public void fn3() throws IndexOutOfBoundsException {
    }

    public void fn4() {
    }
}

class B extends A {

    //子类重写父类方法时，抛出和父类方法相同的异常
    @Override
    public void fn1() throws NullPointerException, ClassCastException {
    }

    //子类重写父类方法时，抛出父类方法异常的子类
    @Override
    public void fn2() throws ArrayIndexOutOfBoundsException {
    }

    //子类重写父类方法时，不抛出异常
    @Override
    public void fn3() {
    }

    //父类方法没有抛出异常，子类重写父类该方法时也不可抛出异常。
    //如果子类此方法中会出现异常，只能通过 try-catch 捕获处理，不能声明抛出。
    @Override
    public void fn4() /*throws Exception*/ {
    }
}