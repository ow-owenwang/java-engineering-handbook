package org.example.operator;

public class Demo03 {
    public static void main(String[] args) {

        //短路
        int a = 10;
        System.out.println(3 > 10 && ++a < 100);//false
        System.out.println(a);//10

        //
        System.out.println(3 < 10 || ++a < 100);//true
        System.out.println(a);//10


    }
}
