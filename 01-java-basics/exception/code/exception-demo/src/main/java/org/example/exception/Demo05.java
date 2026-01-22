package org.example.exception;

/*
 * 通过 throw 抛出异常演示
 *
 * */
public class Demo05 {
    public static void main(String[] args) {
        //int[] arr = null;
        int[] arr = new int[3];
        int e = getElement(arr, 3);
        System.out.println(e);
    }

    public static int getElement(int[] arr, int index) {
        if (arr == null) {
            throw new NullPointerException("传递的数组的值是 null");
        }

        if (index < 0 || index > arr.length - 1) {
            throw new ArrayIndexOutOfBoundsException("传递的索引超出了数组的使用范围");
        }

        return arr[index];
    }
}
