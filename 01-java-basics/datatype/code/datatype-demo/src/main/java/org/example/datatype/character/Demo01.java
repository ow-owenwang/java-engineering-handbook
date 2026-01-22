package org.example.datatype.character;

public class Demo01 {
    public static void main(String[] args) {
        char a = 'a';
        String b = "a";

        System.out.println(b.equals(a));//false

        System.out.println(10 + 'a' + "lll");//107lll
        System.out.println(10 + " " + "lll");//10 lll
        System.out.println('a' + 10);//107

        char c1 = '\\';
        System.out.println(c1);//\
        char c2 = '\u9FA5';
        System.out.println(c2);//龥
        System.out.println('\123');//S

        char c3 = 97;
        System.out.println(c3);//a
    }
}
