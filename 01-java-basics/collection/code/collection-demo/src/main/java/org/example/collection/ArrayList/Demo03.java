package org.example.collection.ArrayList;

import java.util.ArrayList;

/*
* 常用方法
* */
public class Demo03 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        int size = list.size();
        System.out.println(size);//3

        String remove = list.remove(1);
        System.out.println(remove);//B

        String s = list.get(1);
        System.out.println(s);//C
        System.out.println(list);//[A, C]

    }
}
