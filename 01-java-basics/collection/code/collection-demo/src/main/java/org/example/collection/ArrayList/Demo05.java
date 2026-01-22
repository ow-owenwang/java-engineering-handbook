package org.example.collection.ArrayList;

import java.util.ArrayList;

/*
存储基本类型必须使用包装类

基本类型    包装类（引用类型）
byte        Byte
short       Short
int         Integer     【特殊】
long        Long
float       Float
double      Double
char        Character   【特殊】
boolean     Boolean

从JDK 1.5+开始，支持自动装箱、自动拆箱。
自动装箱：基本类型 --> 包装类型
自动拆箱：包装类型 --> 基本类型
*/
public class Demo05 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        //错误写法
        //ArrayList<int> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list);//[1, 2]


    }
}
