package org.example.datatype.string;

/*
* ==是进行对象的地址值比较，如果确实需要字符串的内容比较
* 需要比较两个字符串的值是否相等可以使用 equals() 方法
* 一般把常量放到前面，"abc".equals(str)，因为变量放到前面可能会出现空指针异常
* */
public class Demo02 {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";
        char[] charArray = {'H', 'e', 'l', 'l', 'o'};
        String str3 = new String(charArray);

        System.out.println(str1.equals(str2));//true
        System.out.println(str1.equals(str3));//true
        System.out.println(str3.equals("Hello"));//true

        String str4 = null;
        System.out.println(str4.equals(str1));//java.lang.NullPointerException

        System.out.println("ABC".equalsIgnoreCase("abc"));//true
    }
}
