package org.example.common.Arrays;

import java.util.Arrays;

/*
 * binarySearch() 使用二分法来搜索指定数组，以获得匹配的元素。
 * 如果在数组中搜索到了要找的元素返回搜索元素的索引值，否则返回-1或插入点。
 * */
public class Demo02 {
    public static void main(String[] args) {
        int[] arr = {4, 25, 10};
        Arrays.sort(arr);
        int index = Arrays.binarySearch(arr, 8);
        System.out.println(index); //-2，不懂！！！

        int index1 = Arrays.binarySearch(arr, 0, 1, 8);
        System.out.println(index1); //-2
    }
}
