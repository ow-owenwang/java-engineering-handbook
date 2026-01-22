package org.example.practice;

import java.util.Arrays;

/*
 * 反转排序
 * 给定一个数组 a{1,2,3,4,5,6} 将这个数组中的元素头尾对应互换位置
 * */
public class ReverseSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int len = arr.length;

        for (int i = 0; i < arr.length / 2; i++) {
            int x = arr[i];
            arr[i] = arr[len - 1 - i];
            arr[len - 1 - i] = x;
        }

        System.out.println(Arrays.toString(arr));

    }
}
