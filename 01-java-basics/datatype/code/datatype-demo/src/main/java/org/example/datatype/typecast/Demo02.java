package org.example.datatype.typecast;


/*
 * 强制类型转换（显式）
 * 当由范围大的类型转为范围小的类型时，不能发生自动转化。
 * 格式：范围小的类型 范围小的变量名 = (范围小的类型) 原本范围大的数据;
 *
 * 强制类型转换一般不推荐使用，因为有可能发生精度损失、数据溢出。
 * byte/short/char 这三种类型在运算的时候，都会被首先提升成为 int 类型，然后再计算。
 * boolean 类型不能发生数据类型转换
 * */
public class Demo02 {
    public static void main(String[] args) {
        int num1 = (int) 100L;
        System.out.println(num1);//100

        int num2 = (int) 6000000000L;
        System.out.println(num2);//1705032704，超过了 int 范围，发生精度损失

        int num3 = (int) 3.99;
        System.out.println(num3);//3，不会四舍五入，直接舍弃小数位

        char c1 = 'A';
        System.out.println(c1 + 1);//66，字符 A 转化为十进制然后进行加运算

        byte b1 = 40;
        byte b2 = 50;
        int num4 = b1 + b2;
        System.out.println(num4);//90，b1和b2会自动转为 int 型，然后进行加运算

        short s1 = 60;
        short s2 = (short) (b1 + s1);
        System.out.println(s2);//100，注意加运算放到括号中，并且结果不要超过 short 范围

        


    }
}
