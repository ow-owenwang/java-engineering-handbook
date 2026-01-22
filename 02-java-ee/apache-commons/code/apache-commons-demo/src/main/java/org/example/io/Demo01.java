package org.example.io;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Demo01 {
    public static void main(String[] args) throws IOException {

        //使用类加载器来加载类路径下的资源，不能以 / 开始
        //ClassLoader cl = Demo01.class.getClassLoader();
        //InputStream rs = cl.getResourceAsStream("hello.txt");

        //使用 class 来加载类路径下的资源
        InputStream rs = Demo01.class.getResourceAsStream("/hello.txt");

        if (rs != null) {
            String s = IOUtils.toString(rs, StandardCharsets.UTF_8);
            System.out.println(s);
        }

        

    }


}
