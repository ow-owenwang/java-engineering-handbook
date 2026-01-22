package org.example;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class Demo04 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] bytes = "联通".getBytes("gbk");
        for (byte b : bytes) {
            System.out.println(b + "对应的二进制：" + Integer.toBinaryString(b & 255));
        }
    }
}
