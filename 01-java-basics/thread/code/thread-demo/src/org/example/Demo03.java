package org.example;

/**
 * 实现多线程的方法二：
 * 这种方式优于继承的方式，避免了单继承的局限性。
 * 如果多个线程要操作一份资源，更适合使用这种实现方式。
 */
public class Demo03 {
    public static void main(String[] args) {
        PrintNum p = new PrintNum();

        //创建一个线程
        Thread t1 = new Thread(p);
        t1.start();//启动线程

        //再创建一个线程
        Thread t2 = new Thread(p);
        t2.start();
    }
}

//创建一个实现了 Runnable 接口的类
class PrintNum implements Runnable {
    //实现接口的抽象方法
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}