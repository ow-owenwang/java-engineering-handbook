package com.example.thread;

import java.util.concurrent.ThreadFactory;

/**
 * ThreadFactory 示例
 * 
 * ThreadFactory 是一个接口，用于创建新线程。
 * 使用 ThreadFactory 可以将线程创建的逻辑集中管理，便于统一配置线程的属性（如线程名、优先级、守护线程等）。
 */
public class ThreadFactoryExample {

    public static void main(String[] args) {
        // 创建一个简单的 ThreadFactory 实现
        ThreadFactory factory = new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable);
            }
        };

        // 使用 ThreadFactory 创建线程
        Thread t1 = factory.newThread(() -> {
            System.out.println("Hello");
        });

        // 启动线程
        t1.start();
    }
}
