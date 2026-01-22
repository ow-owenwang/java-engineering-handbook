package org.example.practice;

import java.util.Arrays;


public class Demo01 {
    public static void main(String[] args) {
        method01();

        method02();
    }

    //给定两个数组 a{1,2,3,4} b{5,6,7,8} 将两个数组内的元素对应位置互换
    public static void method01() {
        int[] a = {1, 2, 3, 4};
        int[] b = {5, 6, 7, 8};

        for (int i = 0; i < a.length; i++) {
            int x = a[i];
            a[i] = b[i];
            b[i] = x;
        }

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

    //对一个数组进行翻转
    public static void method02() {
        int[] a = {1, 2, 3, 4};
        for (int min = 0, max = a.length - 1; min < max; min++, max--) {
            int temp = a[min];
            a[min] = a[max];
            a[max] = temp;
        }
        System.out.println(Arrays.toString(a));
    }
}
