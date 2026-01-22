package org.example.lang;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsDemo01 {

    public static void main(String[] args) {

        //首字母大写
        String hello = StringUtils.capitalize("hello");
        System.out.println(hello);

        //重复拼接字符串
        String abc = StringUtils.repeat("abc", 3);
        System.out.println(abc);

        //判断字符串是否为空
        boolean empty = StringUtils.isEmpty("");
        System.out.println(empty);

        boolean blank = StringUtils.isBlank(" \n \t ");
        System.out.println(blank);


        String s = StringUtils.trimToNull("");
        System.out.println(s);


        String hello1 = StringUtils.abbreviate("abbreviate", 6);
        System.out.println(hello1);


        String[] hello_worlds = StringUtils.split("hello world", " ");
        for (String sw : hello_worlds) {
            System.out.println(sw);
        }


    }
}