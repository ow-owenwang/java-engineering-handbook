package org.example.common.Random;

import java.util.Random;

/*
* nextInt()：获取一个随机的int数字（范围是int所有范围，有正负两种）
* nextInt(3)：获取一个随机的int数字（参数代表了范围，左闭右开区间）
* 实际上代表的含义是：[0,3)，也就是0~2
* */
public class Demo01 {
    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt();
        System.out.println(i);

        int i1 = random.nextInt(3);
        System.out.println(i1);
    }
}
