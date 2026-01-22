package org.example.datatype.string;

/**
 * String 代表不可变的字符序列，底层使用char[] 存放
 * String 是 final 的
 */
public class Demo03 {
    public static void main(String[] args) {
        String str1 = "JavaEE";
        String str2 = "JavaEE";
        String str3 = new String("JavaEE");
        String str4 = "JavaEE" + "Android";
        String str5 = "Android";
        String str6 = str1 + str5;
        str5 = str5 + "Handoop";
        String str7 = str6.intern();
        String str8 = "JavaEEAndroid";
        System.out.println(str1 == str2); //true
        System.out.println(str1 == str3); // false
        System.out.println(str1.equals(str3)); // true
        System.out.println(str4 == str6); // false
        System.out.println(str4.equals(str6)); // true
        System.out.println(str7 == str4); // true
        System.out.println(str4 == str8); // true

        Student p1 = new Student("AA");
        Student p2 = new Student("AA");
        System.out.println(p1.name == p2.name); // true
    }
}

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}