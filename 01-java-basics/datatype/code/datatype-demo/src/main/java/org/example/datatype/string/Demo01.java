package org.example.datatype.string;


public class Demo01 {
    public static void main(String[] args) {

        //使用空参构造器创建字符串
        String s1 = new String();//字符串什么内容都没有
        System.out.println(s1 == "");//false

        //通过字符数组创建字符串
        char[] charArr = {'a', 'b', 'c'};
        String s2 = new String(charArr);
        System.out.println(s2);

        //通过字节数组创建字符串
        byte[] byteArr = {97, 98, 99};
        String s3 = new String(byteArr);
        System.out.println(s3);

        //字面量创建
        String s4 = "hello";
        System.out.println(s4);
    }
}
