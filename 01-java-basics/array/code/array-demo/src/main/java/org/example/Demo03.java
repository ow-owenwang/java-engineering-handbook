package org.example;

/*
 * 二维数组
 * */
public class Demo03 {
    public static void main(String[] args) {
        int[][] arrays = new int[3][4];

        for (int[] array : arrays) {
            for (int i : array) {
                System.out.println(i);
            }
            System.out.println();
        }
    }
}
