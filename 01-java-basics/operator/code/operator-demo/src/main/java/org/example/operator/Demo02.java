package org.example.operator;

public class Demo02 {
    public static void main(String[] args) {
        int i = 1;
        i *= 0.99999;
        System.out.println(i);//0
        System.out.println(i++);//0
        System.out.println(i);//1

        //=============================================

        boolean b1 = false;
        //先赋值再运算，所以会打印1
        if (b1 = true) {
            System.out.println(1);
        } else {
            System.out.println(2);
        }

        System.out.println(b1 = false);//false

        //=============================================

        short s = 3;
        //s = s + 2;//编译不通过
        s += 2;
        System.out.println(s);//5

        //=============================================


    }
}
