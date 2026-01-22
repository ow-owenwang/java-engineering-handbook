package org.example;

import java.util.ArrayList;

/*
 * 自动装箱 自动拆箱
 *
 * JDK1.5之后出现的新特性
 * */
public class IntegerDemo02 {
    public static void main(String[] args) {
        //自动装箱：直接把 int 类型的整数赋值包装类
        Integer i = 10;

        //自动拆箱：i 是包装类，无法直接参与运算，可以自动转换为基本数据类型，在进行计算
        i = i + 100;
        System.out.println(i);

        //在 ArrayList 集合中也有所体现
        //ArrayList 集合不支持存储基本类型，只能存储引用类型
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);//自动装箱
        int el1 = list.get(0);//自动拆箱
        System.out.println(el1);
    }
}
