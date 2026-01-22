package org.example.net;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 发送图片
 */
public class SocketDemo02 {
    @Test
    public void client() throws Exception {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9898);
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream(new File("binary.png"));
        byte[] b = new byte[1024];
        int len;
        while ((len = fis.read(b)) != -1) {
            os.write(b, 0, len);
        }
        socket.shutdownOutput();

        InputStream is = socket.getInputStream();
        byte[] b1 = new byte[1024];
        int len1;
        while ((len1 = is.read(b1)) != -1) {
            String str = new String(b1, 0, len1);
            System.out.println(str);
        }

        is.close();
        os.close();
        fis.close();
        socket.close();
    }

    @Test
    public void server() throws Exception {
        ServerSocket ss = new ServerSocket(9898);
        Socket s = ss.accept();
        InputStream is = s.getInputStream();

        FileOutputStream fos = new FileOutputStream(new File("2.jpg"));

        byte[] b = new byte[1024];
        int len;
        while ((len = is.read(b)) != -1) {
            fos.write(b, 0, len);
        }
        OutputStream os = s.getOutputStream();
        os.write("你发送的图片我已接收成功".getBytes());

        os.close();
        fos.close();
        is.close();
        s.close();
        ss.close();
    }
}
