package org.example.datatype.typecast;

/*
*
* */
public class Demo04 {
    public static void main(String[] args) {

        //2147483648 作为 int 已经超出范围，所以需要以 long 类型进行赋值
        //int i = 2147483648 - 1;

        int a = (int) (2147483648L - 1);
        long b = 2147483648L - 1;

    }
}
