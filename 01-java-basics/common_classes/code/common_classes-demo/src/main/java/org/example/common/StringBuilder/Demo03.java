package org.example.common.StringBuilder;

/*
 * StringBuilder 和 String 互相转换
 * */
public class Demo03 {
    public static void main(String[] args) {
        String str = "Hello";
        //String --> StringBuilder
        StringBuilder sb = new StringBuilder(str);
        sb.append(" World");
        System.out.println(sb);

        //StringBuilder --> String
        String s = sb.toString();
        System.out.println(s);
    }
}
