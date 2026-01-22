package org.example;

/**
 * 由于一个线程在操作共享数据过程中，未执行完毕的情况下，另外的线程参与进来，导致共享数据存在了安全问题。
 * 解决的办法就是必须让一个线程操作共享数据完毕以后，其它线程才有机会参与共享数据的操作。
 * <p>
 * Java 中实现线程的安全的方法：
 * 1. 同步代码块
 * synchronized(同步监视器){
 * 需要被同步的代码块（即为操作共享数据的代码）
 * }
 * <p>
 * 共享数据：多个线程共同操作的同一个数据（变量）
 * 同步监视器：由一个类的对象来充当。哪个线程获取此监视器，谁就执行大括号里的同步代码。俗称：锁
 * 所有线程必须共用同一把锁
 * 在实现的方式中，考虑同步的话，可以使用 this 来充当锁，但是在继承的方式中，慎用 this
 * <p>
 * 2. 同步方法
 * 将操作共享数据的方法声明为 synchronized 。即此方法为同步方法，能够保证当其中一个线程执行此方法时，其它线程在外等待直至此线程执行完此方法
 */
public class Demo05 {
    public static void main(String[] args) {
        Window2 w = new Window2();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window2 implements Runnable {
    int ticket = 100;
    Object obj = new Object();

    //方法一：
    public void run() {
        while (true) {
            synchronized (obj) {
                if (ticket > 0) {
                    // 放大错误
                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "售票，票号为：" + ticket--);
                } else {
                    break;
                }
            }
        }
    }

    //方法二：
    /*public void run() {
        while (true) {
            show();
        }
    }

    public synchronized void show() {
        if (ticket > 0) {
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "售票，票号为：" + ticket--);
        }
    }*/
}