package org.example.oop.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * 接口作为参数时，传递它的子类对象。
 * 接口作为返回值类型时，返回它的子类对象。
 */
public class InterfaceDemo01 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        List<String> list1 = method(list);
        System.out.println(list1.size());
    }

    public static List<String> method(List<String> list) {
        list.add("A");
        list.add("B");

        return list;
    }
}
