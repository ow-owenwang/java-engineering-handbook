package org.example.encoding;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Demo01 {
    public static void main(String[] args) throws UnsupportedEncodingException {

        //ISO8859-1 编码无法表示中文，此处获取中文字符串的字节数组是不正确的
        //所以最后再按照 ISO_8859_1 编码转换为字符串时是乱码??
        byte[] bytes = "中文".getBytes(StandardCharsets.ISO_8859_1);
        System.out.println(Arrays.toString(bytes));

        String s = new String(bytes, "ISO_8859_1");
        System.out.println(s);//??


        byte[] bytes1 = "中文".getBytes(StandardCharsets.UTF_8);
        String s1 = new String(bytes1, "ISO_8859_1");
        System.out.println(s1);//乱码
        byte[] bytes2 = s1.getBytes(StandardCharsets.ISO_8859_1);
        String s2 = new String(bytes2, StandardCharsets.UTF_8);
        System.out.println(s2);//中文
    }
}
