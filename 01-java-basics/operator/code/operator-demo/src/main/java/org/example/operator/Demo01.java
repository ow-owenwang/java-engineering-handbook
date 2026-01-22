package org.example.operator;

/**
 * 算数运算符
 */
public class Demo01 {
    public static void main(String[] args) {
        // 正号
        int a = 3;
        System.out.println(+a); //3

        // 负号
        int b = 4;
        System.out.println(-b); //-4

        // 加
        System.out.println(10 + 9); //19

        // 减
        System.out.println(100 - 1000); //-900

        // 乘
        System.out.println(10 * 30); //300

        // 除
        System.out.println(90 / 23); //3
        System.out.println(90.3883 / 23); //3.9299260869565216

        // 取模
        System.out.println(7 % 5); //2
        System.out.println(5 % -2); //1
        System.out.println(-100 % 3); //-1
        System.out.println(100 % 3.345); //2.9949999999999943
        System.out.println(1 % 5);//1


        // 字符串相加
        System.out.println("He" + "llo"); //Hello
        System.out.println('*' + '\t' + '*'); //93
        System.out.println("*" + '\t' + '*'); //*	*
        System.out.println("5+5=" + 5 + 5); //5+5=55


        System.out.println(1234 / 1000 * 900);//900
    }
}
