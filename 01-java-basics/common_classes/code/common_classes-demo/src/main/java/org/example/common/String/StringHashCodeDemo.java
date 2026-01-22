package org.example.common.String;

/**
 * String hashCode 示例
 */
public class StringHashCodeDemo {
    public static void main(String[] args) {
        String s = new String("123");
        int i = s.hashCode();
        System.out.println("String '123' 的 hashCode: " + i);
    }
}
