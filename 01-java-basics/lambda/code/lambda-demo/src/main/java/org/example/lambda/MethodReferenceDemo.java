package org.example.lambda;

import java.util.Comparator;

/**
 * 方法引用示例
 * 
 * 方法引用是 Lambda 表达式的简化写法，当 Lambda 表达式只是调用一个已存在的方法时，可以使用方法引用。
 */
public class MethodReferenceDemo {
    public static void main(String[] args) {
        // 使用方法引用替代 Lambda 表达式
        // Lambda 写法: (x, y) -> Integer.compare(x, y)
        // 方法引用写法: Integer::compare
        Comparator<Integer> com = Integer::compare;
        System.out.println("使用方法引用比较 30 和 2: " + com.compare(30, 2));
    }
}
