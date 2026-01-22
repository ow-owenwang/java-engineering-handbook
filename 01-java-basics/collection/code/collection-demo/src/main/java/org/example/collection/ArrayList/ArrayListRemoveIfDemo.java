package org.example.collection.ArrayList;

import java.util.ArrayList;

/**
 * ArrayList removeIf 方法示例
 * 
 * removeIf 是 Java 8 引入的方法，使用 Lambda 表达式作为条件
 */
public class ArrayListRemoveIfDemo {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("AA");
        strings.add("BB");
        strings.add("C");
        strings.add("FFF");
        
        System.out.println("原始列表: " + strings);
        
        // 使用 Lambda 表达式移除长度为 3 的字符串
        boolean removed = strings.removeIf(string -> string.length() == 3);
        System.out.println("是否有元素被移除: " + removed);
        System.out.println("移除后的列表: " + strings);
    }
}
