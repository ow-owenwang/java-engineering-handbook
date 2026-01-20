# Java 线程知识点总结

Java 线程（Thread）是 Java 并发编程的基础，理解线程的创建、管理和同步机制是掌握 Java 并发编程的关键。

## 1. 简介

线程是程序执行的最小单元，Java 通过 `Thread` 类和 `Runnable` 接口提供了多线程编程的能力。多线程可以充分利用多核 CPU，提高程序的执行效率。

## 2. 线程的创建方式

### 2.1 继承 Thread 类
```java
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("线程执行");
    }
}
```

### 2.2 实现 Runnable 接口
```java
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("线程执行");
    }
}
```

### 2.3 使用 Lambda 表达式（推荐）
```java
Thread thread = new Thread(() -> {
    System.out.println("线程执行");
});
```

## 3. ThreadFactory

`ThreadFactory` 是一个接口，用于创建新线程。使用 `ThreadFactory` 可以：
- 集中管理线程创建逻辑
- 统一配置线程属性（线程名、优先级、守护线程等）
- 便于监控和管理线程

### 3.1 基本使用
请参考本目录下的 `code/thread-demo/src/main/java/com/example/thread/ThreadFactoryExample.java` 文件。

## 4. 常用方法

- `start()`: 启动线程
- `run()`: 线程执行的方法
- `join()`: 等待线程执行完成
- `sleep(long millis)`: 线程休眠
- `interrupt()`: 中断线程
- `isAlive()`: 判断线程是否存活

## 5. 线程状态

Java 线程有以下几种状态：
- NEW: 新建状态
- RUNNABLE: 可运行状态
- BLOCKED: 阻塞状态
- WAITING: 等待状态
- TIMED_WAITING: 定时等待状态
- TERMINATED: 终止状态

## 6. 线程同步

多线程环境下，为了保证数据安全，需要使用同步机制：
- `synchronized` 关键字
- `Lock` 接口及其实现类
- `volatile` 关键字
- `Atomic` 原子类

## 7. 示例代码

请参考本目录下的 `code/thread-demo/src/main/java/com/example/thread/` 路径下的代码示例。
