package org.example.net;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class URLDemo01 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.baidu.com/index.html");

        System.out.println(url.getHost());//www.baidu.com

        //将服务端的资源读取进来
        InputStream is = url.openStream();
        byte[] b = new byte[20];
        int len;
        while ((len = is.read(b)) != -1) {
            String str = new String(b, 0, len);
            System.out.println(str);
        }

        is.close();

        URLConnection urlConn = url.openConnection();
        InputStream is1 = urlConn.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("abc.txt"));
        byte[] b1 = new byte[20];
        int len1;
        while ((len1 = is1.read(b1)) != -1) {
            fos.write(b1, 0, len1);
        }
        fos.close();
        is1.close();
    }
}
