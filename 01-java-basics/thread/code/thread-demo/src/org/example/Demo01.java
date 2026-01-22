package org.example;

/**
 * 创建一个子线程，和主线程执行同样的操作：打印1~100之间自然数
 */
public class Demo01 {
    public static void main(String[] args) {
        MyThread01 myThread01 = new MyThread01();

        //一个线程只能执行一次 start()
        myThread01.start();

        for (int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}

class MyThread01 extends Thread {
    //重写 Thread 类的 run() 方法，方法内实现此子线程要完成的功能
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
