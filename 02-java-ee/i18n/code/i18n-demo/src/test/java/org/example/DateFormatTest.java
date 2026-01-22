package org.example;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * DateFormat 是格式化日期的工具类
 *
 * SimpleDateFormat 是 DateFormat 的子类。
 */
public class DateFormatTest {
    @Test
    public void test1(){
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.MEDIUM, Locale.US);
        String date = dateFormat.format(new Date());
        System.out.println(date);
    }

    @Test
    public void test2() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = simpleDateFormat.parse("2020-02-19 19:3:30");
        System.out.println(date);
    }
}
