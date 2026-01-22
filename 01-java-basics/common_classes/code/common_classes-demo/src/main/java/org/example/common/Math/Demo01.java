package org.example.common.Math;

public class Demo01 {
    public static void main(String[] args) {
        // 绝对值
        System.out.println(Math.abs(-299));
        System.out.println(Math.abs(-2.8402840));

        // 向上取整
        System.out.println(Math.ceil(3.3));
        System.out.println(Math.ceil(-3.3));
        System.out.println(Math.ceil(5.1));

        // 向下取整
        System.out.println(Math.floor(3.3));
        System.out.println(Math.floor(-3.3));
        System.out.println(Math.floor(5.1));

        // 四舍五入
        System.out.println(Math.round(5.5));
        System.out.println(Math.round(5.4));


        System.out.println(Math.max(1, 100));

        System.out.println(Math.random());
    }
}
