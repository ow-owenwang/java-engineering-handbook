package org.example.oop.final_keyword;

/**
 * 对于基本类型来说，不可变说的是变量当中的数据不可改变
 * 对于引用类型来说，不可变说的是变量当中的地址值不可改变
 */
public class FinalDemo04 {
    public static void main(String[] args) {
        final int num;
        num = 1000;
        System.out.println(num);//1000

        //只能有唯一的一次赋值
        /*num = 2000;*/


    }
}
