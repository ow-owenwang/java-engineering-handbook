package org.example.common.System;

import java.util.Arrays;

/*
 * 将 src 数组中前3个元素，复制到 dest 数组的前3个位置上
 * */
public class arraycopyTest {
    public static void main(String[] args) {

        int[] src = {1, 2, 3, 4, 5};
        int[] dest = {6, 7, 8, 9, 10};

        System.arraycopy(src, 0, dest, 0, 3);
        System.out.println(Arrays.toString(dest));
    }
}
