package org.example.lang;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class SimpleDateFormatDemo01 {
    public static void main(String[] args) throws ParseException {

        //比较原始的方法
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d1 = format.format(new Date());
        System.out.println(d1);

        //使用 DateFormatUtils 工具类
        String d2 = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        String format2 = DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss", TimeZone.getDefault());
        String format3 = DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        System.out.println(d2);
        System.out.println(format2);
        System.out.println(format3);

        Date date = DateUtils.parseDate("2021-05-01 01:01:01", "yyyy-MM-dd HH:mm:ss");
        System.out.println(date.getTime());

        Date date1 = DateUtils.addHours(new Date(), 2);
        String format1 = DateFormatUtils.format(date1, "yyyy-MM-dd HH:mm:ss");
        System.out.println(format1);

    }
}
