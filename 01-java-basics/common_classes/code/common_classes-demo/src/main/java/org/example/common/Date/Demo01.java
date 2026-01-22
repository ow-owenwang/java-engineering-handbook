package org.example.common.Date;

import java.util.Date;

public class Demo01 {
    public static void main(String[] args) {
        Date d1 = new Date();
        System.out.println(d1);

        long time = d1.getTime();
        System.out.println(time);

        //new Date().getTime() 和 System.currentTimeMillis()是一样的，都是返回当前时间的毫秒数
        long l = System.currentTimeMillis();
        long time1 = new Date().getTime();
        System.out.println(l);
        System.out.println(time1);

        Date d2 = new Date(0L);
        System.out.println(d2);//Thu Jan 01 08:00:00 CST 1970
        Date d3 = new Date(time);
        System.out.println(d3);


    }
}
