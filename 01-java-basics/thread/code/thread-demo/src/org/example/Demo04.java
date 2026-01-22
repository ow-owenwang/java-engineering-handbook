package org.example;

/**
 * 使用实现 Runnable 接口的方式实现售票
 *
 * 此程序存在线程的安全问题：打印车票时，会出现重票、错票
 */
public class Demo04 {
    public static void main(String[] args) {
        Window1 w = new Window1();

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
class Window1 implements Runnable {
    // 注意与另一种方法实现窗口售票类的 ticket 变量，不需要设置为 static，因为多个线程共享这个对象
    int ticket = 100;

    public void run() {
        while (true) {
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