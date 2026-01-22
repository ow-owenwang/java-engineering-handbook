package org.example.common.Arrays;

import java.util.Arrays;

/*
 * Arrays.copyOf() 用来复制数组。如果指定的长度超过了源数组的长度用默认值填充，整型数组用0填充，char 型数组用 null 填充。
 *
 *
 * */
public class Demo01 {
    public static void main(String[] args) {
        int[] arr1 = new int[5];
        System.out.println(Arrays.toString(arr1));

        Arrays.fill(arr1, 100);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {100, 20, 30, 40};
        Arrays.fill(arr2, 1, 2, 3);
        System.out.println(Arrays.toString(arr2));

        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] newArr = Arrays.copyOf(arr2, 10);
        System.out.println(Arrays.toString(newArr));

        int[] newArr1 = Arrays.copyOfRange(arr2, 1, 3);
        System.out.println(Arrays.toString(newArr1));


    }
}
