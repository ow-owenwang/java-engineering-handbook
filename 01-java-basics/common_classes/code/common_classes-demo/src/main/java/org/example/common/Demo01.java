package org.example.common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo01 {
    public static void main(String[] args) {
        //List集合拼接成以逗号分隔的字符串
        List<String> list = Arrays.asList("a", "b", "c", "d");
        System.out.println(list);

        //1. 利用 String 类的 join 方法
        String str1 = String.join(",", list);
        System.out.println(str1);

        //2. 利用 stream 流
        String str2 = list.stream().collect(Collectors.joining(","));
        System.out.println(str2);
    }
}
