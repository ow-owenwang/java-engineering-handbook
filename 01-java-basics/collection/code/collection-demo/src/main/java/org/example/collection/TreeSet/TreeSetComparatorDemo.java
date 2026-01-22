package org.example.collection.TreeSet;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * TreeSet 和 Comparator 示例
 */
public class TreeSetComparatorDemo {
    public static void main(String[] args) {
        // 使用匿名内部类创建 Comparator
        TreeSet<Integer> integers = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });
        
        integers.add(30);
        integers.add(2);
        integers.add(10);
        System.out.println("TreeSet (匿名内部类): " + integers);
        
        // 使用方法引用创建 Comparator
        Comparator<Integer> com = Integer::compare;
        System.out.println("Comparator 比较结果 (30 vs 2): " + com.compare(30, 2));
    }
}
