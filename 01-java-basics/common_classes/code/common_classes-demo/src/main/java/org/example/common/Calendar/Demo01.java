package org.example.common.Calendar;

import java.util.Calendar;
import java.util.Date;

/*
* static Calendar getInstance()：使用默认时区和语言环境获得一个日历。
* */
public class Demo01 {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c);

        Date time = c.getTime();
        System.out.println(time);


    }
}
