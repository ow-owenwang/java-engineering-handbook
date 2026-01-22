package org.example.collection.ArrayList;

import java.util.ArrayList;

/*
 * ArrayList 可以指定泛型，指定泛型的 ArrayList，只能存放指定类型的数据。
 * 注意：泛型只能是引用类型，如 Integer，不能是 int。
 * */
public class Demo02 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list);//[]

        list.add("A");
        list.add("B");
        //list.add(123);
        System.out.println(list);//[A, B]
    }
}
