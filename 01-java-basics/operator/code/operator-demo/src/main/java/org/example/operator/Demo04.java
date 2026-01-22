package org.example.operator;

public class Demo04 {
    public static void main(String[] args) {
        /*
        * 过程分析：
        * byte 类型的数值与 int 类型的数值相加，先把 byte 型转为 int 型，然后相加，最后再转化为 byte 型。
        * */
        byte b = 30;
        b += 20;
        System.out.println(b);//50


    }
}
