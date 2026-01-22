package org.example.datatype.typecast;

public class Demo05 {
    public static void main(String[] args) {
        char c = 'A';
        //此处自动类型转换
        int i = c;
        System.out.println(i);//65


        char c1 = '中';
        System.out.println(c1 + 0);//20013
    }
}
