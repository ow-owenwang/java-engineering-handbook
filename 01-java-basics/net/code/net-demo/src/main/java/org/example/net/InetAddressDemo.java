package org.example.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inet = InetAddress.getByName("www.baidu.com");
        System.out.println(inet);

        //获取主机名
        String hostName = inet.getHostName();
        //获取域名的 ip 地址
        String hostAddress = inet.getHostAddress();
        System.out.println(hostName + ": " + hostAddress);


        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        //获取本机 ip 地址
        String hostAddress1 = localHost.getHostAddress();
        //获取本机主机名
        String hostName1 = localHost.getHostName();
        System.out.println(hostName1 + ": " + hostAddress1);
    }
}
