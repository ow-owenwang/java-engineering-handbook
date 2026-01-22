package org.example.practice;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {63, 4, 24, 1, 3, 15};
        System.out.println(Arrays.toString(sort(arr)));
    }

    public static int[] sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int index = 0;
            for (int j = 1; j <= arr.length - i; j++) {
                if (arr[j] > arr[index]) {
                    index = j;
                }
            }

            int temp = arr[arr.length - i];
            arr[arr.length - i] = arr[index];
            arr[index] = temp;
        }

        return arr;
    }
}
