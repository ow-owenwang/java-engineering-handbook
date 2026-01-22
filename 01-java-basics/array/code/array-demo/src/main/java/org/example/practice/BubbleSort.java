package org.example.practice;


import java.util.Arrays;

/*
* 冒泡排序
* 比较相邻的两个值，满足条件就交换位置，较小的元素前移，较大的元素后移，这样较小的元素就像气泡一样从底部上升到顶部。
* */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {63, 4, 24, 1, 3, 15};
        sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return arr;
    }
}
