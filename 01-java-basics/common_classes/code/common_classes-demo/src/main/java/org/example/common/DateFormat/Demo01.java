package org.example.common.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo01 {
    public static void main(String[] args) throws ParseException {
        testParse();

        testFormat();
    }

    //使用 DateFormat 类中的方法 parse，把文本解析为日期
    private static void testParse() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        Date date = sdf.parse("2088年08月08日 15时51分54秒");
        System.out.println(date);
    }

    //使用 DateFormat 类中的方法 format，把日期格式化为文本
    private static void testFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        Date date = new Date();
        String d = sdf.format(date);
        System.out.println(d);
    }
}
