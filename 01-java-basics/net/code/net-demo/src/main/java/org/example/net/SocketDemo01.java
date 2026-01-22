package org.example.net;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 客户端给服务端发送消息，服务端输出此消息到控制台上
 */
public class SocketDemo01 {
    /**
     * 客户端
     */
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        InputStream is = null;

        try {
            //创建一个 Socket 的对象，通过构造器指明服务端的 ip 地址，以及其端口号
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
            os = socket.getOutputStream();
            os.write("我是客户端，请多关照！".getBytes(StandardCharsets.UTF_8));

            //显示的告诉服务端已发送完毕
            socket.shutdownOutput();
            is = socket.getInputStream();
            byte[] b = new byte[20];
            int len;
            while ((len = is.read(b)) != -1) {
                String str = new String(b, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 服务器
     */
    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;

        try {
            ss = new ServerSocket(9090);
            socket = ss.accept();

            is = socket.getInputStream();
            byte[] b = new byte[20];
            int len;
            while ((len = is.read(b)) != -1) {
                String str = new String(b, 0, len);
                System.out.println(str);
            }

            //向客户端写回消息
            os = socket.getOutputStream();
            os.write("我已收到你的情谊".getBytes());

            System.out.println("收到来自于" + socket.getInetAddress().getHostAddress() + "的连接");


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
