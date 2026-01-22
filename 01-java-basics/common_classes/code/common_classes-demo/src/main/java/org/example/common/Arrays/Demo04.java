package org.example.common.Arrays;

import java.util.Arrays;

/*
 * 请使用 Arrays 相关的 API，将一个随机字符串中的所有字符升序排列，并倒序打印。
 * */
public class Demo04 {
    public static void main(String[] args) {
        String str = "asv76agfqwdfvasdfvjh";
        char[] chars = str.toCharArray();
        System.out.println(chars); //asv76agfqwdfvasdfvjh
        Arrays.sort(chars);//对字符数组进行升序排列

        System.out.println(chars);
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.println(chars[i]);
        }
    }
}
