package org.example;

/*
 * 基本类型和字符串类型的相互转换
 *
 * */
public class CastDemo01 {
    public static void main(String[] args) {

        //基本类型-->字符串类型
        int i1 = 100;
        String s = i1 + "" + 200;
        System.out.println(s);//100200

        String s1 = Integer.toString(100);
        System.out.println(s1 + 200);//100200

        String s2 = String.valueOf(100);
        System.out.println(s2 + 200);//100200



        //字符串类型-->基本类型
        int i = Integer.parseInt(s);
        System.out.println(i - 200);//10000

    }
}
