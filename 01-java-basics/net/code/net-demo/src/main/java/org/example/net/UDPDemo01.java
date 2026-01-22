package org.example.net;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPDemo01 {
    @Test
    public void send() {
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket();
            byte[] b = "我是要发送的数据".getBytes();
            //创建一个数据包
            DatagramPacket pack = new DatagramPacket(b, 0, b.length, InetAddress.getByName("127.0.0.1"), 9090);

            ds.send(pack);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ds != null) {
                ds.close();
            }
        }

    }

    @Test
    public void rceive() {
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(9090);

            byte[] b = new byte[1024];
            DatagramPacket pack = new DatagramPacket(b, 0, b.length);
            ds.receive(pack);

            String str = new String(pack.getData(), 0, pack.getLength());
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ds != null) {
                ds.close();
            }
        }

    }
}
