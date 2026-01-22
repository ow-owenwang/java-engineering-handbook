package org.example.common.System;

/*
 * 验证 for 循环打印数字1-9999所需要使用的时间（毫秒）。
 * */
public class currentTimeMillisTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        for (int i = 1; i <= 9999; i++) {
            System.out.println(i);
        }

        long end = System.currentTimeMillis();
        System.out.println("程序共耗时：" + (end - start) + "毫秒");
    }
}
