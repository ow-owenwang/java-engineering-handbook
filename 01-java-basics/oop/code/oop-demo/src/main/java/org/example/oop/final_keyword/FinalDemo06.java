package org.example.oop.final_keyword;

/**
 * 编译器会把 final 修饰的变量当作常量来处理，这是编译器做的优化。
 * 在使用到此变量时，因为看作常量，所以就直接替换成它实际的值。而变量 d 需要在运行时才能确定值。
 */
public class FinalDemo06 {
    public static void main(String[] args) {
        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;
        String e = d + 2;
        System.out.println((a == c));//true
        System.out.println((a == e));//false


        //编译期不知道它的值，所以不能做优化
        final String b1 = method();
        String c1 = b1 + 2;
        System.out.println(a == c1);//false
    }

    public static String method() {
        return "hello";
    }
}